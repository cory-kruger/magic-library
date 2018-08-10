package ca.corykruger.magic.magic_library.mtgjson.card;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A game format in which a card has a state of legality
 */
public class Format {

	private String format;
	private String legality;
	
	/**
	 * Parameterized constructor
	 * @param format The name of the format
	 * @param legality The legal state of a card in the format
	 */
	public Format(String format, String legality) {
		this.format = format;
		this.legality = legality;
	}
	
	@Override
	public String toString() {
		return format + ":  " + legality;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Format) {
			Format aFormat = (Format) obj;
			if (StringUtils.equals(this.format, aFormat.getFormat())
					&& StringUtils.equals(this.legality, aFormat.getLegality())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(233, 157)
				.append(this.format)
				.append(this.legality)
				.toHashCode();
	}
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getLegality() {
		return legality;
	}
	
	public void setLegality(String legality) {
		this.legality = legality;
	}
}
