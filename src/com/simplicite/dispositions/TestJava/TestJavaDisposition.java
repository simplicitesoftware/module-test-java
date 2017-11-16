package com.simplicite.dispositions.TestJava;

import com.simplicite.util.Disposition;
import com.simplicite.util.tools.HTMLTool;
import com.simplicite.util.tools.Parameters;

/**
 * Java disposition
 */
public class TestJavaDisposition extends Disposition {
	private static final long serialVersionUID = 1L;

	/**
	 * Display public page
	 */
	@Override
	public String displayPublic(Parameters params) {
		return "<p>Public page (java)!</p>" +
			"<p><a href=\"" + HTMLTool.getUIRoot() + "\">" + getGrant().T("CONNECT") + "</a>";
	}
}