package com.simplicite.commons.TestJava;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Tools
 */
public class TestJavaTools implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private static final String HELLO = "Hello";
	
	/**
	 * Test tool method
	 */
	public String getHello() {
		return HELLO;
	}
}
