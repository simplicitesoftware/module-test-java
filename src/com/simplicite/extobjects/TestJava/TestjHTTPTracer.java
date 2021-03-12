package com.simplicite.extobjects.TestJava;

import com.simplicite.util.tools.Parameters;

public class TestjHTTPTracer extends com.simplicite.util.ExternalObject {
	private static final long serialVersionUID = 1L;

	@Override
	public Object display(Parameters params) {
		try {
			setHTML("<pre class=\"mono\">" + params.toJSONObject().toString(2) + "</pre>");
		} catch (Exception e) {
			setHTML(e.getMessage());
		}
		return javascript("void(0);");
	}
}
