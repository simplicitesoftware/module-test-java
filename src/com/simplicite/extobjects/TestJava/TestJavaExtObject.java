package com.simplicite.extobjects.TestJava;

import com.simplicite.util.AppLog;
import com.simplicite.util.ExternalObject;
import com.simplicite.util.tools.Parameters;

/**
 * Test external object
 */
public class TestJavaExtObject extends ExternalObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Display method
	 * @param params Parameters
	 */
	@Override
	public String display(Parameters params) {
		String h = "Hello (external object) World!";
		AppLog.info(getClass(), "display", h + " from " + getClassName(), getGrant());
		return h + "<br/><a href=\"" + params.getLocation() + "\">" + getGrant().T("REFRESH") + "</a>";
	}
}