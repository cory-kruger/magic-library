package ca.corykruger.magic.magic_library.gatherer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;

import ca.corykruger.magic.magic_library.gatherer.exceptions.DocumentNotPopulatedException;
import ca.corykruger.magic.magic_library.gatherer.exceptions.MissingElementException;

public class CardRetrieverTest {
	
	private JsoupWrapper jsoup;
	private Document document;
	
	private CardRetriever retriever;
	
	private final String NAME = "Llanowar Elves";
	private final String EXPANSION = "Classic Sixth Edition";
	private final String ARTIST = "Anson Maddocks";
	private final String ORACLE_TEXT = "Tap: Add Green.";
	private final String FLAVOR_TEXT = "One bone broken for every twig snapped underfoot. —Llanowar penalty for trespassing";
	private final String MANA_COST = "Green";
	private final String NUMBER = "239";
	private final String TYPES = "Creature — Elf Druid";
	private final String RARITY = "Common";
	
	@Before
	public void setup() throws IOException {
		jsoup = mock(JsoupWrapper.class);
		document = Document.createShell("");
		doReturn(document).when(jsoup).getDocument(anyString());
		retriever = new CardRetriever(jsoup, null).populate();
	}
	
	private void populateBody() throws IOException {
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_NAME + "\"><div class=\"value\">" + NAME + "</div></div>");
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_EXPANSION + "\"><div class=\"value\">" + EXPANSION + "</div></div>");
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_ARTIST + "\"><div class=\"value\">" + ARTIST + "</div></div>");
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_ORACLE_TEXT + "\"><div class=\"value\">" + ORACLE_TEXT + "</div></div>");
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_FLAVOR_TEXT + "\"><div class=\"value\">" + FLAVOR_TEXT + "</div></div>");
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_MANA_COST + "\"><div class=\"value\"><img src=\"null\" alt=\"" + MANA_COST + "\"></div></div>");
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_SET_NUMBER + "\"><div class=\"value\">" + NUMBER + "</div></div>");
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_TYPES + "\"><div class=\"value\">" + TYPES + "</div></div>");
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_RARITY + "\"><div class=\"value\">" + RARITY + "</div></div>");
	}
	
	@Test(expected = MissingElementException.class)
	public void exceptionWhenNoElementSelected() throws DocumentNotPopulatedException, MissingElementException {
		retriever.getElement(CardRetriever.SELECTOR_NAME);
	}
	
	@Test(expected = DocumentNotPopulatedException.class)
	public void exceptionWhenDocumentNotPopulated() throws DocumentNotPopulatedException, MissingElementException {
		retriever = new CardRetriever(jsoup, null);
		retriever.getElementText(CardRetriever.SELECTOR_NAME);
	}

	@Test
	public void elementRetrieved() throws IOException, DocumentNotPopulatedException, MissingElementException {
		populateBody();
		assertEquals(NAME, retriever.getElementText(CardRetriever.SELECTOR_NAME));
		assertEquals(EXPANSION, retriever.getElementText(CardRetriever.SELECTOR_EXPANSION));
		assertEquals(ARTIST, retriever.getElementText(CardRetriever.SELECTOR_ARTIST));
		assertEquals(ORACLE_TEXT, retriever.getElementText(CardRetriever.SELECTOR_ORACLE_TEXT));
		assertEquals(FLAVOR_TEXT, retriever.getElementText(CardRetriever.SELECTOR_FLAVOR_TEXT));
		assertEquals(MANA_COST, retriever.getElementText(CardRetriever.SELECTOR_MANA_COST));
		assertEquals(NUMBER, retriever.getElementText(CardRetriever.SELECTOR_SET_NUMBER));
		assertEquals(RARITY, retriever.getElementText(CardRetriever.SELECTOR_RARITY));
		assertEquals(TYPES, retriever.getElementText(CardRetriever.SELECTOR_TYPES));
	}
	
	@Test(expected = NullPointerException.class)
	public void exceptionWhenManaElementNotProvided() throws DocumentNotPopulatedException, MissingElementException {
		retriever.getManaCost(null);
	}
	
	@Test(expected = MissingElementException.class)
	public void exceptionWhenManaSymbolsNotPresent() throws IOException, DocumentNotPopulatedException, MissingElementException {
		Element element = new Element("<div id=\"" + CardRetriever.SELECTOR_MANA_COST + "\"><div class=\"value\"></div></div>");
		retriever.getManaCost(element);
	}
	
	@Test
	public void multipleManaSymbolCostRetrieved() throws IOException, DocumentNotPopulatedException, MissingElementException {
		final String MULTIPLE_MANA_CORT = "2GreenGreen";
		document = Document.createShell("");
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_MANA_COST + "\"><div class=\"value\"></div></div>");
		document.body().child(0).child(0).append("<img src=\"null\" alt=\"" + "2" + "\">");
		document.body().child(0).child(0).append("<img src=\"null\" alt=\"" + MANA_COST + "\">");
		document.body().child(0).child(0).append("<img src=\"null\" alt=\"" + MANA_COST + "\">");
		doReturn(document).when(jsoup).getDocument(anyString());
		retriever = new CardRetriever(jsoup, null).populate();
		assertEquals(MULTIPLE_MANA_CORT, retriever.getElementText(CardRetriever.SELECTOR_MANA_COST));
	}
	
	@Test
	public void xManaSymbolRetrieved() throws IOException, DocumentNotPopulatedException, MissingElementException {
		final String MULTIPLE_MANA_CORT = "Variable ColorlessGreen";
		document = Document.createShell("");
		document.body().append("<div id=\"" + CardRetriever.SELECTOR_MANA_COST + "\"><div class=\"value\"></div></div>");
		document.body().child(0).child(0).append("<img src=\"null\" alt=\"" + "Variable Colorless" + "\">");
		document.body().child(0).child(0).append("<img src=\"null\" alt=\"" + MANA_COST + "\">");
		doReturn(document).when(jsoup).getDocument(anyString());
		retriever = new CardRetriever(jsoup, null).populate();
		assertEquals(MULTIPLE_MANA_CORT, retriever.getElementText(CardRetriever.SELECTOR_MANA_COST));
	}

}
