package ca.corykruger.magic.magic_library.mtgjson.card;

import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A single card.
 */
public class Card {

	private String id;
	private String layout;
	private String name;
	private List<String> names;
	private String manaCost;
	private int cmc;
	private List<String> colors;
	private List<String> colorIdentity;
	private String type;
	private List<String> supertypes;
	private List<String> types;
	private List<String> subtypes;
	private String rarity;
	private String text;
	private String flavor;
	private String artist;
	private String number;
	private String power;
	private String toughness;
	private String loyalty;
	private String multiverseid;
	private List<String> variations;
	private String watermark;
	private String border;
	private boolean timeshifted;
	private String hand;
	private String life;
	private boolean reserved;
	private String releaseDate;
	private boolean starter;
	private List<Ruling> rulings;
	private List<ForeignVariant> foreignNames;
	private List<String> printings;
	private String originalText;
	private String originalType;
	private List<Format> legalities;
	private String source;
	
	/**
	 * Parameterized constructor
	 * @param id The UID of the card
	 * @param layout The layout of the card
	 * @param name The name of the card
	 * @param names All of the names on the card, front or back
	 * @param manaCost The mana cost of the card
	 * @param cmc The converted mana cost of the card 
	 * @param colors The colors of the card
	 * @param colorIdentity The color identity of the card
	 * @param type The overall type of the card
	 * @param supertypes The supertypes of the card
	 * @param types The base types of the card
	 * @param subtypes The subtypes of the card
	 * @param rarity The rarity of the card
	 * @param text The text of the card
	 * @param flavor The flavor text of the card
	 * @param artist the artist of the card.  
	 * @param number The number of the card
	 * @param power The power of the card
	 * @param toughness The toughness of the card
	 * @param loyalty The loyalty of the card
	 * @param multiverseid The multiverseid of the card from Wizard's gatherer web page
	 * @param variations The multiverseids of any variations of this card, due to alternate art
	 * @param watermark The watermark on the card
	 * @param border The border of the card
	 * @param timeshifted If the card was a timeshifted card in its set
	 * @param hand The maximum hand size modifier of the card
	 * @param life The starting life total modifier of the card
	 * @param reserved If the card is reserved by Wizards' Official Reprint Policy
	 * @param releaseDate The release date of the card
	 * @param starter If the card was released as part of a core box set
	 * @param rulings The rulings for the card
	 * @param foreignNames The foreign language names for the card
	 * @param printings The sets that the card was printed in
	 * @param originalText The original text on the card at the time it was printed
	 * @param originalType The original type on the card at the time it was printed
	 * @param legalities The formats the card is legal, restricted, or banned in
	 * @param source The original source of the card, for promo cards only
	 */
	public Card(String id, String layout, String name, List<String> names, String manaCost, int cmc, 
			List<String> colors, List<String> colorIdentity, String type, List<String> supertypes,
			List<String> types, List<String> subtypes, String rarity, String text, String flavor, String artist,
			String number, String power, String toughness, String loyalty, String multiverseId, 
			List<String> variations, String watermark, String border, boolean timeshifted, String hand, 
			String life, boolean reserved, String releaseDate, boolean starter, List<Ruling> rulings,
			List<ForeignVariant> foreignNames, List<String> printings, String originalText, 
			String originalType, List<Format> legalities, String source) {
		this.id = id;
		this.layout = layout;
		this.name = name;
		this.names = names;
		this.manaCost = manaCost;
		this.cmc = cmc;
		this.colors = colors;
		this.colorIdentity = colorIdentity;
		this.type = type;
		this.supertypes = supertypes;
		this.types = types;
		this.subtypes = subtypes;
		this.rarity = rarity;
		this.text = text;
		this.flavor = flavor;
		this.artist = artist;
		this.number = number;
		this.power = power;
		this.toughness = toughness;
		this.loyalty = loyalty;
		this.multiverseid = multiverseId;
		this.variations = variations;
		this.watermark = watermark;
		this.border = border;
		this.timeshifted = timeshifted;
		this.hand = hand;
		this.life = life;
		this.reserved = reserved;
		this.releaseDate = releaseDate;
		this.starter = starter;
		this.rulings = rulings;
		this.foreignNames = foreignNames;
		this.printings = printings;
		this.originalText = originalText;
		this.originalType = originalType;
		this.legalities = legalities;
		this.source = source;
	}
	
	@Override
	public String toString() {
		return "(" + multiverseid + ") " + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Card) {
			Card aCard = (Card) obj;
			if (StringUtils.equals(this.id, aCard.getId())
					&& StringUtils.equals(this.layout, aCard.getLayout()) 
					&& StringUtils.equals(this.name,aCard.getName())
					&& ListUtils.isEqualList(this.names, aCard.getNames())
					&& StringUtils.equals(this.manaCost, aCard.getManaCost())
					&& this.cmc == aCard.getCmc()
					&& ListUtils.isEqualList(this.colors, aCard.getColors())
					&& ListUtils.isEqualList(this.colorIdentity, aCard.getColorIdentity())
					&& StringUtils.equals(this.type, aCard.getType())
					&& ListUtils.isEqualList(this.supertypes, aCard.getSupertypes())
					&& ListUtils.isEqualList(this.types, aCard.getTypes())
					&& ListUtils.isEqualList(this.subtypes, aCard.getSubtypes())
					&& StringUtils.equals(this.rarity, aCard.getRarity())
					&& StringUtils.equals(this.text, aCard.getText())
					&& StringUtils.equals(this.flavor, aCard.getFlavor())
					&& StringUtils.equals(this.artist, aCard.getArtist())
					&& StringUtils.equals(this.number, aCard.getNumber())
					&& StringUtils.equals(this.power, aCard.getPower())
					&& StringUtils.equals(this.toughness, aCard.getToughness())
					&& StringUtils.equals(this.loyalty, aCard.getLoyalty())
					&& StringUtils.equals(this.multiverseid, aCard.getMultiverseId())
					&& ListUtils.isEqualList(this.variations, aCard.getVariations())
					&& StringUtils.equals(this.watermark, aCard.getWatermark())
					&& StringUtils.equals(this.border, aCard.getBorder())
					&& this.timeshifted == aCard.isTimeshifted()
					&& StringUtils.equals(this.hand, aCard.getHand())
					&& StringUtils.equals(this.life, aCard.getLife())
					&& this.reserved == aCard.isReserved()
					&& StringUtils.equals(this.releaseDate, aCard.getReleaseDate())
					&& this.starter == aCard.isStarter()
					&& ListUtils.isEqualList(this.rulings, aCard.getRulings())
					&& ListUtils.isEqualList(this.foreignNames, aCard.getForeignNames())
					&& ListUtils.isEqualList(this.printings, aCard.getPrintings())
					&& StringUtils.equals(this.originalText, aCard.getOriginalText())
					&& StringUtils.equals(this.originalType, aCard.getOriginalType())
					&& ListUtils.isEqualList(this.legalities, aCard.getLegalities())
					&& StringUtils.equals(this.source, aCard.getSource())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(211, 83)
				.append(this.id)
				.append(this.layout)
				.append(this.name)
				.append(this.names)
				.append(this.manaCost)
				.append(this.cmc)
				.append(this.colors)
				.append(this.colorIdentity)
				.append(this.type)
				.append(this.supertypes)
				.append(this.types)
				.append(this.subtypes)
				.append(this.rarity)
				.append(this.text)
				.append(this.flavor)
				.append(this.artist)
				.append(this.number)
				.append(this.power)
				.append(this.toughness)
				.append(this.loyalty)
				.append(this.multiverseid)
				.append(this.variations)
				.append(this.watermark)
				.append(this.border)
				.append(this.timeshifted)
				.append(this.hand)
				.append(this.life)
				.append(this.reserved)
				.append(this.releaseDate)
				.append(this.starter)
				.append(this.rulings)
				.append(this.foreignNames)
				.append(this.printings)
				.append(this.originalText)
				.append(this.originalType)
				.append(this.legalities)
				.append(this.source)
				.toHashCode();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public int getCmc() {
		return cmc;
	}

	public void setCmc(int cmc) {
		this.cmc = cmc;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public List<String> getColorIdentity() {
		return colorIdentity;
	}

	public void setColorIdentity(List<String> colorIdentity) {
		this.colorIdentity = colorIdentity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getSupertypes() {
		return supertypes;
	}

	public void setSupertypes(List<String> supertypes) {
		this.supertypes = supertypes;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getSubtypes() {
		return subtypes;
	}

	public void setSubtypes(List<String> subtypes) {
		this.subtypes = subtypes;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getToughness() {
		return toughness;
	}

	public void setToughness(String toughness) {
		this.toughness = toughness;
	}

	public String getLoyalty() {
		return loyalty;
	}

	public void setLoyalty(String loyalty) {
		this.loyalty = loyalty;
	}

	public String getMultiverseId() {
		return multiverseid;
	}

	public void setMultiverseId(String multiverseId) {
		this.multiverseid = multiverseId;
	}

	public List<String> getVariations() {
		return variations;
	}

	public void setVariations(List<String> variations) {
		this.variations = variations;
	}

	public String getWatermark() {
		return watermark;
	}

	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	public boolean isTimeshifted() {
		return timeshifted;
	}

	public void setTimeshifted(boolean timeshifted) {
		this.timeshifted = timeshifted;
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public String getLife() {
		return life;
	}

	public void setLife(String life) {
		this.life = life;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isStarter() {
		return starter;
	}

	public void setStarter(boolean starter) {
		this.starter = starter;
	}

	public List<Ruling> getRulings() {
		return rulings;
	}

	public void setRulings(List<Ruling> rulings) {
		this.rulings = rulings;
	}

	public List<ForeignVariant> getForeignNames() {
		return foreignNames;
	}

	public void setForeignNames(List<ForeignVariant> foreignNames) {
		this.foreignNames = foreignNames;
	}

	public List<String> getPrintings() {
		return printings;
	}

	public void setPrintings(List<String> printings) {
		this.printings = printings;
	}

	public String getOriginalText() {
		return originalText;
	}

	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}

	public String getOriginalType() {
		return originalType;
	}

	public void setOriginalType(String originalType) {
		this.originalType = originalType;
	}

	public List<Format> getLegalities() {
		return legalities;
	}

	public void setLegalities(List<Format> legalities) {
		this.legalities = legalities;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
