package com.simplicite.objects.TestJava;

import java.util.List;
import com.simplicite.util.AppLog;
import com.simplicite.util.ObjectDB;

/**
 * Test business object child of User
 */
public class TestJavaUser extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Post-load hook
	 */
	@Override
	public void postLoad() {
		AppLog.info(getClass(), "postLoad", "Post load (java)", getGrant());
	}
	
	/**
	 * Pre validate hook
	 */
	@Override
	public List<String> preValidate() {
		AppLog.info(getClass(), "preValidate", "Pre Validate (java) for " + getRowId(), getGrant());
		return null;
	}
}
