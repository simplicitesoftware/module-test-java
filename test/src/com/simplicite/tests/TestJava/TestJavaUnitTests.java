package com.simplicite.tests.TestJava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.simplicite.util.Globals;
import com.simplicite.util.Grant;
import com.simplicite.util.AppLog;

/**
 * Unit tests TestJavaUnitTests
 */
public class TestJavaUnitTests {
	@Test
	public void test() {
		try {
			Grant sys = Grant.getSystemAdmin();
			
			AppLog.info(getClass(), "test", "System user: " + sys.toString(), sys);
			assertEquals(Globals.getSystemLogin(), sys.getLogin());

			Grant g = new Grant();
			String login = "admin";
			g.init(login, sys.getSessionId(), sys.getEndpoint(), null, null);
			AppLog.info(getClass(), "test", "User: " + g.toString(), sys);
			assertEquals(login, g.getLogin());
			g.destroy();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
