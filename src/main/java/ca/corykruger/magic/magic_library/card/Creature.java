package ca.corykruger.magic.magic_library.card;

import java.awt.image.BufferedImage;

public class Creature extends Card {
	
	public Creature(int multiverseId, String name, String manaCost, String types, String oracleText, String flavorText,
			String expansion, String rarity, int collectorNumber, String artist, BufferedImage artwork) {
		super(multiverseId, name, manaCost, types, oracleText, flavorText, expansion, rarity, collectorNumber, artist, artwork);
		// TODO Auto-generated constructor stub
	}
	private int power;
	private int toughness;

}
