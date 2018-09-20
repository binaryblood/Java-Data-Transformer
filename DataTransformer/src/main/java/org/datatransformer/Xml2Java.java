package org.datatransformer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

public class Xml2Java {

	private InputStream stream;

	Xml2Java(InputStream stream) {
		this.stream = stream;
	}


	private static InputStream getInputStreamFromString(String string)
	{
		InputStream stream = new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
		return stream;
	}
	
	public List<Map<String, Object>> read() throws IOException
	{
		String xml = IOUtils.toString(stream);
	    XMLSerializer xmlSerializer = new XMLSerializer();
	    JSON json = xmlSerializer.read(xml);
	    System.out.println(json.toString());
	    Json2Java obj = new Json2Java(getInputStreamFromString(json.toString()));
	    return obj.read();
	}
}
