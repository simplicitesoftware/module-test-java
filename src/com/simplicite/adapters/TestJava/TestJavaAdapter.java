package com.simplicite.adapters.TestJava;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.simplicite.util.AppLog;
import com.simplicite.util.integration.SimpleJSONAdapter;

import com.simplicite.commons.TestJava.TestJavaCommon;

/**
 * Java adapter for JSON array data:
 * e.g: [{"name":"a","value":"A"},{"name":"b","value":"B"}]
*/
public class TestJavaAdapter extends SimpleJSONAdapter {
	private static final long serialVersionUID = 1L;

	/**
	 * Process JSON data
	 */
	@Override
	public String process(JSONTokener t) {
		try {
			AppLog.info(getClass(), "process", TestJavaCommon.helloworld() + " from adapter " + getName(), getGrant());
			JSONArray a = new JSONArray(t);
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < a.length(); i++) {
				JSONObject o = a.getJSONObject(i);
				AppLog.info(getClass(), "process", o.toString(2), getGrant());
				res.append("<!-- " + o.getString("name") + " = " + o.getString("value") + " -->\n");
			}
			AppLog.info(getClass(), "process", "Adapter result: " + res, getGrant());
			return res.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}