package by.htp.entity;

import java.util.HashMap;
import java.util.Map;

public class PredictionResult {
	Map<Predection, Answer> predictionResult = new HashMap<>();

	public Map<Predection, Answer> getPredictionResult() {
		return predictionResult;
	}

	public void setPredictionResult(Map<Predection, Answer> predictionResult) {
		this.predictionResult = predictionResult;
	}
}
