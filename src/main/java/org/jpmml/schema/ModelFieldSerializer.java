package org.jpmml.schema;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.jpmml.evaluator.ModelField;

public class ModelFieldSerializer extends JsonSerializer<ModelField> {

	@Override
	public void serialize(ModelField modelField, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
		Map<String, Object> modelFieldSchema = new LinkedHashMap<>();
		modelFieldSchema.put("name", (modelField.getName()).getValue());
		modelFieldSchema.put("dataType", (modelField.getDataType()).toString().toLowerCase());
		modelFieldSchema.put("opType", (modelField.getOpType()).toString().toLowerCase());

		generator.writeObject(modelFieldSchema);
	}
}