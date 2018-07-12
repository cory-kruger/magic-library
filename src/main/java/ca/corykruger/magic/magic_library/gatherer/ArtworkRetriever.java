package ca.corykruger.magic.magic_library.gatherer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Retrieves data from the provided URL.
 */
public class ArtworkRetriever {
	
	/**
	 * Parameterized website address to retrieve a card's artwork from
	 */
	public static final String ARTWORK_ADDRESS = "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=%d&type=card";
	
	private URL gathererUrl;
	
	/**
	 * Creates a <code>DataRetriever</code> object and specifies the <code>URL</code> to retrieve the data from
	 * @param gathererURL
	 */
	ArtworkRetriever(URL gathererURL) {
		this.gathererUrl = gathererURL;
	}

	/**
	 * Retrieves the card artwork
	 * @return The retrieved image
	 * @throws IOException if unable to retrieve the image
	 */
	public BufferedImage getArtwork() throws IOException {
		try (InputStream inStream = gathererUrl.openStream();) {
			return ImageIO.read(inStream);
		}
	}
	
	

}
