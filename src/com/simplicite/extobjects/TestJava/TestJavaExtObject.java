package com.simplicite.extobjects.TestJava;

import java.io.InputStream;
import java.util.Date;

import com.simplicite.util.Globals;
import com.simplicite.util.Tool;
import com.simplicite.util.AppLog;
import com.simplicite.util.ExternalObject;
import com.simplicite.util.tools.Parameters;

import org.json.JSONObject;

import org.apache.commons.io.IOUtils;

import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStore;
import org.jclouds.blobstore.BlobStoreContext;
import org.jclouds.blobstore.domain.Blob;
import org.jclouds.blobstore.domain.MutableBlobMetadata;
import org.jclouds.blobstore.options.PutOptions;

/**
 * Test external object
 */
public class TestJavaExtObject extends ExternalObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Display method
	 * @param params Parameters
	 */
	@Override
	public String display(Parameters params) {
		StringBuilder h = new StringBuilder();
		try {
			JSONObject config = getGrant().getJSONObjectParameter("TESTJAVA_AWS_S3_CONFIG");
			if (Tool.isEmpty(config)) throw new Exception("Missing configuration");
			h.append(config.toString(2));
			
			//BlobStoreContext context = ContextBuilder.newBuilder("aws-s3").credentials(config.optString("accessKeyId"), config.optString("secretAccessKey")).buildView(BlobStoreContext.class);
			String bucketName = config.optString("bucketName");
/*
			BlobStore store = context.getBlobStore();
			if (!store.containerExists(bucketName))
				store.createContainerInLocation(null, bucketName);

			String name = "test.html";
			String mime = "text/html";
			String content = "<html><body>hello world " + new Date() + "!</body></html>";
			String encoding = Globals.getPlatformEncoding();

			Blob blob = store.blobBuilder(name).payload(content.getBytes(encoding)).contentType(mime).build();

			PutOptions mp = PutOptions.Builder.multipart();
			store.putBlob(bucketName, blob, mp);

			blob = store.getBlob(bucketName, name);
			MutableBlobMetadata md = blob.getMetadata();
			h.append("<p>ETag: " + md.getETag() + "</p>");
			String uri = md.getUri().toString();
			h.append("<p>URI: <a href=\"" + uri + "\">" + uri + "</a></p>");

			InputStream is = blob.getPayload().openStream();
			String c = IOUtils.toString(is, encoding);
			h.append("<p>Content: " + Tool.toHTML(c));
			
			h.append("<p><a href=\"" + params.getLocation() + "\">" + getGrant().T("REFRESH") + "</a></p>");

			context.close();
*/
		} catch (Exception e) {
			AppLog.error(getClass(), "display", null, e, getGrant());
			h.append("<p>" + e.getMessage() + "</p>");
		}
		return h.toString();
	}
}