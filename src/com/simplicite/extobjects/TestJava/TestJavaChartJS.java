package com.simplicite.extobjects.TestJava;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.simplicite.util.tools.Parameters;
import com.simplicite.util.Tool;

public class TestJavaChartJS extends com.simplicite.webapp.web.ResponsiveExternalObject {
	private static final long serialVersionUID = 1L;
	
	private static final int N = 15;

	@Override
	public Object service(Parameters params) {
		JSONArray labels = new JSONArray();
		JSONArray data = new JSONArray();

		int n = Tool.randomInt(0, 100);
		for (int i = 0; i < N; i++) {
			labels.put("Value #" + (i + 1));
			data.put(n + Tool.randomInt(10, 20));
		}
		
		return new JSONObject()
			.put("title", "Chart generated on " + new Date())
			.put("labels", labels)
			.put("name", "Random values")
			.put("data", data);
	}
}
