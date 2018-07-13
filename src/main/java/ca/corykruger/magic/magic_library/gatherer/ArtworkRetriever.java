package ca.corykruger.magic.magic_library.gatherer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Retrieves artwork from the provided URL.
 */
public class ArtworkRetriever {
	
	/**
	 * Parameterized website address to retrieve a card's artwork from
	 */
	public static final String ARTWORK_ADDRESS = "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=%d&type=card";
	
	private URL gathererUrl;
	
	/**
	 * Creates a <code>DataRetriever</code> object and specifies the <code>URL</code> to retrieve the artwork from
	 * @param gathererURL
	 */
	ArtworkRetriever(URL gathererURL) {
		this.gathererUrl = gathererURL;
	}

	/**
	 * Retrieves the card artwork
	 * @return The retrieved artwork
	 * @throws IOException if unable to retrieve the artwork
	 */
	public BufferedImage getArtwork() throws IOException {
		try (InputStream inStream = gathererUrl.openStream();) {
			return ImageIO.read(inStream);
		}
	}
	
	/**
	 * Formats the <code>ARTWORK_ADDRESS</code> with the given id
	 * @param multiverseId The id to add to the address 
	 * @return The formatted address
	 */
	public static String formatAddress(int multiverseId) {
		return String.format(ARTWORK_ADDRESS, multiverseId);
	}
	
	

}
