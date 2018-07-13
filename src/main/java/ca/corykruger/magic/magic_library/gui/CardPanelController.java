package ca.corykruger.magic.magic_library.gui;

import java.io.IOException;

import ca.corykruger.magic.magic_library.card.Card;
import ca.corykruger.magic.magic_library.gatherer.ArtworkRetriever;
import ca.corykruger.magic.magic_library.gatherer.CardRetriever;
import ca.corykruger.magic.magic_library.gatherer.RetrieverFactory;
import ca.corykruger.magic.magic_library.gatherer.exceptions.DocumentNotPopulatedException;

public class CardPanelController {
	
	private RetrieverFactory retrieverFactory;
	
	private boolean oracle;
	private int multiverseId;
	
	
	public CardPanelController(RetrieverFactory factory, boolean oracle, int multiverseId) {
		this.retrieverFactory = factory;
		this.oracle = oracle;
		this.multiverseId = multiverseId;
	}
	
	public CardPanelController(boolean oracle, int multiverseId) {
		this.retrieverFactory = new RetrieverFactory();
		this.oracle = oracle;
		this.multiverseId = multiverseId;
	}
	
	public Card getCard() throws IOException, NumberFormatException, DocumentNotPopulatedException {
		
		ArtworkRetriever artworkRetriever = retrieverFactory.getArtworkRetriever(multiverseId);
		CardRetriever cardRetriever = retrieverFactory.getCardRetriever(oracle, multiverseId).populate();
		
		return new Card(multiverseId, 
			cardRetriever.getElementText(CardRetriever.SELECTOR_NAME),
			cardRetriever.getElementText(CardRetriever.SELECTOR_MANA_COST),
			cardRetriever.getElementText(CardRetriever.SELECTOR_TYPES),
			cardRetriever.getElementText(CardRetriever.SELECTOR_ORACLE_TEXT),
			cardRetriever.getElementText(CardRetriever.SELECTOR_FLAVOR_TEXT),
			cardRetriever.getElementText(CardRetriever.SELECTOR_EXPANSION),
			cardRetriever.getElementText(CardRetriever.SELECTOR_RARITY),
			cardRetriever.getElementText(CardRetriever.SELECTOR_SET_NUMBER),
			cardRetriever.getElementText(CardRetriever.SELECTOR_ARTIST),
			artworkRetriever.getArtwork()
		);
	}

}
