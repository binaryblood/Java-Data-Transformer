package org.datatransformer;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Controller {

	SerializeObject serializer;

	SerializeObject getSerializer()
	{
		if(this.serializer == null)
		{
			serializer = new SerializeObject();
		}
		return this.serializer;
	}
	public String csvToJson(InputStream stream) throws JsonProcessingException, IOException
	{
		return this.getSerializer().toCsv(new Csv2Java().read(stream));
	}
	
	public String csvToXml(InputStream stream) throws JsonProcessingException, IOException
	{
		return this.getSerializer().toXml(new Csv2Java().read(stream));
	}
	public String jsonToCsv(InputStream stream) throws JsonProcessingException, IOException
	{
		return this.getSerializer().toCsv(new Json2Java(stream).read());
	}
	public String jsonToXml(InputStream stream) throws JsonProcessingException, IOException
	{
		return this.getSerializer().toXml(new Json2Java(stream).read());
	}
	public String xmlToCsv(InputStream stream) throws JsonProcessingException, IOException
	{
		return this.getSerializer().toCsv(new Xml2Java(stream).read());
	}
	public String xmlToJson(InputStream stream) throws JsonProcessingException, IOException
	{
		return this.getSerializer().toJson(new Xml2Java(stream).read());
	}
}
