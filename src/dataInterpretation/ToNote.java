package dataInterpretation;

public class ToNote extends LinearTransformation {
	private Double DPMin, DPMax;
	private Double ParamMinHZ = 110.0;
	private Double ParamMaxHZ = 880.0;
	private Double ParamMinNote =

	public void ToNote(Double DPMin, Double DPMax) {
		this.DPMin = DPMin;
		this.DPMax = DPMax;
	}

	public Double ToHZ(Double DPValue) {
		return ValueTransform(DPValue, DPMin, DPMax, ParamMinHZ, ParamMaxHZ);
	}

	public Double ToPianoNote(Double DPValue) {

	}
}
