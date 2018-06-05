package com.simplicite.commons.TestJava;

public class TestJavaCommon {
	public class Hello {
		private String text;
		
		public Hello() {
			text = "Hello";
		}
		
		public String getText() {
			return text;
		}
	}
	
	public static String helloworld() {
		String h = "Hello world!";
		return h;
	}
	
	private String name;
	
	public TestJavaCommon(String name) {
		this.name = name;
	}
	
	public String hello() {
		return new Hello().getText() + " " + name;
	}
}