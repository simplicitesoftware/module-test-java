package com.simplicite.extobjects.TestJava;

import com.simplicite.util.tools.Parameters;
import com.simplicite.util.tools.JSONTool;

/**
 * Custom mapped REST web service for search and get for users and responsibilities
 */
public class TestJavaMappedRESTExtObject extends com.simplicite.webapp.services.RESTMappedObjectsExternalObject {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(Parameters params) {
		setDebug(true);
		setUseCache(true);

		setOpenAPIVersion(JSONTool.OPENAPI_OAS2);
		setOpenAPIDesc("This is a **custom API** for various business object\n\n- System parameters\n- Users\n- Responsibilities\n\n> NB: these are system objets");

		addObject("params", "SystemParam", "This is the **system parameter** object");
		addField("params", "code", "sys_code", "This is the system parameter **code**", "TEST_CODE");
		addField("params", "value", "sys_value", "This is the system parameter **value**", "Test value");
		addField("params", "type", "sys_type", "This is the system parameter **type**", null); // Example is taken from list of values

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
