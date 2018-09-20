package org.datatransformer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class Csv2Java {

	private InputStream stream;

	public Csv2Java() {

	}

	public Csv2Java(InputStream stream) throws FileNotFoundException {
		this.stream = stream;
	}

	public Csv2Java(File file) throws FileNotFoundException {
		stream = new FileInputStream(file);
	}

	@SuppressWarnings("deprecation")
	public List<Map<String, Object>> read(InputStream stream) throws JsonProcessingException, IOException {
		List<Map<String, Object>> response = new LinkedList<Map<String, Object>>();
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = CsvSchema.emptySchema().withHeader();
		MappingIterator<Map<String, String>> iterator = mapper.reader(Map.class).with(schema).readValues(stream);
		while (iterator.hasNext()) {
			response.add(Collections.<String, Object>unmodifiableMap(iterator.next()));
		}
		return response;
	}

	@SuppressWarnings("deprecation")
	public List<Map<String, Object>> read() throws JsonProcessingException, IOException {
		if (this.stream == null) {
			throw new RuntimeException("Exception occured. No data to convert.");
		}
		List<Map<String, Object>> response = new LinkedList<Map<String, Object>>();
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = CsvSchema.emptySchema().withHeader();
		MappingIterator<Map<String, String>> iterator = mapper.reader(Map.class).with(schema).readValues(stream);
		while (iterator.hasNext()) {
			response.add(Collections.<String, Object>unmodifiableMap(iterator.next()));
		}
		
		return response;
	}
}
