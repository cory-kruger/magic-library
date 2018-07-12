package ca.corykruger.magic.magic_library.gatherer;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Constructs a <code>DataRetriever</code> with a ready-to-use <code>URL</code>
 */
public class DataRetrieverFactory {
	
	/**
	 * Creates a <code>DataRetriever</code> that can be used to retrieve a card's artwork
	 * @param multiverseId the UUID of the card to retrieve
	 * @return A <code>DataRetriever</code> ready to retrieve an image
	 */
	public DataRetriever getImageRetriever(int multiverseId) {
		try {
			URL gathererUrl = new URL(String.format(DataRetriever.IMAGE_ADDRESS, multiverseId));
			return new DataRetriever(gathererUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

}
