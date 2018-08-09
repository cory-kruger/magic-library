package ca.corykruger.magic.magic_library.mtgjson.set;

import java.util.List;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javafx.util.Pair;

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
	private List<String> superTypes;
	private List<String> types;
	private List<String> subTypes;
	private String rarity;
	private String text;
	private String flavor;
	private String artist;
	private String number;
	private String power;
	private String toughness;
	private String loyalty;
	private String multiverseId;
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
	private List<Pair<String, String>> foreignNames;
	private List<String> printings;
	private String originalText;
	private String originalType;
	private List<Pair<String, String>> legalities;
	private String source;
	
	/**
	 * Parameterized constructor
	 * @param id A unique ID for this card
	 * @param layout The card layout
	 * @param name The card name
	 * @param names Only used for split, flip, double-faced, and meld cards.  
	 * 	Will contain all the names on this card, front or back.  
	 * 	For meld cards, the first name is the card with the meld ability, which has the top half on its back, 
	 * 	the second name is the card with the reminder text, and the third name is the melded back face.
	 * @param manaCost The mana cost of this card.  Consists of one or more mana symbols.
	 * @param cmc Converted mana cost.  Always a number.  
	 * 	NOTE:  CMC may have a decimal point as cards from unhinged may contain "half mana".
	 * @param colors The card colors
	 * @param colorIdentity The color identity of the card.  It is the same of double-sided cards 
	 * 	(if they have different colors, the identity will have both colors).
	 * @param type The overall card type.  NOTE:  The dash is a UTF-8 'long dash'.
	 * @param superTypes The supertypes of the card.  These appear to the far left of the card type.
	 * @param types The types of the card.  These appear to the left of the dash in the card type.
	 * @param subTypes The subtypes of the card.  These appear to the right of the dash in a card type.
	 * @param rarity The rarity of the card
	 * @param text The text of the card
	 * @param flavor The flavor text of the card
	 * @param artist the artist of the card.  
	 * 	NOTE:  This may not match what is on the card as MTGJSON corrects many card misprints
	 * @param number The card number
	 * @param power The power of the card.  This is only present for creatures.
	 * @param toughness The toughness of the card.  This is only present for creatures.
	 * @param loyalty The loyalty of the card.  This is only present for planeswalkers.
	 * @param multiverseId The multiverseId of the card on Wizard's gatherer web page
	 * @param variations The multiverseIDs of any variations of this card, due to alternate art
	 * @param watermark The watermark on the card
	 * @param border The border of the card, if different from the default border for the card's set
	 * @param timeshifted If this card was a timeshifted card in its set
	 * @param hand The card's maximum hand size modifier
	 * @param life The card's starting life total modifier
	 * @param reserved If this card is reserved by Wizards' Official Reprint Policy
	 * @param releaseDate The date this card was released, only for promo cards
	 * @param starter If this card was release as part of a core box set
	 * @param rulings The rulings for the card
	 * @param foreignNames The foreign language names for the card, if this card in this set was printed in another language
	 * @param printings The sets that this card was printed in
	 * @param originalText The original text on the card at the time it was printed
	 * @param originalType The original type on the card at the time it was printed
	 * @param legalities The formats this card is legal, restricted, or banned in
	 * @param source The original source of the card, for promo cards only
	 */
	public Card(String id, String layout, String name, List<String> names, String manaCost, int cmc, 
			List<String> colors, List<String> colorIdentity, String type, List<String> superTypes,
			List<String> types, List<String> subTypes, String rarity, String text, String flavor, String artist,
			String number, String power, String toughness, String loyalty, String multiverseId, 
			List<String> variations, String watermark, String border, boolean timeshifted, String hand, 
			String life, boolean reserved, String releaseDate, boolean starter, List<Ruling> rulings,
			List<Pair<String, String>> foreignNames, List<String> printings, String originalText, 
			String originalType, List<Pair<String, String>> legalities, String source) {
		this.id = id;
		this.layout = layout;
		this.name = name;
		this.names = names;
		this.manaCost = manaCost;
		this.cmc = cmc;
		this.colors = colors;
		this.colorIdentity = colorIdentity;
		this.type = type;
		this.superTypes = superTypes;
		this.types = types;
		this.subTypes = subTypes;
		this.rarity = rarity;
		this.text = text;
		this.flavor = flavor;
		this.artist = artist;
		this.number = number;
		this.power = power;
		this.toughness = toughness;
		this.loyalty = loyalty;
		this.multiverseId = multiverseId;
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
		return "(" + multiverseId + ") " + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Card) {
			Card aCard = (Card) obj;
			if (this.id.equals(aCard.getId())
					&& this.layout.equals(aCard.getLayout())
					&& this.name.equals(aCard.getName())
					&& this.names.size() == aCard.getNames().size()
					&& this.names.containsAll(aCard.getNames())
					&& this.manaCost.equals(aCard.getManaCost())
					&& this.cmc == aCard.getCmc()
					&& this.colors.size() == aCard.getColors().size()
					&& this.colors.containsAll(aCard.getColors())
					&& this.colorIdentity.size() == aCard.getColorIdentity().size()
					&& this.colorIdentity.equals(aCard.getColorIdentity())
					&& this.type.equals(aCard.getType())
					&& this.superTypes.size() == aCard.getSuperTypes().size()
					&& this.superTypes.containsAll(aCard.getSuperTypes())
					&& this.types.size() == aCard.getTypes().size()
					&& this.types.containsAll(aCard.getTypes())
					&& this.subTypes.size() == aCard.getSubTypes().size()
					&& this.subTypes.containsAll(aCard.getSubTypes())
					&& this.rarity.equals(aCard.getRarity())
					&& this.text.equals(aCard.getText())
					&& this.flavor.equals(aCard.getFlavor())
					&& this.artist.equals(aCard.getArtist())
					&& this.number.equals(aCard.getNumber())
					&& this.power.equals(aCard.getPower())
					&& this.toughness.equals(aCard.getToughness())
					&& this.loyalty.equals(aCard.getLoyalty())
					&& this.multiverseId.equals(aCard.getMultiverseId())
					&& this.variations.size() == aCard.getVariations().size()
					&& this.variations.containsAll(aCard.getVariations())
					&& this.watermark.equals(aCard.getWatermark())
					&& this.border.equals(aCard.getBorder())
					&& this.timeshifted == aCard.isTimeshifted()
					&& this.hand.equals(aCard.getHand())
					&& this.life.equals(aCard.getLife())
					&& this.reserved == aCard.isReserved()
					&& this.releaseDate.equals(aCard.getReleaseDate())
					&& this.starter == aCard.isStarter()
					&& this.rulings.size() == aCard.getRulings().size()
					&& this.rulings.containsAll(aCard.getRulings())
					&& this.foreignNames.size() == aCard.getForeignNames().size()
					&& this.foreignNames.containsAll(aCard.getForeignNames())
					&& this.printings.size() == aCard.getPrintings().size()
					&& this.printings.containsAll(aCard.getPrintings())
					&& this.originalText.equals(aCard.getOriginalText())
					&& this.originalType.equals(aCard.getOriginalType())
					&& this.legalities.size() == aCard.getLegalities().size()
					&& this.legalities.containsAll(aCard.getLegalities())
					&& this.source.equals(aCard.getSource())) {
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
				.append(this.superTypes)
				.append(this.types)
				.append(this.subTypes)
				.append(this.rarity)
				.append(this.text)
				.append(this.flavor)
				.append(this.artist)
				.append(this.number)
				.append(this.power)
				.append(this.toughness)
				.append(this.loyalty)
				.append(this.multiverseId)
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

	public List<String> getSuperTypes() {
		return superTypes;
	}

	public void setSuperTypes(List<String> superTypes) {
		this.superTypes = superTypes;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(List<String> subtypes) {
		this.subTypes = subtypes;
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
		return multiverseId;
	}

	public void setMultiverseId(String multiverseId) {
		this.multiverseId = multiverseId;
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

	public List<Pair<String, String>> getForeignNames() {
		return foreignNames;
	}

	public void setForeignNames(List<Pair<String, String>> foreignNames) {
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

	public List<Pair<String, String>> getLegalities() {
		return legalities;
	}

	public void setLegalities(List<Pair<String, String>> legalities) {
		this.legalities = legalities;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
