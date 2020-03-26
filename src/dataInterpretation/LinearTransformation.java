package dataInterpretation;

public abstract class LinearTransformation {
	private Double Transform(Double DPValue, Double DPMin, Double DPMax, Double ParamMin, Double ParamMax) {
		Double DPOut = 0.0;

		DPOut = ((DPValue - DPMin) / (DPMax - DPMin)) * (ParamMax - ParamMin) + (ParamMin);

		return DPOut;
	}
}
