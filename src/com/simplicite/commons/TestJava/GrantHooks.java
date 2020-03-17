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
			if (!g.isPublic())
				AppLog.info(GrantHooks.class, "preLoadGrant", "Grant " + g.getLogin() + ", session info " + g.getSessionInfo().toString() + " (endpoint " + g.getEndpoint() + ") pre load (java) !", null);
		} catch (Throwable e) {
			AppLog.error(GrantHooks.class, "preLoadGrant", null, e, null);
		}
	}

	/**
	 * Post load grant hook
	 */
	public static void postLoadGrant(Grant g) {
		try {
			//AppLog.info(GrantHooks.class, "postLoadGrant", "Grant " + g.getLogin() + ", session info " + g.getSessionInfo().toString() + " (endpoint " + g.getEndpoint() + ") post load (java) !", null);
			if (!g.isPublic())
				AppLog.info(GrantHooks.class, "postLoadGrant", "Grant " + g.getLogin() + ", token " + g.getSessionInfo().getToken() + ", ID token " + g.getSessionInfo().getIDToken() + ", refresh token " + g.getSessionInfo().getRefreshToken() + " (endpoint " + g.getEndpoint() + ") post load (java) !", null);
		} catch (Throwable e) {
			AppLog.error(GrantHooks.class, "postLoadGrant", null, e, null);
		}
	}
	
	public static void socialPost(Grant g, String postId) {
		try {
			AppLog.info(GrantHooks.class, "socialPost", "Social post by " + g.getLogin() + " (" + postId + ")", null);
		} catch (Throwable e) {
			AppLog.error(GrantHooks.class, "socialPost", null, e, null);
		}
	}
}