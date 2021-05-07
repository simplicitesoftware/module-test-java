package com.simplicite.objects.TestJava;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.simplicite.commons.TestJava.TestJavaCommon;
import com.simplicite.util.AppLog;
import com.simplicite.util.ObjectDB;
import com.simplicite.util.ObjectField;
import com.simplicite.util.DocumentDB;
import com.simplicite.util.Message;
import com.simplicite.util.tools.HTMLTool;
import com.simplicite.util.tools.RESTTool;
import com.simplicite.util.tools.Base64Tool;

/**
 * Test business object
 */
public class TestjObject extends ObjectDB {
	private static final long serialVersionUID = 1L;

	/**
	 * Post-load hook
	 */
	@Override
	public void postLoad() {
		try {
			AppLog.info(TestJavaCommon.helloworld() + " from " + getName(), getGrant());
			AppLog.info("Post load (java)", getGrant());
		} catch (Exception e) {}
	}

	/**
	 * Pre validate hook
	 */
	@Override
	public List<String> preValidate()
	{
		AppLog.info("Pre Validate (java) for " + getRowId(), getGrant());
		/*
		ArrayList<String> errs = new ArrayList<String>();
		errs.add("This is a non blocking error");
		return errs;
		*/
		return null;
	}

	/**
	 * Post validate hook
	 */
	@Override
	public List<String> postValidate() {
		AppLog.info("Post validate (java) for " + getRowId(), getGrant());
		/*
		ArrayList<String> errs = new ArrayList<String>();
		errs.add("This is a blocking error");
		return errs;
		*/
		return null;
	}

	@Override
	public String preSave() {
		ObjectField d = getField("testjObjDocument");
		if (!d.isEmpty()) try {
			DocumentDB doc = d.getDocument();

			JSONObject res = new JSONObject(
				RESTTool.post(new JSONObject()
					.put("name", doc.getPath())
					.put("data", Base64Tool.encodeBytes(doc.getBytes(true))),
				HTMLTool.getPublicExternalObjectURL("TestjEDM")));

			setFieldValue("testjObjDocumentURL", res.getString("url"));
		} catch (Throwable e) {
			return Message.formatSimpleError(e);
		}

		return null;
	}
	
	/**
	 * Init create hook
	 */
	@Override
	public void initCreate() {
		getField("testjObjDocumentURL").setVisible(ObjectField.VIS_NOT);	
	}
	
	/**
	 * Init copy hook
	 */
	@Override
	public void initCopy() {
		initCreate();
	}
	
	/**
	 * Init update hook
	 */
	@Override
	public void initUpdate() {
		AppLog.info("Init update (java) for " + getRowId(), getGrant());

		ObjectField f = getField("testjObjDocumentURL");
		f.setVisible(f.isEmpty() ? ObjectField.VIS_NOT : ObjectField.VIS_FORM);
	}

	/**
	 * Init delete hook
	 */
	@Override
	public void initDelete() {
		initUpdate();
	}
	
	/**
	 * User key label hook
	 */
	 @Override
	public String getUserKeyLabel(String[] row) {
		return "Record #" + (row==null ? getRowId() : row[0]);
	}
	
	/**
	 * Unit tests
	 */
	@Override
    public String unitTests() {
        try {
            // TODO
            return "OK";
        } catch (Exception e) {
            AppLog.error("Unit tests failure", e, getGrant());
            return e.getMessage();
        }
    }
}