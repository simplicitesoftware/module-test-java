package com.simplicite.commons.TestJava;

import com.simplicite.util.AppLog;
import com.simplicite.util.Grant;
import com.simplicite.util.GrantHooksInterface;

/**
 * Grant hooks
 */
public class GrantHooks extends GrantHooksInterface {
	/**
	 * Post platform init hook
	 */
	public static String postPlatformInit(Grant sys) {
		return "Hello Simplicite (" + sys.getLogin() + ")!";
	}

	/**
	 * Post load grant hook
	 */
	public static void postLoadGrant(Grant g) {
		AppLog.info(GrantHooks.class, "postLoadGrant", "Grant " + g.getLogin() + " (endpoint " + g.getEndpoint() + ") loaded (java) !", g);
	}
}