package ca.corykruger.magic.magic_library.gatherer;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import ca.corykruger.magic.magic_library.gatherer.exceptions.DocumentNotPopulatedException;
import ca.corykruger.magic.magic_library.gatherer.exceptions.MissingElementException;

public class CardRetriever {
	
	/**
	 * Parameterized website address to retrieve a card's oracle information from
	 */
	public static final String GATHERER_ADDRESS = "http://gatherer.wizards.com/Pages/Card/Details.aspx?printed=%b&multiverseid=%d";
	
	public static final String SELECTOR_NAME = "ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_nameRow";
	public static final String SELECTOR_EXPANSION = "ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_setRow";
	public static final String SELECTOR_ARTIST = "ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_artistRow";
	public static final String SELECTOR_ORACLE_TEXT = "ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_textRow";
	public static final String SELECTOR_FLAVOR_TEXT = "ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_flavorRow";
	public static final String SELECTOR_MANA_COST = "ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_manaRow";
	public static final String SELECTOR_RARITY = "ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_rarityRow";
	public static final String SELECTOR_SET_NUMBER = "ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_numberRow";
	public static final String SELECTOR_TYPES = "ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_typeRow";
	
	private JsoupWrapper jsoup;
	private String gathererAddress;
	private Document document;

	
	/**
	 * Unit Testing constructor.  Injects dependencies.
	 * @param jsoup Wrapper for Jsoup to mock static methods
	 * @param gathererAddress The address to retrieve the card data from
	 */
	CardRetriever(JsoupWrapper jsoup, String gathererAddress) {
		this.jsoup = jsoup;
		this.gathererAddress = gathererAddress;
	}
	
	/**
	 * Primary constructor.  Instantiates dependencies.
	 * @param gathererAddress The address to retrieve the card data from.  
	 */
	public CardRetriever(String gathererAddress) {
		this.jsoup = new JsoupWrapper();
		this.gathererAddress = gathererAddress;
	}

	/**
	 * Retrieves the <code>document</code> from the <code>gathererAddress</code>
	 * @return This instance of <code>CardRetriever</code> with a ready-to-use <code>document</code> object
	 * @throws IOException If unable to retrieve the document
	 */
	public CardRetriever populate() throws IOException {
		this.document = jsoup.getDocument(gathererAddress);
		return this;
	}
	
	/**
	 * Uses the provided CSS <code>selector</code> to retrieve an element from the document
	 * @param selector The CSS <code>selector</code> to select the element with
	 * @return The selected <code>element</code>
	 * @throws DocumentNotPopulatedException If the document is null
	 * @throws MissingElementException If the document does not contain an element that can be selected by the <code>selector</code>
	 */
	Element getElement(String selector) throws DocumentNotPopulatedException, MissingElementException {
		if (document == null) {
			throw new DocumentNotPopulatedException();
		}
		Element element = document.selectFirst("#" + selector + " .value");
		if (element == null) {
			throw new MissingElementException(selector);
		}
		return element;
	}
	
	/**
	 * Uses the provided CSS <code>selector</code> to retrieve the text of the <code>element</code> selected by the <code>selector</code>.
	 * @param selector The CSS <code>selector</code> whose element's text is to be retrieved
	 * @return the text of the <code>element</code> selected by the <code>selector</code>
	 * @throws DocumentNotPopulatedException If the document is null
	 * @throws MissingElementException If the document does not contain an element that can be selected by the <code>selector</code>
	 */
	public String getElementText(String selector) throws DocumentNotPopulatedException, MissingElementException {
		Element element = getElement(selector);
		if (SELECTOR_MANA_COST.equals(selector)) {
			return getManaCost(element);
		}
		return element.text();
	}
	
	/**
	 * Uses the provided <code>element</code> to retrieve the mana cost
	 * @param element The <code>element</code> to retrieve the  mana cost from
	 * @return The mana cost in the format <code>1RedGreenVariable Colorless</code>
	 * @throws MissingElementException If the element does not contain any child elements
	 */
	String getManaCost(Element element) throws MissingElementException {
		if (element.children().size() <= 0) {
			throw new MissingElementException(SELECTOR_MANA_COST);
		}
		String costText = "";
		for (Element child : element.children()) {
			costText += child.attr("alt");
		}
		return costText;
	}
}
