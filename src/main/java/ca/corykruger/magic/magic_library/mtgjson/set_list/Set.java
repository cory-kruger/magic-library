package ca.corykruger.magic.magic_library.mtgjson.set_list;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A set of cards
 */
public class Set {
	
	private String name;
	private String code;
	private String releaseDate;
	
	/**
	 * Parameterized constructor
	 * @param name the set's name
	 * @param code the set's alphanumeric identifying code
	 * @param releaseDate the set's release date, in yyyy-mm-dd format
	 */
	public Set(String name, String code, String releaseDate) {
		this.name = name;
		this.code = code;
		this.releaseDate = releaseDate;
	}
	
	@Override
	public String toString() {
		return releaseDate + ", " + code + ":  " + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Set) {
			Set aSet = (Set) obj;
			if (this.name.equals(aSet.getName()) && 
					this.code.equals(aSet.getCode()) && 
					this.releaseDate.equals(aSet.getReleaseDate())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).
				append(this.name).
				append(this.code).
				append(this.releaseDate).
				toHashCode();
	}
	
	/**
	 * Gets the name of the set
	 * @return the set's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the identifying code of the set
	 * @return the set's code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Gets the release date of the set
	 * @return the set's release date, in yyyy-mm-dd format
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

}
