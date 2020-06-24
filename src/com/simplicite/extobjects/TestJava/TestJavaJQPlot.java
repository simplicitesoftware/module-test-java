package com.simplicite.extobjects.TestJava;

public class TestJavaJQPlot extends com.simplicite.webapp.web.ResponsiveExternalObject {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getRenderStatement(com.simplicite.util.tools.Parameters params) {
		addJQPlot(); // Tell the UI to load JQPlot if needed
		return super.getRenderStatement(params);
	}
}
