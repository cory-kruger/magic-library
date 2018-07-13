package ca.corykruger.magic.magic_library.gatherer;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Constructs a ready-to-use <code>ArtworkRetriever</code> or <code>CardRetriever</code>
 */
public class RetrieverFactory {
	
	/**
	 * Creates a <code>ArtworkRetriever</code> that can be used to retrieve a card's artwork
	 * @param multiverseId The UUID of the card to retrieve
	 * @return An <code>ArtworkRetriever</code> ready to retrieve a card's artwork
	 */
	public ArtworkRetriever getArtworkRetriever(int multiverseId) {
		try {
			URL gathererUrl = new URL(ArtworkRetriever.formatAddress(multiverseId));
			return new ArtworkRetriever(gathererUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Creates a <code>CardRetriever</code> that can be used to retrieve a card's data
	 * @param oracle Whether to get the card's oracle text or card text
	 * @param multiverseId The UUID of the card to retrieve
	 * @return A <code>CardRetriever</code> ready to retrieve a card's data
	 */
	public CardRetriever getCardRetriever(boolean oracle, int multiverseId) {
		return new CardRetriever(CardRetriever.formatAddress(oracle, multiverseId));
	}

}
