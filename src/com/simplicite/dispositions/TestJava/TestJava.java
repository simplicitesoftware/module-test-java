package com.simplicite.dispositions.TestJava;

import com.simplicite.util.AppLog;
import com.simplicite.util.Disposition;
import com.simplicite.util.tools.HTMLTool;
import com.simplicite.util.tools.HTTPTool;
import com.simplicite.util.tools.Parameters;
import com.simplicite.webapp.web.BootstrapWebPage;

/**
 * Custom Java disposition
 */
public class TestJava extends Disposition {
	private static final long serialVersionUID = 1L;

	/**
	 * Main page display method
	 * @param params Request parameters
	 */
	@Override
	public String display(Parameters params) {
		try {
			AppLog.info("Custom disposition = " + getName(), getGrant());
			BootstrapWebPage p = new BootstrapWebPage("Custom disposition (Java)");
			p.appendCore(getGrant()); // Global variables for current user
			p.appendAjax(); // Ajax API

			p.appendHTML("<div id=\"grant\">...</div>"
				+ "<div><a href=\"" + HTMLTool.getUIRoot() + "?scope=Home\">" + getGrant().T("HOME") + "</a></div>");

			p.setReady(
			//	"console.log('Token = " + getGrant().getSessionInfo().getToken() + "');" +
				"var app = new Simplicite.Ajax(); app.getGrant(function(g) { $('#grant').text('Hello ' + g.firstname + ' ' + g.lastname +  ' (' + g.login + ')'); });"
			);

			return p.toString();
		} catch (Throwable e) {
			AppLog.error(null, e, getGrant());
			return e.getMessage();
		}
		//return redirect("https://dazoulay.dev.simplicite.io/web-demo/?endpoint=ui&url=" + HTTPTool.encode(params.getContextURL()) + "&token=" + getGrant().getSessionInfo().getToken());
		//return "Hello world";
	}
}