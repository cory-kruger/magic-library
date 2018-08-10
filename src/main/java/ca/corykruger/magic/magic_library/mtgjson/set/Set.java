package ca.corykruger.magic.magic_library.mtgjson.set;

import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A released set of cards
 */
public class Set {

	private String name;
	private String code;
	private String releaseDate;
	private String border;
	private String type;
	private String block;
	private boolean onlineOnly;
	private List<?> booster;
	private Translation translations;
	private List<Card> cards;
	
	public Set(String name, String code, String releaseDate, String border, String type, String block, 
			boolean onlineOnly, List<?> booster, Translation translations, List<Card> cards) {
		this.name = name;
		this.code = code;
		this.releaseDate = releaseDate;
		this.border = border;
		this.type = type;
		this.block = block;
		this.onlineOnly = onlineOnly;
		this.booster = booster;
		this.translations = translations;
		this.cards = cards;
	}
	
	@Override
	public String toString() {
		return "(" + this.code + ") " + this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Set) {
			Set aSet = (Set) obj;
			if (StringUtils.equals(this.name, aSet.getName())
					&& StringUtils.equals(this.code, aSet.getCode())
					&& StringUtils.equals(this.releaseDate, aSet.getReleaseDate())
					&& StringUtils.equals(this.border, aSet.getBorder())
					&& StringUtils.equals(this.type, aSet.getType())
					&& StringUtils.equals(this.block, aSet.getBlock())
					&& this.onlineOnly == aSet.isOnlineOnly()
					&& ListUtils.isEqualList(this.booster, aSet.getBooster())
					&& Objects.equals(this.translations, aSet.getTranslations())
					&& ListUtils.isEqualList(this.cards, aSet.getCards())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(113, 53)
				.append(this.name)
				.append(this.code)
				.append(this.releaseDate)
				.append(this.border)
				.append(this.type)
				.append(this.block)
				.append(this.onlineOnly)
				.append(this.booster)
				.append(this.translations)
				.append(this.cards)
				.toHashCode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}
	
	public boolean isOnlineOnly() {
		return onlineOnly;
	}
	
	public void setOnlineOnly(boolean onlineOnly) {
		this.onlineOnly = onlineOnly;
	}

	public List<?> getBooster() {
		return booster;
	}

	public void setBooster(List<?> booster) {
		this.booster = booster;
	}

	public Translation getTranslations() {
		return translations;
	}

	public void setTranslations(Translation translations) {
		this.translations = translations;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
