package com.simplicite.extobjects.TestJava;

import org.json.JSONObject;

import com.simplicite.util.exceptions.HTTPException;
import com.simplicite.util.AppLog;
import com.simplicite.util.Tool;
import com.simplicite.util.tools.Base64Tool;
import com.simplicite.util.tools.FileTool;
import com.simplicite.util.tools.HTTPTool;
import com.simplicite.util.tools.Parameters;

/**
 * Test EDM
 */
public class TestjEDM extends com.simplicite.webapp.services.RESTServiceExternalObject {
	private static final long serialVersionUID = 1L;

	private static final String DIR = "/tmp/";
	
	@Override
	public Object get(Parameters params) throws HTTPException
	{
		try {
			String name = params.getParameter("name");
			byte[] data = FileTool.readFileAsBytes(DIR + name);
			
			//return new JSONObject().put("name", name).put("data", Base64Tool.encodeBytes(data));
			return new String(data);
		} catch(Exception e) {
			throw new HTTPException(e);
		}
	}

	@Override
	public Object post(Parameters params) throws HTTPException
	{
		try {
			JSONObject req = params.getJSONObject();
			String name = req.getString("name");
			byte[] data = Base64Tool.decode(req.getString("data"));
			FileTool.writeFile(DIR + name, data);
	
			return new JSONObject().put("name", name).put("url", getGrant().getContextURL() + params.getBaseURI() + "?name=" + HTTPTool.encode(name));
		} catch(Exception e) {
			throw new HTTPException(e);
		}
	}
}
