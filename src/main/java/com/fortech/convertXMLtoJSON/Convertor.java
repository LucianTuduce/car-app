package com.fortech.convertXMLtoJSON;

import org.json.JSONObject;
import org.json.XML;

public class Convertor {

	public static final int PRETTY_PRINT_INDENT_FACTOR = 4;
	
	public static String convertXMLtoJSON(final String xml) {
		JSONObject jsonpObject = XML.toJSONObject(xml);
		String prettyJson = jsonpObject.toString(PRETTY_PRINT_INDENT_FACTOR);
		System.out.println(prettyJson);
		String json = createSimpleJSON(prettyJson);
		System.out.println(json);
		return json;
	}

	public static String createSimpleJSON(final String json) {
		String a = "";
		boolean canIdoIt = false;
		for (int i = 1; i < json.length(); i++) {
			char c = json.charAt(i);
			if (c == '{' || canIdoIt) {
				a = a + c;
				canIdoIt = true;
			}
			if (c == '}') {
				break;
			}
		}

		return a;
	}
	
}
