package ca.corykruger.magic.magic_library.gatherer;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class DataRetriever {
	
	public static final String IMAGE_ADDRESS = "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=%d&type=card";
	
	private URL gathererUrl;
	
	DataRetriever(URL gathererURL) {
		this.gathererUrl = gathererURL;
	}

	public Image getImage() throws IOException {
		try (InputStream inStream = gathererUrl.openStream();) {
			return ImageIO.read(inStream);
		}
	}
	
	

}
