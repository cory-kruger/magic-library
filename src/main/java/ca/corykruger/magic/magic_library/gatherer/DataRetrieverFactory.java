package ca.corykruger.magic.magic_library.gatherer;

import java.net.MalformedURLException;
import java.net.URL;

public class DataRetrieverFactory {
	
	public DataRetriever getImageRetriever(int multiverseId) {
		try {
			URL gathererUrl = new URL(String.format(DataRetriever.IMAGE_ADDRESS, multiverseId));
			return new DataRetriever(gathererUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

}
