package com.simplicite.objects.TestJava;

import java.util.List;

import com.simplicite.commons.TestJava.TestJavaCommon;
import com.simplicite.util.AppLog;
import com.simplicite.util.ObjectDB;

/**
 * Test business object
 */
public class TestJavaObject extends ObjectDB {
	private static final long serialVersionUID = 1L;

	/**
	 * Post-load hook
	 */
	@Override
	public void postLoad() {
		try {
			AppLog.info(getClass(), "postLoad", TestJavaCommon.helloworld() + " from " + getName(), getGrant());
			AppLog.info(getClass(), "postLoad", "Post load (java)", getGrant());
		} catch (Exception e) {}
	}

	/**
	 * Init update hook
	 */
	@Override
	public void initUpdate() {
		AppLog.info(getClass(), "initUpdate", "Init update (java) for " + getRowId(), getGrant());
	}

	/**
	 * Pre validate hook
	 */
	@Override
	public List<String> preValidate() {
		AppLog.info(getClass(), "preValidate", "Pre Validate (java) for " + getRowId(), getGrant());
		return null;
	}

	/**
	 * Post validate hook
	 */
	@Override
	public List<String> postValidate() {
		AppLog.info(getClass(), "postValidate", "Post validate (java) for " + getRowId(), getGrant());
		/*
		ArrayList<String> errs = new ArrayList<String>();
		errs.add("This is a blocking error");
		return errs;
		*/
		return null;
	}

	/**
	 * User key label hook
	 */
	 @Override
	public String getUserKeyLabel(String[] row) {
		return "Record #" + (row==null ? getRowId() : row[0]);
	}
}