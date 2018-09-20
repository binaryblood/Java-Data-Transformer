package org.datatransformer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.XML;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class SerializeObject {

	public SerializeObject() {
	}

	public String toJson(List<Map<String, Object>> array) {
		JSONArray jarr = new JSONArray(array);
		return jarr.toString();
	}

	public String toCsv(List<Map<String, Object>> array) throws IOException {
		Writer writer = new StringWriter();
		csvWriter(array, writer);
		return writer.toString();
	}

	public static void csvWriter(List<Map<String, Object>> listOfMap, Writer writer) throws IOException {
		CsvSchema schema = null;
		CsvSchema.Builder schemaBuilder = CsvSchema.builder();
		if (listOfMap != null && !listOfMap.isEmpty()) {
			for (String col : listOfMap.get(0).keySet()) {
				schemaBuilder.addColumn(col);
			}
			schema = schemaBuilder.build().withLineSeparator("\r").withHeader();
		}
		CsvMapper mapper = new CsvMapper();
		mapper.writer(schema).writeValues(writer).writeAll(listOfMap);
		writer.flush();
	}

	public String toXml(List<Map<String, Object>> array) throws IOException {
		SerializeObject t = new SerializeObject();
		String json = t.toJson(array);
		System.out.println("json is " + json);
		return json2xml(json);
	}

	public static String json2xml(String json) throws IOException {
		JSONArray jsonObject = new JSONArray(json);
		String xml = XML.toString(jsonObject, "root");
		return xml;
	}
}
