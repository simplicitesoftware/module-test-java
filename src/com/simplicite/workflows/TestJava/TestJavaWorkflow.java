package com.simplicite.workflows.TestJava;

import com.simplicite.util.Grant;
import com.simplicite.util.AppLog;
import com.simplicite.util.Message;
import com.simplicite.bpm.Processus;

import com.simplicite.commons.TestJava.TestJavaCommon;

/**
 * Test workflow
 */
public class TestJavaWorkflow extends Processus {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Post instantiate hook
	 */
	@Override
	public void postInstantiate(Grant g) {
		AppLog.info(getClass(), "postInstantiate", TestJavaCommon.helloworld() + " from " + getName(), g);
		AppLog.info(getClass(), "postInstantiate", "Post instantiate (java)", g);
	}
	
	/**
	 * Pre activate hook
	 */
	@Override
	public Message preActivate() {
		AppLog.info(getClass(), "preActivate", "Pre activate (java)", getGrant());
		return null;
	}
	
	/**
	 * Post activate hook
	 */
	@Override
	public void postActivate() {
		AppLog.info(getClass(), "postActivate", "Post activate (java)", getGrant());
	}
}