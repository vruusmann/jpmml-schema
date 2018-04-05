package org.jpmml.schema;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.jpmml.evaluator.ModelEvaluator;
import org.jpmml.evaluator.ModelField;

public class SchemaModule extends SimpleModule {

	public SchemaModule(){
		addSerializer(ModelEvaluator.class, new ModelEvaluatorSerializer());
		addSerializer(ModelField.class, new ModelFieldSerializer());
	}
}