package ca.corykruger.magic.magic_library.gatherer;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ArtworkRetrieverTest {
	
	@Test
	public void artworkRetrieved() throws IOException {
		final URLConnection mockUrlConnection = mock(URLConnection.class);
		FileInputStream inStream = new FileInputStream(FileUtils.getFile("resources/1.jpg"));
		when(mockUrlConnection.getInputStream()).thenReturn(inStream);
		
		URLStreamHandler stubUrlHandler = new URLStreamHandler() {
			
			@Override
			protected URLConnection openConnection(URL arg0) throws IOException {
				return mockUrlConnection;
			}
		};
		
		URL gathererUrl = new URL("", "", 0, "", stubUrlHandler);
		ArtworkRetriever retriever = new ArtworkRetriever(gathererUrl);
		Image image = retriever.getArtwork();
		assertNotNull(image);
	}

}
