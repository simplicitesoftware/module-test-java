package com.simplicite.extobjects.TestJava;

import com.simplicite.util.tools.Parameters;

/**
 * Custom REST web service for search and get for users and responsibilities
 */
public class TestJavaRESTExtObject extends com.simplicite.webapp.services.RESTMappedObjectsExternalObject {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void init(Parameters params) {
		setDebug(true);
		setUseCache(true);

		addObject("users", "User");
		addField("users", "login", "usr_login");
		addField("users", "firstname", "usr_first_name");
		addField("users", "lastname", "usr_last_name");
		addField("users", "email", "usr_email");

		addObject("resps", "Responsability");
		addField("resps", "login", "rsp_login_id.usr_login");
		addField("resps", "group", "rsp_group_id.grp_name");
		addField("resps", "startDate", "rsp_start_dt");
		addField("resps", "endDate", "rsp_end_dt");
		addField("resps", "active", "rsp_activ");
		addRefField("resps", "users", "userId", "rsp_login_id");
	}
}
