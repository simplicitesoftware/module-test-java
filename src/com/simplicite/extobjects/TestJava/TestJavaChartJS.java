package com.simplicite.extobjects.TestJava;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.simplicite.util.AppLog;
import com.simplicite.util.Tool;
import com.simplicite.util.tools.Parameters;

public class TestJavaChartJS extends com.simplicite.webapp.web.ResponsiveExternalObject {
	private static final long serialVersionUID = 1L;

	private static final int N = 15;

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
		
		JSONArray labels = new JSONArray();
		JSONArray data = new JSONArray();

		int n = params.getIntParameter("n", N);
		int v = Tool.randomInt(0, 100);
		for (int i = 0; i < n; i++) {
			labels.put("Value " + (i + 1));
			data.put(v + Tool.randomInt(10, 20));
		}
		
		return new JSONObject()
			.put("title", "Chart generated on " + new Date() + (!Tool.isEmpty(obj) ? " for " + obj + " (row ID = " + rowId + ")": ""))
			.put("labels", labels)
			.put("name", n + " random values")
			.put("data", data);
	}
}
