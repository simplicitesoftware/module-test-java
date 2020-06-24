package com.simplicite.extobjects.TestJava;

import com.simplicite.commons.TestJava.TestJavaCommon;
import com.simplicite.util.AppLog;
import com.simplicite.util.ExternalObject;
import com.simplicite.util.tools.Parameters;

/**
 * Test external object
 */
public class TestJavaExtObject extends ExternalObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Display method
	 * @param params Parameters
	 */
	@Override
	public String display(Parameters params) {
		AppLog.info(getClass(), "display", TestJavaCommon.helloworld() + " from external object " + getName(), getGrant());
/*
		setHTML("Hello world!");
		return javascript("console.log('Hello world!');");
*/
/*
		appendCSSIncludes(HTMLTool.htmleditorCSS());
		appendJSIncludes(HTMLTool.htmleditorJS());
		setHTML("<textarea id=\"myeditor\" style=\"width: 100%; height: 200px;\">Hello world!</textarea>");
		return javascript("tinymce.init({ selector: '#myeditor' });");
*/
/*
		appendCSSIncludes(HTMLTool.jqplotCSS());
		appendJSIncludes(HTMLTool.jqplotJS());
		setHTML("<div id=\"mychart\" style=\"width: 400px; height: 300px;\"></div>");
		return javascript("$.jqplot('mychart', [[['Europe', 25],['Americas', 14],['Asia', 7]]], { seriesDefaults: { renderer: $.jqplot.PieRenderer }, legend:{ show: true } });");
*/
/*
		appendJSIncludes(HTMLTool.gmapJS());
		setHTML("<div id=\"mymap\" style=\"width: 400px; height: 400px;\"></div>");
		return javascript("Simplicite.Gmap.simpleDisplay('mymap', 2.3509871, 8.8566667);");
*/
/*
		setHTML("<div id=\"mycalendar\" class=\"calendar\"></div>");
		return javascript(
			"$ui.loadCalendar(function() {" +
				"$('#mycalendar').fullCalendar({ defaultView: 'agendaWeek', timezone: 'local', editable: false });" +
			"});"
		);
*/
		return javascript(getName() + ".render(" + params.toJSON() + ");");
	}
}