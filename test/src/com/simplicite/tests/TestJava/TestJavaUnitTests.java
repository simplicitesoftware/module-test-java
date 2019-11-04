package com.simplicite.tests.TestJava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.simplicite.util.Globals;
import com.simplicite.util.Grant;

/**
 * Unit tests TestJavaUnitTests
 */
public class TestJavaUnitTests {
	@Test
	public void test() {
		try {
			assertEquals(Globals.getSystemLogin(), Grant.getSystemAdmin().getLogin());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
