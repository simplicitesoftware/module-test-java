package com.simplicite.dispositions.TestJava;

import com.simplicite.util.AppLog;
import com.simplicite.util.Disposition;
import com.simplicite.util.Globals;
import com.simplicite.util.tools.Parameters;

/**
 * Java disposition
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
			return "<p>Hello Java World!</p><p><a href=\"" + Globals.WEB_UI_PATH + "?scope=Home\">" + getGrant().T("HOME") + "</a></p>";
		} catch (Exception e) {
			AppLog.error(getClass(), "display", null, e, getGrant());
			return e.getMessage();
		}
	}
}