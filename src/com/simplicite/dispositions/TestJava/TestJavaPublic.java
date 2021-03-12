package com.simplicite.dispositions.TestJava;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

public class TestJavaPublic extends Disposition {
	private static final long serialVersionUID = 1L;

	@Override
	public String displayPublic(Parameters params) {
		try {
			return "<h1>Public home page</h1><a href=\"/ui/\">Login</a><pre class=\"mono\">" + params.toString() + "</pre>";
		} catch (Exception e) {
			AppLog.error(null, e, getGrant());
			return e.getMessage();
		}
	}
}
