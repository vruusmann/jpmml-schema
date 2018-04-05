package org.jpmml.schema;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.jpmml.evaluator.Evaluator;
import org.jpmml.evaluator.ModelEvaluator;

public class ModelEvaluatorSerializer extends JsonSerializer<ModelEvaluator> {

	@Override
	public void serialize(ModelEvaluator modelEvaluator, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
		Evaluator evaluator = (Evaluator)modelEvaluator;

		Map<String, Object> evaluatorSchema = new LinkedHashMap<>();
		evaluatorSchema.put("summary", evaluator.getSummary());
		evaluatorSchema.put("miningFunction", (evaluator.getMiningFunction()).toString().toLowerCase());

		// The following are Lists of org.jpmml.evaluator.ModelField subclasses
		evaluatorSchema.put("inputFields", evaluator.getInputFields());
		evaluatorSchema.put("targetFields", evaluator.getTargetFields());
		evaluatorSchema.put("outputFields", evaluator.getOutputFields());

		generator.writeObject(evaluatorSchema);
	}
}