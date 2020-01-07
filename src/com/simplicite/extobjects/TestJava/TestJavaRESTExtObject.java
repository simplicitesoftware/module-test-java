package com.simplicite.extobjects.TestJava;

import org.json.JSONObject;

import com.simplicite.util.exceptions.HTTPException;
import com.simplicite.util.tools.Parameters;

/**
 * Custom REST web service
 */
public class TestJavaRESTExtObject extends com.simplicite.webapp.services.RESTServiceExternalObject {
	private static final long serialVersionUID = 1L;

	@Override
	public Object get(Parameters params) throws HTTPException {
		return error(200, "Call me in POST please!");
	}

	@Override
	public Object post(Parameters params) throws HTTPException {
		try {
			JSONObject req = params.getJSONObject();
			if (req != null ) {
				return new JSONObject()
					.put("request", req)
					.put("response", "Hello " + req.optString("name", "Unknown"));
			} else {
				return error(200, "Call me with a request please!");
			}
		} catch (Exception e) {
			return error(e);
		}
	}
}
