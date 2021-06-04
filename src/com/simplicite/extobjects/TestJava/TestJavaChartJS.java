package com.simplicite.extobjects.TestJava;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.simplicite.util.AppLog;
import com.simplicite.util.Tool;
import com.simplicite.util.tools.Parameters;

public class TestJavaChartJS extends com.simplicite.webapp.web.ResponsiveExternalObject {
	private static final long serialVersionUID = 1L;

	private static final int NB = 20; // Nb values
	private static final int START = 1000; // Start value
	private static final int INC = 100; // Random increment

	/**
	 * Service method (called in POST): generates chart data
	 * @param params Parameters
	 * @return Chart data
	 */
	@Override
	public Object service(Parameters params) {
		String obj = params.getParameter("object");
		String rowId = params.getParameter("row_id");
		AppLog.info("Object = " + obj + ", row ID = " + rowId, getGrant());
		
		// Number of values = static parameter of the external object or the default value
		int nb = params.getIntParameter("nb", NB);

		// Start value = value of a dedicated object field or the default value
		int start = params.getIntParameter("start", START);

		// Start value = value of a dedicated object field or the default value
		int inc = params.getIntParameter("inc", INC);
		
		JSONArray labels = new JSONArray();
		JSONArray data = new JSONArray();
		var v = start;
		for (int i = 0; i < nb; i++) {
			labels.put("Value " + (i + 1));
			data.put(v);
			v += Tool.randomInt(0, inc);
		}
		
		return new JSONObject()
			.put("title", "Chart generated on " + new Date() + (!Tool.isEmpty(obj) ? " for " + obj + " (row ID = " + rowId + ")": ""))
			.put("labels", labels)
			.put("name", nb + " random values from " + start + " (increment = " + inc + ")")
			.put("data", data);
	}
}
