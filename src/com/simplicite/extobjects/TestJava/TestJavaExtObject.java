package com.simplicite.extobjects.TestJava;

import com.simplicite.commons.TestJava.TestJavaCommon;
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
		try {
			String hello = "Hello (external object) World!";
			StringBuilder h = new StringBuilder("<p>" + hello + "</p>");
			h.append("<p>" + new TestJavaCommon(getGrant().getLogin()).hello() + "</p>");
			AppLog.info(getClass(), "display", TestJavaCommon.helloworld() + " from external object " + getName(), getGrant());
			return h + "<p><a href=\"" + params.getLocation() + "\">" + getGrant().T("REFRESH") + "</a></p>";
		} catch (Exception e) {
			AppLog.error(getClass(), "display", null, e, getGrant());
			return e.getMessage();
		}
	}
}