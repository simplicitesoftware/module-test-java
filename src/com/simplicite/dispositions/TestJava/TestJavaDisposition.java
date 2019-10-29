package com.simplicite.dispositions.TestJava;

import com.simplicite.commons.TestJava.TestJavaCommon;
import com.simplicite.util.AppLog;
import com.simplicite.util.Disposition;
import com.simplicite.util.Globals;
import com.simplicite.util.tools.HTMLTool;
import com.simplicite.util.tools.Parameters;
import com.simplicite.webapp.web.BootstrapWebPage;

/**
 * Custom Java disposition
 */
public class TestJavaDisposition extends Disposition {
	private static final long serialVersionUID = 1L;

	/**
	 * Main page display method
	 * @param params Request parameters
	 */
	@Override
	public String display(Parameters params) {
		try {
			BootstrapWebPage p = new BootstrapWebPage("Custom disposition");
			p.appendCore(getGrant()); // Global variables for current user
			p.appendAjax(); // Ajax API

			p.appendHTML("<div id=\"grant\">...</div>"
				+ "<div><a href=\"" + HTMLTool.getUIRoot() + "?scope=Home\">" + getGrant().T("HOME") + "</a></div>");

			p.setReady("var app = new Simplicite.Ajax(); app.getGrant(function(g) { $('#grant').text('Hello ' + g.firstname + ' ' + g.lastname +  ' (' + g.login + ')'); });");

			return p.toString();
		} catch (Exception e) {
			AppLog.error(getClass(), "display", null, e, getGrant());
			return e.getMessage();
		}
	}
}