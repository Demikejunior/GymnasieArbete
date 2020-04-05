package model.dataInterpretation;

public class ToPitch extends LinearTransformation {
	private Double DPMin, DPMax;
	private Double ParamMinNote = 25.0;
	private Double ParamMaxNote = 61.0;

	public void ToNote(Double DPMin, Double DPMax) {
		this.DPMin = DPMin;
		this.DPMax = DPMax;
	}

	public Double ToHZ(Double DPValue) {
		return Math.pow(2, (ToPianoNote(DPValue) - ParamMaxNote) / 12.0) * 880;
	}

	public Double ToPianoNote(Double DPValue) {
		return ValueTransform(DPValue, DPMin, DPMax, ParamMinNote, ParamMaxNote);
	}
}
