package com.simplicite.commons.TestJava;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplicite.util.AppLog;
import com.simplicite.util.Grant;
import com.simplicite.util.SessionInfo;
import com.simplicite.webapp.tools.ServletTool;
import com.simplicite.webapp.web.WebPage;

/**
 * Grant hooks
 */
public class PlatformHooks extends com.simplicite.util.engine.PlatformHooksInterface {
	/**
	 * Post platform init hook
	 */
	@Override
	public String postPlatformInit(Grant sys) {
		try {
			AppLog.info("Hello Simplicite (" + sys.getLogin() + ")!", sys);
		} catch (Throwable e) {
			AppLog.error(null, e, null);
		}
		return super.postPlatformInit(sys);
	}

	/*
	 * Custom start page
	 *
	@Override
	public void customStartPage(HttpServletRequest request, HttpServletResponse response) {
		try (PrintWriter out = response.getWriter()) {
			ServletTool.setHTTPHeadersForHTML(request, response);
			WebPage wp = new WebPage(Grant.getSystemAdmin().getParameter("WINDOW_TITLE"));
			wp.append("<p>This is a custom start page.<br/><a href=\"/ui/\">Login</a></p>");
			out.println(wp.toString());
		} catch (Throwable e) {
			AppLog.error(null, e, null);
		}
	}*/

	/**
	 * Pre load grant hook
	 */
	@Override
	public void preLoadGrant(Grant g) {
		try {
			if (!g.isPublic()) {
				SessionInfo info = g.getSessionInfo();
				AppLog.info("Grant " + g.getLogin() + (info!=null ? ", session info " + info.toString() : "") + " (endpoint " + g.getEndpoint() + ") pre load (java) !", null);
			}
		} catch (Throwable e) {
			AppLog.error(null, e, null);
		}
	}

	/**
	 * Post load grant hook
	 */
	@Override
	public void postLoadGrant(Grant g) {
		try {
			if (!g.isPublic()) {
				SessionInfo info = g.getSessionInfo();
				AppLog.info("Grant " + g.getLogin() + (info!=null ? ", token " + g.getSessionInfo().getToken() + ", ID token " + g.getSessionInfo().getIDToken() + ", refresh token " + g.getSessionInfo().getRefreshToken() : "") + " (endpoint " + g.getEndpoint() + ") post load (java) !", g);
			}
		} catch (Throwable e) {
			AppLog.error(null, e, null);
		}
	}
	
	/**
	 * Event hook
	 */
	@Override
	public String event(Grant g, String origin, Object data) throws Exception
	{
		try {
			AppLog.info("Event: " + origin + " = " + data.toString() + ")!", g);
		} catch (Throwable e) {
			AppLog.error(null, e, null);
		}
		return super.event(g, origin, data);	
	}

	/**
	 * Social post hook
	 */
	@Override
	public void socialPost(Grant g, String postId) {
		try {
			AppLog.info("Social post by " + g.getLogin() + " (" + postId + ")", g);
		} catch (Throwable e) {
			AppLog.error(null, e, null);
		}
	}
	
	/* Unit tests method (for versions 5.1+)
	@Override
	public String unitTests() {
		try {
			return "Unit tests";
		} catch (Exception e) {
			AppLog.error(null, e, null);
			return e.getMessage();
		}
	}*/
}