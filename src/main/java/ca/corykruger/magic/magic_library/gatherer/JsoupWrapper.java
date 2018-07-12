package ca.corykruger.magic.magic_library.gatherer;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupWrapper {
	
	public Document getDocument(String url) throws IOException {
		return Jsoup.connect(url).get();
	}

}
