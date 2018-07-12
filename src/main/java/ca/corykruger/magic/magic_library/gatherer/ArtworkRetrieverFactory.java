package ca.corykruger.magic.magic_library.gatherer;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Constructs a <code>DataRetriever</code> with a ready-to-use <code>URL</code>
 */
public class ArtworkRetrieverFactory {
	
	/**
	 * Creates a <code>ArtworkRetriever</code> that can be used to retrieve a card's artwork
	 * @param multiverseId the UUID of the card to retrieve
	 * @return An <code>ArtworkRetriever</code> ready to retrieve a card's artwork
	 */
	public ArtworkRetriever getImageRetriever(int multiverseId) {
		try {
			URL gathererUrl = new URL(String.format(ArtworkRetriever.ARTWORK_ADDRESS, multiverseId));
			return new ArtworkRetriever(gathererUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

}
