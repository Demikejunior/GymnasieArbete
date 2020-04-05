package model.dataInterpretation;

public abstract class LinearTransformation {
	protected Double ValueTransform(Double DPValue, Double DPMin, Double DPMax, Double ParamMin, Double ParamMax) {
		Double DPOut = 0.0;

		DPOut = ((DPValue - DPMin) / (DPMax - DPMin)) * (ParamMax - ParamMin) + (ParamMin);

		return DPOut;
	}
}
