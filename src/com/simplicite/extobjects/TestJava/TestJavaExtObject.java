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
		AppLog.info(getClass(), "display", TestJavaCommon.helloworld() + " from external object " + getName(), getGrant());
		return javascript(getName() + ".render();");
	}
}