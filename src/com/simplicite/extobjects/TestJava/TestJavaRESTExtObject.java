package com.simplicite.extobjects.TestJava;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.json.JSONArray;
import org.json.JSONObject;

import com.simplicite.util.AppLog;
import com.simplicite.util.DataCache;
import com.simplicite.util.Grant;
import com.simplicite.util.ObjectDB;
import com.simplicite.util.ObjectField;
import com.simplicite.util.exceptions.HTTPException;
import com.simplicite.util.tools.Parameters;

/**
 * Custom REST web service for search and get (for patterns like <code>/api[/ext]/TestJavaRESTExtObject/users[/&lt;user ID&gt;[/resps[/&lt;resp ID&gt;]]]<code>)
 */
public class TestJavaRESTExtObject extends com.simplicite.util.RESTServiceExternalObject {
	private static final long serialVersionUID = 1L;

	private static HashMap<String, String> objectNames = new HashMap<>();
	private static HashMap<String, String> fkNames = new HashMap<>();
	private static HashMap<String, DualHashBidiMap<String, String>> fieldNames = new HashMap<>();
	static {
		objectNames.put("users", "User");
		DualHashBidiMap<String, String> fields = new DualHashBidiMap<>();
		fields.put("usr_login", "login");
		fields.put("usr_first_name", "firstname");
		fields.put("usr_last_name", "lastname");
		fields.put("usr_email", "email");
		fieldNames.put("users", fields);

		objectNames.put("resps", "Responsability");
		fields = new DualHashBidiMap<>();
		fields.put("rsp_login_id.usr_login", "login");
		fields.put("rsp_group_id.grp_name", "group");
		fields.put("rsp_start_dt", "startdate");
		fields.put("rsp_end_dt", "endate");
		fields.put("rsp_activ", "active");
		fields.put("rsp_login_id", "user");
		fieldNames.put("resps", fields);
		fkNames.put("users:resps", "user");

		// TODO: to be completed: other objects
	}

	private static DataCache<Object> cache = new DataCache<>(Grant.getSystemAdmin().getIntParameter("TEST_CACHE_SIZE", 1000), Grant.getSystemAdmin().getIntParameter("TEST_CACHE_EXPIRY", 60));

	private String cacheKey(Parameters params, String objName, String rowId) {
		DualHashBidiMap<String, String> fields = fieldNames.get(objName);
		StringBuilder key = new StringBuilder(objName);
		if (rowId != null) key.append("/").append(rowId);
		for (String k : fields.keySet()) {
			String f = fields.get(k);
			if (params.hasParam(f))
				key.append(":").append(f).append("=").append(params.getParameter(f));
		}
		return key.toString();
	}

	private JSONArray search(Parameters params, String objName) throws Exception {
		ObjectDB obj = null;
		try {
			// First try in cache...
			String key = cacheKey(params, objName, null);
			JSONArray c = (JSONArray)cache.get(key);
			if (c!=null) return c;
			// ...or request it from database

			String o = objectNames.get(objName);
			obj = borrowAPIObject(o);
			//AppLog.info(getClass(), "search", "Using " + obj.getInstanceName(), getGrant());
			if (obj == null) throw new HTTPException(500, "Unable to borrow object " + o);
			DualHashBidiMap<String, String> fields = fieldNames.get(objName);

			obj.resetFilters();
			for (ObjectField f : obj.getFields())
				if (params.hasParam(fields.get(f.getName())))
					f.setFilter(params.getParameter(fields.get(f.getName())).replace('*', '%').replace('?', '_'));

			int[] idx = new int[fields.size()];
			String[] flds = new String[fields.size()];
			int i = 0;
			for (String k : fields.keySet()) {
				idx[i] = obj.getFieldIndex(k);
				flds[i++] = fields.get(k);
			}

			JSONArray l = new JSONArray();
			for (String[] row : obj.search()) {
				JSONObject r = new JSONObject().put("row_id", row[0]);
				for (i = 0; i < fields.size(); i++)
					if (idx[i] >= 0) r.put(flds[i], row[idx[i]]);
				l.put(r);
			}

			// Store in cache
			cache.put(key, l);

			return l;
		} finally {
			if (obj!=null)
				returnAPIObject(obj);
		}
	}

	private JSONObject select(Parameters params, String objName, String rowId) throws Exception {
		ObjectDB obj = null;
		try {
			// First try in cache...
			String key = cacheKey(params, objName, rowId);
			JSONObject c = (JSONObject)cache.get(key);
			if (c!=null) return c;
			// ...or request it from database

			String o = objectNames.get(objName);
			obj = borrowAPIObject(o);
			//AppLog.info(getClass(), "select", "Using " + obj.getInstanceName(), getGrant());
			if (obj == null) throw new HTTPException(500, "Unable to borrow object " + o);
			DualHashBidiMap<String, String> fields = fieldNames.get(objName);

			obj.resetFilters();
			for (ObjectField f : obj.getFields()) // TODO: improve parent row ID constraint enforcement
				if (f.getType()==ObjectField.TYPE_ID && params.hasParam(fields.get(f.getName())))
					f.setFilter(params.getParameter(fields.get(f.getName())));

			if (!obj.select(rowId))
				return notFound("No " + obj.getName() + " record found for row ID " + rowId);

			JSONObject r = new JSONObject().put("row_id", obj.getRowId());
			for (String k : fields.keySet()) {
				ObjectField f = obj.getField(k, false);
				if (f != null) r.put(fields.get(k), obj.getFieldValue(k));
			}

			// Store in cache
			cache.put(key, r);

			return r;
		} finally {
			if (obj!=null)
				returnAPIObject(obj);
		}
	}

	@Override
	public Object get(Parameters params) throws HTTPException {
		long t0 = new Date().getTime();
		try {
			List<String> parts = getURIParts();
			if (parts.size()==0 || objectNames.get(parts.get(0))==null)
				return badRequest(parts.size()==0 ? "No object" : "Object " + parts.get(0)  + " unknown");

			if (parts.size()==1)
				return search(params, parts.get(0));
			else if (parts.size()==2)
				return select(params, parts.get(0), parts.get(1));
			else {
				// TODO: make this generic & recursive
				params.setParameter(fkNames.get(parts.get(0) + ":" + parts.get(2)), parts.get(1)); // Add filter on parent row ID
				if (parts.size()==3)
					return search(params, parts.get(2));
				else
					return select(params, parts.get(2), parts.get(3));
			}
		} catch(Exception e) {
			AppLog.error(getClass(), "get", null, e, getGrant());
			return error(e);
		} finally {
			AppLog.info(getClass(), "get", "Elapsed time " + (new Date().getTime() - t0) + "ms", getGrant());
		}
	}
}
