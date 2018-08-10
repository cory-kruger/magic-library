package ca.corykruger.magic.magic_library.mtgjson.set;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * An official ruling regarding a card
 */
public class Ruling {
	
	private String date;
	private String text;
	
	/**
	 * Parameterized constructor
	 * @param date The date the ruling was made
	 * @param text The text of the ruling
	 */
	public Ruling(String date, String text) {
		this.date = date;
		this.text = text;
	}
	
	@Override
	public String toString() {
		return date + ":  " + text;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Ruling) {
			Ruling aRuling = (Ruling) obj;
			if (this.date.equals(aRuling.getDate()) && this.text.equals(aRuling.getText())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(233, 251)
				.append(this.date)
				.append(this.text)
				.toHashCode();
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

}