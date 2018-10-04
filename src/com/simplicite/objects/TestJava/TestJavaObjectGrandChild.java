package com.simplicite.objects.TestJava;

import com.simplicite.util.AppLog;

/**
 * Test business object (grand child)
 */
public class TestJavaObjectGrandChild extends TestJavaObjectChild {
	private static final long serialVersionUID = 1L;

	/**
	 * Post-load hook
	 */
	@Override
	public void postLoad() {
		try {
			super.postLoad();
			AppLog.info(getClass(), "postLoad", "Post load grand child (java)", getGrant());
		} catch (Exception e) {}
	}
}