package ca.corykruger.magic.magic_library.mtgjson.set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Format {

	private String format;
	private String legality;
	
	public Format(String format, String legality) {
		this.format = format;
		this.legality = legality;
	}
	
	public String toString() {
		return format + ":  " + legality;
	}
	
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
