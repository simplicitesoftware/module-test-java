package com.simplicite.objects.TestJava;

import com.simplicite.util.AppLog;

/**
 * Test business object
 */
public class TestJavaObjectChild extends TestJavaObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Post-load hook
	 */
	@Override
	public void postLoad() {
		try {
			super.postLoad();
			AppLog.info(getClass(), "postLoad", "Post load child (java)", getGrant());
		} catch (Exception e) {}
	}
}