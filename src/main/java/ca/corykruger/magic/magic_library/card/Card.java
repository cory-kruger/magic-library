package ca.corykruger.magic.magic_library.card;

import java.awt.image.BufferedImage;

public class Card {
	
	private int multiverseId;
	private int number;
	private String name;
	private String types;
	private String expansion;
	private BufferedImage artwork;
	private String artist;
	private String manaCost;
	private String oracleText;
	private String cardText;
	private String flavorText;
	private String rarity;
	
	public Card(int multiverseId, String name, String manaCost, String types, String oracleText, String flavorText, String expansion, String rarity, int collectorNumber, String artist, BufferedImage artwork) {
		this.multiverseId = multiverseId;
		this.name = name;
		this.manaCost = manaCost;
		this.types = types;
		this.oracleText = oracleText;
		this.flavorText = flavorText;
		this.expansion = expansion;
		this.rarity = rarity;
		this.number = collectorNumber;
		this.artist = artist;
		this.artwork = artwork;
	}
	
	
	public int getMultiverseId() {
		return multiverseId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getManaCost() {
		return manaCost;
	}
	
	public String getTypes() {
		return types;
	}
	
	public String getOracleText() {
		return oracleText;
	}
	
	public String getFlavortext() {
		return flavorText;
	}
	
	public String getExpansion() {
		return expansion;
	}
	
	public String getRarity() {
		return rarity;
	}
	
	public int getCollectorNumber() {
		return number;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public BufferedImage getArtwork() {
		return artwork;
	}

}
