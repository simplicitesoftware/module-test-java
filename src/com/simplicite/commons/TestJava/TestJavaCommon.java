package com.simplicite.commons.TestJava;

/**
 * Commons
 */
public class TestJavaCommon {
	/**
	 * Nested private class
	 */
	private class Hello {
		private String text;
		
		public Hello() {
			text = new TestJavaTools().getHello();
		}
		
		public String getText() {
			return text;
		}
	}
	
	private String name;
	
	/**
	 * Constructor
	 */
	public TestJavaCommon(String name) {
		this.name = name;
	}
	
	/**
	 * Test method
	 */
	public String hello() {
		return new Hello().getText() + " " + name;
	}

	/**
	 * Static test method
	 */
	public static String helloworld() {
		String h = new TestJavaTools().getHello() + " world!";
		return h;
	}
}