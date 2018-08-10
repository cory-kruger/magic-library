package ca.corykruger.magic.magic_library.mtgjson.card;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A non-English variant of a card
 */
public class ForeignVariant {
	
	private String language;
	private String name;
	private String multiverseid;
	
	/**
	 * Parameterized constructor
	 * @param language The language of the variant
	 * @param name The name of the variant in its own language
	 * @param multiverseid The multiverseid of the variant
	 */
	public ForeignVariant(String language, String name, String multiverseid) {
		this.language = language;
		this.name = name;
		this.multiverseid = multiverseid;
	}
	
	@Override
	public String toString() {
		return "(" + language + ") " + name + " [" + multiverseid + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof ForeignVariant) {
			ForeignVariant aForeignVariant = (ForeignVariant) obj;
			if (StringUtils.equals(this.language, aForeignVariant.getLanguage())
					&& StringUtils.equals(this.name, aForeignVariant.getName())
					&& StringUtils.equals(this.getMultiverseid(), aForeignVariant.getMultiverseid())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(79, 127)
				.append(this.language)
				.append(this.name)
				.append(this.multiverseid)
				.toHashCode();
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMultiverseid() {
		return multiverseid;
	}
	
	public void setMultiverseid(String multiverseid) {
		this.multiverseid = multiverseid;
	}

}
