package com.simplicite.extobjects.TestJava;

/**
 * Basic responsive UI component external object
 */
public class TestJavaExtObject extends com.simplicite.webapp.web.ResponsiveExternalObject {
	private static final long serialVersionUID = 1L;
}

// Legacy examples
/*
public class TestJavaExtObject extends ExternalObject {
	@Override
	public String display(Parameters params) {
		// Same logic as the ResponsiveExternalObject helper class
		return javascript(getName() + ".render(" + params.toJSON() + ");");

		// Example 1: return javascript statement
		//setHTML("Hello world!");
		//return javascript("console.log('Hello world!');");

		// Example 2: TinyMCE editor page
		//appendCSSIncludes(HTMLTool.htmleditorCSS());
		//appendJSIncludes(HTMLTool.htmleditorJS());
		//setHTML("<textarea id=\"myeditor\" style=\"width: 100%; height: 200px;\">Hello world!</textarea>");
		//return javascript("tinymce.init({ selector: '#myeditor' });");

		// Example 3: jQplot chart editor page
		//appendCSSIncludes(HTMLTool.jqplotCSS());
		//appendJSIncludes(HTMLTool.jqplotJS());
		//setHTML("<div id=\"mychart\" style=\"width: 400px; height: 300px;\"></div>");
		//return javascript("$.jqplot('mychart', [[['Europe', 25],['Americas', 14],['Asia', 7]]], { seriesDefaults: { renderer: $.jqplot.PieRenderer }, legend:{ show: true } });");

		// Example 4: Google maps page
		//appendJSIncludes(HTMLTool.gmapJS());
		//setHTML("<div id=\"mymap\" style=\"width: 400px; height: 400px;\"></div>");
		//return javascript("Simplicite.Gmap.simpleDisplay('mymap', 2.3509871, 8.8566667);");

		// Example 5: Fullcalendar page
		//setHTML("<div id=\"mycalendar\" class=\"calendar\"></div>");
		//return javascript(
		//	"$ui.loadCalendar(function() {" +
		//		"$('#mycalendar').fullCalendar({ defaultView: 'agendaWeek', timezone: 'local', editable: false });" +
		//	"});"
		//);
	}
}
*/