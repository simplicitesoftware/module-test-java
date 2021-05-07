package com.simplicite.objects.TestJava;

import org.json.*;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Service object
 */
public class TestServiceObject extends ObjectService {
	private static final long serialVersionUID = 1L;
	
	private JSONArray data = null;

	@Override
	public void postLoad() {
		try {
			data = new JSONArray(getDefaultSearchSpec()); // load JSON array data from the object's filter
		} catch (JSONException e) {
			AppLog.error(null, e, getGrant());
			data = new JSONArray();
		}
 	}

	@Override
	public long countService() {
		return data.length();
	}

	@Override
	public List<String[]> searchService(boolean pagine) {
			List<String[]> rows = new ArrayList<String[]>();
		try {
			for (int i = 0; i < data.length(); i++) {
				JSONObject o = data.getJSONObject(i);
				rows.add(new String[] {
					String.valueOf(i+1), // Pseudo row ID = array index + 1 (ZZZ must be > 0 ZZZ)
					o.getString("code"),
					o.getString("label")
				});
			}
		} catch (JSONException e) {
			AppLog.error(null, e, getGrant());
		}
		return rows;
	}

	@Override
	public boolean selectService(String rowId, boolean copy) {
		try {
			JSONObject o = data.getJSONObject(Tool.parseInt(rowId) - 1);
			setRowId(rowId);
			setFieldValue("testjSrvCode", o.getString("code"));
			setFieldValue("testjSrvLabel", o.getString("label"));
			return true;
		} catch (JSONException e) {
			AppLog.error(null, e, getGrant());
			return false;
		}
	}
}
