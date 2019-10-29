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
	/*public static String postPlatformInit(Grant sys) {
		return "Hello Simplicite (" + sys.getLogin() + ")!";
	}*/

	/**
	 * Event hook
	 */
	/*public static String event(Grant g, String origin, Object data) throws Exception
	{
		return data.getClass().getName();	
	}*/

	/**
	 * Pre load grant hook
	 */
	public static void preLoadGrant(Grant g) {
		try {
			AppLog.info(GrantHooks.class, "preLoadGrant", "Grant " + g.getLogin() + " (endpoint " + g.getEndpoint() + ") pre load (java) !", null);
		} catch (Exception e) {
			AppLog.error(GrantHooks.class, "preLoadGrant", null, e, null);
		}
	}

	/**
	 * Post load grant hook
	 */
	public static void postLoadGrant(Grant g) {
		try {
			AppLog.info(GrantHooks.class, "postLoadGrant", "Grant " + g.getLogin() + " (endpoint " + g.getEndpoint() + ") post load (java) !", null);
		} catch (Exception e) {
			AppLog.error(GrantHooks.class, "preLoadGrant", null, e, null);
		}
	}
}