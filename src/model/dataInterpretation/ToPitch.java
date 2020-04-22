package model.dataInterpretation;

public class ToPitch extends LinearTransformation {
	private Double DPMin, DPMax;
	private Double ParamMinNote = 25.0;
	private Double ParamMaxNote = 61.0;
	
	// Ability to externally interact with pitch range
	
	/**
	 * Get the lowest note the object allows
	 * @return
	 */
	public Double getParamMinNote() {
		return ParamMinNote;
	}
	
	/**
	 * Set the lowest note the object allows
	 * @param paramMinNote
	 */
	public void setParamMinNote(Double paramMinNote) {
		ParamMinNote = paramMinNote;
	}
	
	/**
	 * Get the highest note the object allows
	 * @return
	 */
	public Double getParamMaxNote() {
		return ParamMaxNote;
	}
	
	/**
	 * Set the
	 * @param paramMaxNote
	 */
	public void setParamMaxNote(Double paramMaxNote, Double paramMaxFrequency) {
		ParamMaxNote = paramMaxNote;
	}
	
	/**
	 *  Constructor for ToPitch objects
	 *
	 * @param DPMin
	 * @param DPMax
	 */
	public ToPitch(Double DPMin, Double DPMax) {
		this.DPMin = DPMin;
		this.DPMax = DPMax;
	}
	
	/**
	 * Get the frequency value of the object
	 *
	 * @param DPValue
	 * @return ParOut
	 */
	public Double ToHZ(Double DPValue) {
		return Math.pow(2, (ToPianoNote(DPValue) - 61) / 12.0) * 880;
	}
	
	/**
	 * Get the note value of the object
	 *
	 * @param DPValue
	 * @return ParOut
	 */
	public Double ToPianoNote(Double DPValue) {
		return ValueTransform(DPValue, DPMin, DPMax, ParamMinNote, ParamMaxNote);
	}
}
