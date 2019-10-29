package com.simplicite.objects.TestJava;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.simplicite.util.AppLog;
import com.simplicite.util.ObjectField;
import com.simplicite.util.ObjectService;
import com.simplicite.util.Tool;

public class TestJavaService extends ObjectService {
	private static final long serialVersionUID = 1L;

	private static long N = 3;

	@Override
	public long countService() {
		AppLog.info(getClass(), "countService", "Count = " + N, getGrant());
		return N;
	}

	private static final String xml =
			"<?xml version=\"1.0\"?>\n" +
			"<company>\n" +
			"	<staff>\n" +
			"		<firstname>yong</firstname>\n" +
			"		<lastname>mook kim</lastname>\n" +
			"		<nickname>mkyong</nickname>\n" +
			"		<salary>100000</salary>\n" +
			"	</staff>\n" +
			"	<staff>\n" +
			"		<firstname>low</firstname>\n" +
			"		<lastname>yin fong</lastname>\n" +
			"		<nickname>fong fong</nickname>\n" +
			"		<salary>200000</salary>\n" +
			"	</staff>\n" +
			"</company>";

	@Override
	public List<String[]> searchService(boolean pagine)
	{
		AppLog.info(getClass(), "searchService", "Begin", getGrant());
		List<String[]> rows = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] row = new String[getFields().size()];
			for (ObjectField f : getFields()) {
				String val = Tool.randomString(10);
				AppLog.info(getClass(), "searchService", f.getFullInput() + "[" + i + "] = " + val, getGrant());
				row[f.getIndex(this)] = val;
			}
			rows.add(row);
		}
		AppLog.info(getClass(), "searchService", "End", getGrant());
		return rows;
	}

	@Override
	public boolean selectService(String rowId, boolean copy)
	{
		AppLog.info(getClass(), "selectService", "Begin", getGrant());
		for (ObjectField f : getFields()) {
			String val = Tool.randomString(10);
			AppLog.info(getClass(), "selectService", f.getFullInput() + " = " + val, getGrant());
			f.setValue(val);
		}
		try {
			SAXParserFactory.newInstance().newSAXParser().parse(Tool.toInputStream(xml), new DefaultHandler() {
				@Override
				public void startDocument() throws SAXException {
					AppLog.info(getClass(), "selectService.startDocument", "Start document", getGrant());
				}

				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					AppLog.info(getClass(), "selectService.startElement", "Start element: URI=" + uri + ", localName=" + localName + ", qName=" + qName + ", nbAttributes=" + attributes.getLength(), getGrant());
				}

				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {
					String val = new String(ch, start, length).trim();
					if (val.length() > 0)
						AppLog.info(getClass(), "selectService.characters", "Start start=" + start + ", length=" + length + ", data=[" + val + "]", getGrant());
				}

				@Override
				public void endElement(String uri, String localName, String qName) throws SAXException {
					AppLog.info(getClass(), "selectService.endElement", "End element: URI=" + uri + ", localName=" + localName + ", qName=" + qName, getGrant());
				}

				@Override
				public void endDocument() throws SAXException {
					AppLog.info(getClass(), "selectService.endDocument", "End document", getGrant());
				}
			});
		} catch (Exception e) {
			AppLog.error(getClass(), "selectService", null, e, getGrant());
		}
		AppLog.info(getClass(), "selectService", "End", getGrant());
		return true;
	}
}