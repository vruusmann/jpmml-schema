package org.jpmml.schema;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.ModelEvaluator;
import org.jpmml.evaluator.ModelEvaluatorFactory;

public class Main {

	static
	public void main(String... args) throws Exception {

		if(args.length != 2){
			System.err.println("Usage: java " + Main.class.getName() + " <PMML input file> <Model Schema-as-JSON output file>");

			System.exit(-1);
		}

		PMML pmml;

		try(InputStream is = new FileInputStream(args[0])){
			pmml = org.jpmml.model.PMMLUtil.unmarshal(is);
		}

		ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();

		ModelEvaluator<?> modelEvaluator = modelEvaluatorFactory.newModelEvaluator(pmml);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new SchemaModule());
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objectMapper.disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, SerializationFeature.WRITE_NULL_MAP_VALUES);

		try(OutputStream os = new FileOutputStream(args[1])){
			objectMapper.writeValue(os, modelEvaluator);
		}
	}
}