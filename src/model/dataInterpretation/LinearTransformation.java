package model.dataInterpretation;

public abstract class LinearTransformation {
	protected Double ValueTransform(Double DPValue, Double DPMin, Double DPMax, Double ParamMin, Double ParamMax) {
		Double ParOut = 0.0;

		ParOut = ((DPValue - DPMin) / (DPMax - DPMin)) * (ParamMax - ParamMin) + (ParamMin);

		return ParOut;
	}
}
