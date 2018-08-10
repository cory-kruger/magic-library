package ca.corykruger.magic.magic_library.mtgjson.set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_library.utils.FileUtilsWrapper;

public class SetRetrieverTest {
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	private SetRetriever retriever;
	
	private Gson gson;
	private URL url;
	private File file;
	
	private String localFile = "{\"name\": \"Gatecrash\",\"code\": \"GTC\",\"magicCardsInfoCode\": \"gtc\",\"releaseDate\": \"2013-02-01\",\"border\": \"black\",\"type\": \"expansion\",\"block\": \"Return to Ravnica\",\"booster\": [[\"rare\",\"mythic rare\"],\"uncommon\",\"uncommon\",\"uncommon\",\"common\",\"common\",\"common\",\"common\",\"common\",\"common\",\"common\",\"common\",\"common\",\"common\",\"land\",\"marketing\"],\"translations\": {\"de\": \"Gildensturm\",\"fr\": \"Insurrection\",\"it\": \"Irruzione\",\"es\": \"Intrusión\",\"pt\": \"Portões Violados\",\"jp\": \"ギルド門侵犯\",\"cn\": \"兵临古城\",\"ru\":\"Незваные Гости\",\"tw\": \"兵臨古城\",\"ko\": \"충돌의 관문\"},\"mkm_name\": \"Gatecrash\",\"mkm_id\": 1424,\"cards\": [{\"artist\": \"Scott Chou\",\"cmc\": 2,\"colorIdentity\": [\"W\"],\"colors\": [\"White\"],\"flavor\": \"\\\"When you put all of yourself into an attack, without fear or hesitation, in that instant you may attain greatness.\\\"\\n—Predak, Gateless freemage\",\"foreignNames\": [{\"language\": \"Chinese Simplified\",\"name\": \"空中计略\",\"multiverseid\": 365865},{\"language\": \"Chinese Traditional\",\"name\": \"空中計略\",\"multiverseid\": 366132},{\"language\": \"French\",\"name\": \"Manœuvre aérienne\",\"multiverseid\": 366672},{\"language\": \"German\",\"name\": \"Luftiges Manöver\",\"multiverseid\": 366803},{\"language\": \"Italian\",\"name\": \"Manovra Aerea\",\"multiverseid\": 366990},{\"language\": \"Korean\",\"name\": \"공중 기동\",\"multiverseid\": 367472},{\"language\": \"Portuguese (Brazil)\",\"name\": \"Manobra Aérea\",\"multiverseid\": 367581},{\"language\": \"Russian\",\"name\": \"Воздушный Маневр\",\"multiverseid\": 367919},{\"language\": \"Spanish\",\"name\": \"Maniobra aérea\",\"multiverseid\": 368214},{\"language\": \"Japanese\",\"name\": \"天駆ける進撃\",\"multiverseid\": 368278}],\"id\": \"be238e3c92a20f513a0fe6db6d0a667b96bf4f0f\",\"imageName\": \"aerial maneuver\",\"layout\": \"normal\",\"legalities\": [{\"format\": \"Commander\",\"legality\": \"Legal\"},{\"format\": \"Legacy\",\"legality\": \"Legal\"},{\"format\": \"Modern\",\"legality\": \"Legal\"},{\"format\": \"Return to Ravnica Block\",\"legality\": \"Legal\"},{\"format\": \"Vintage\",\"legality\": \"Legal\"}],\"manaCost\": \"{1}{W}\",\"mciNumber\": \"1\",\"multiverseid\": 366294,\"name\": \"Aerial Maneuver\",\"number\": \"1\",\"originalText\": \"Target creature gets +1/+1 and gains flying and first strike until end of turn.\",\"originalType\": \"Instant\",\"printings\": [\"GTC\"],\"rarity\": \"Common\",\"text\": \"Target creature gets +1/+1 and gains flying and first strike until end of turn.\",\"type\": \"Instant\",\"types\": [\"Instant\"]}]}";
	private String remoteFile = "{\"name\": \"Gatecrash\",\"code\": \"GTC\",\"magicCardsInfoCode\": \"gtc\",\"releaseDate\": \"2013-02-01\",\"border\": \"black\",\"type\": \"expansion\",\"block\": \"Return to Ravnica\",\"booster\": [[\"rare\",\"mythic rare\"],\"uncommon\",\"uncommon\",\"uncommon\",\"common\",\"common\",\"common\",\"common\",\"common\",\"common\",\"common\",\"common\",\"common\",\"common\",\"land\",\"marketing\"],\"translations\": {\"de\": \"Gildensturm\",\"fr\": \"Insurrection\",\"it\": \"Irruzione\",\"es\": \"Intrusión\",\"pt\": \"Portões Violados\",\"jp\": \"ギルド門侵犯\",\"cn\": \"兵临古城\",\"ru\": \"Незваные Гости\",\"tw\": \"兵臨古城\",\"ko\": \"충돌의 관문\"},\"mkm_name\": \"Gatecrash\",\"mkm_id\": 1424,\"cards\": [{\"artist\": \"Scott Chou\",\"cmc\": 2,\"colorIdentity\": [\"W\"],\"colors\": [\"White\"],\"flavor\": \"\\\"When you put all of yourself into an attack, without fear or hesitation, in that instant you may attain greatness.\\\"\\n—Predak, Gateless freemage\",\"foreignNames\": [{\"language\": \"Chinese Simplified\",\"name\": \"空中计略\",\"multiverseid\": 365865},{\"language\": \"Chinese Traditional\",\"name\": \"空中計略\",\"multiverseid\": 366132},{\"language\": \"French\",\"name\": \"Manœuvre aérienne\",\"multiverseid\": 366672},{\"language\": \"German\",\"name\": \"Luftiges Manöver\",\"multiverseid\": 366803},{\"language\": \"Italian\",\"name\": \"Manovra Aerea\",\"multiverseid\": 366990},{\"language\": \"Korean\",\"name\": \"공중 기동\",\"multiverseid\": 367472},{\"language\": \"Portuguese (Brazil)\",\"name\": \"Manobra Aérea\",\"multiverseid\": 367581},{\"language\": \"Russian\",\"name\": \"Воздушный Маневр\",\"multiverseid\": 367919},{\"language\": \"Spanish\",\"name\": \"Maniobra aérea\",\"multiverseid\": 368214},{\"language\": \"Japanese\",\"name\": \"天駆ける進撃\",\"multiverseid\": 368278}],\"id\": \"be238e3c92a20f513a0fe6db6d0a667b96bf4f0f\",\"imageName\": \"aerial maneuver\",\"layout\": \"normal\",\"legalities\": [{\"format\": \"Commander\",\"legality\": \"Legal\"},{\"format\": \"Legacy\",\"legality\": \"Legal\"},{\"format\": \"Modern\",\"legality\": \"Legal\"},{\"format\": \"Return to Ravnica Block\",\"legality\": \"Legal\"},{\"format\": \"Vintage\",\"legality\": \"Legal\"}],\"manaCost\": \"{1}{W}\",\"mciNumber\": \"1\",\"multiverseid\": 366294,\"name\": \"Aerial Maneuver\",\"number\": \"1\",\"originalText\": \"Target creature gets +1/+1 and gains flying and first strike until end of turn.\",\"originalType\": \"Instant\",\"printings\": [\"GTC\"],\"rarity\": \"Common\",\"text\": \"Target creature gets +1/+1 and gains flying and first strike until end of turn.\",\"type\": \"Instant\",\"types\": [\"Instant\"]}, {\"artist\": \"Raoul Vitale\",\"cmc\": 1,\"colorIdentity\": [\"R\"],\"colors\": [\"Red\"],\"flavor\": \"After the Foundry Street riot, Arrester Hulbein tried to ban bludgeons. Which, inevitably, resulted in another riot.\",\"foreignNames\": [{\"language\": \"Chinese Simplified\",\"name\": \"锻炉街居民\",\"multiverseid\": 365974},{\"language\": \"Chinese Traditional\",\"name\": \"鍛爐街居民\",\"multiverseid\": 366042},{\"language\": \"French\",\"name\": \"Habitant de la rue de la Fonderie\",\"multiverseid\": 366665},{\"language\": \"German\",\"name\": \"Bewohner des Schmelzenwegs\",\"multiverseid\": 366839},{\"language\": \"Italian\",\"name\": \"Abitante di Via della Fonderia\",\"multiverseid\": 367022},{\"language\": \"Korean\",\"name\": \"주조소 거리 거주민\",\"multiverseid\": 367405},{\"language\": \"Portuguese (Brazil)\",\"name\": \"Habitante da Rua da Fundição\",\"multiverseid\": 367565},{\"language\": \"Russian\",\"name\": \"Житель Литейной Улицы\",\"multiverseid\": 367823},{\"language\": \"Spanish\",\"name\": \"Habitante de la Calle Fundición\",\"multiverseid\": 368065},{\"language\": \"Japanese\",\"name\": \"鋳造所通りの住人\",\"multiverseid\": 368467}],\"id\": \"78f5c02c71f9795c99ff23e45dc52df000accad0\",\"imageName\": \"foundry street denizen\",\"layout\": \"normal\",\"legalities\": [{\"format\": \"Commander\",\"legality\": \"Legal\"},{\"format\": \"Legacy\",\"legality\": \"Legal\"},{\"format\": \"Modern\",\"legality\": \"Legal\"},{\"format\": \"Return to Ravnica Block\",\"legality\": \"Legal\"},{\"format\": \"Vintage\",\"legality\": \"Legal\"}],\"manaCost\": \"{R}\",\"mciNumber\": \"92\",\"multiverseid\": 366472,\"name\": \"Foundry Street Denizen\",\"number\": \"92\",\"originalText\": \"Whenever another red creature enters the battlefield under your control, Foundry Street Denizen gets +1/+0 until end of turn.\",\"originalType\": \"Creature — Goblin Warrior\",\"power\": \"1\",\"printings\": [\"GTC\",\"M15\",\"DDT\"],\"rarity\": \"Common\",\"subtypes\": [\"Goblin\",\"Warrior\"],\"text\": \"Whenever another red creature enters the battlefield under your control, Foundry Street Denizen gets +1/+0 until end of turn.\",\"toughness\": \"1\",\"type\": \"Creature — Goblin Warrior\",\"types\": [\"Creature\"]}]}";
	
	@Before
	public void setUp() {
		gson = new Gson();
	}
	
	@After
	public void tearDown() {
		file.delete();
	}
	
	@Test
	public void localFileReturnedWhenLocalFilePresent() throws IOException {
		// Write localFile to a temporary file
		file = tempFolder.newFile();
		FileUtils.writeStringToFile(file, localFile, Charset.defaultCharset());
		
		// Retrieve the temporary file as a Set
		retriever = new SetRetriever(new FileUtilsWrapper(), gson, url, file);
		Set retrievedSet = retriever.retrieveSet();
		assertNotNull(retrievedSet);
		
		// Constructs a list of expected cards to compare the returned Set against
		List<Card> cards = new ArrayList<>();
		// Constructs an individual expected card for comparison
		Card aerialManeuver = new Card("be238e3c92a20f513a0fe6db6d0a667b96bf4f0f", "normal", "Aerial Maneuver", null, "{1}{W}", 2, buildList("White"), buildList("W"), "Instant", null, buildList("Instant"), null, "Common", "Target creature gets +1/+1 and gains flying and first strike until end of turn.", "\"When you put all of yourself into an attack, without fear or hesitation, in that instant you may attain greatness.\"\n—Predak, Gateless freemage", "Scott Chou", "1", null, null, null, "366294", null, null, null, false, null, null, false, null, false, null, buildForeignVariantsForFirstCard(), buildList("GTC"), "Target creature gets +1/+1 and gains flying and first strike until end of turn.", "Instant", buildLegalities(), null);
		cards.add(aerialManeuver);
		
		// The number and rarity of cards to be found in the Set's booster packs
		ArrayList<Object> booster = new ArrayList<>();
		// The 'rare' or better card in each booster pack
		ArrayList<String> specialCards = new ArrayList<>();
		specialCards.add("rare");
		specialCards.add("mythic rare");
		booster.add(specialCards);
		booster.add("uncommon");
		booster.add("uncommon");
		booster.add("uncommon");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("land");
		booster.add("marketing");
		// The name of the set in the various supported languages
		Translation translation = new Translation("Gildensturm", "Insurrection", "Irruzione", "Intrusión", "Portões Violados", "ギルド門侵犯", "兵临古城", "Незваные Гости", "兵臨古城", "충돌의 관문");
		// The build set for comparison
		Set expectedSet = new Set("Gatecrash", "GTC", "2013-02-01", "black", "expansion", "Return to Ravnica", false, booster, translation, cards);
		
		
		assertEquals(expectedSet.getBlock(), retrievedSet.getBlock());
		assertTrue(ListUtils.isEqualList(expectedSet.getBooster(), retrievedSet.getBooster()));
		assertEquals(expectedSet.getBorder(), retrievedSet.getBorder());
		assertEquals(expectedSet.getCode(), retrievedSet.getCode());
		assertEquals(expectedSet.getName(), retrievedSet.getName());
		assertEquals(expectedSet.getReleaseDate(), retrievedSet.getReleaseDate());
		assertEquals(expectedSet.getTranslations(), retrievedSet.getTranslations());
		assertEquals(expectedSet.getType(), retrievedSet.getType());
		assertEquals(expectedSet.isOnlineOnly(), retrievedSet.isOnlineOnly());
		assertTrue(ListUtils.isEqualList(expectedSet.getCards(), retrievedSet.getCards()));
		assertEquals(expectedSet, retrievedSet);
	}

	@Test
	public void remoteFileRetrievedWhenLocalFileNotPresent() throws IOException {
		// Create a temporary file, save its path, then delete it so that File.exists() returns false
		file = tempFolder.newFile();
		String tempFilePath = file.getPath();
		file.delete();
		
		// Create a new file at the temporary file location and save the contents of remoteFile to it
		Answer<Void> answer = new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				file = new File(tempFilePath);
				FileUtils.writeStringToFile(file, remoteFile, Charset.defaultCharset());
				return null;
			}};
			
		FileUtilsWrapper fileUtils = mock(FileUtilsWrapper.class); 
		doAnswer(answer).when(fileUtils).copyURLToFile(any(URL.class), any(File.class));
		doCallRealMethod().when(fileUtils).readFileToString(any(File.class));
		doCallRealMethod().when(fileUtils).readFileToString(any(File.class), any(Charset.class));
		retriever = new SetRetriever(fileUtils, gson, url, file);
		Set retrievedSet = retriever.retrieveSet();
		assertNotNull(retrievedSet);
		
		// Constructs a list of expected cards to compare the returned Set against
		List<Card> cards = new ArrayList<>();
		// Constructs an individual expected card for comparison
		Card aerialManeuver = new Card("be238e3c92a20f513a0fe6db6d0a667b96bf4f0f", "normal", "Aerial Maneuver", null, "{1}{W}", 2, buildList("White"), buildList("W"), "Instant", null, buildList("Instant"), null, "Common", "Target creature gets +1/+1 and gains flying and first strike until end of turn.", "\"When you put all of yourself into an attack, without fear or hesitation, in that instant you may attain greatness.\"\n—Predak, Gateless freemage", "Scott Chou", "1", null, null, null, "366294", null, null, null, false, null, null, false, null, false, null, buildForeignVariantsForFirstCard(), buildList("GTC"), "Target creature gets +1/+1 and gains flying and first strike until end of turn.", "Instant", buildLegalities(), null);
		cards.add(aerialManeuver);
		Card foundryStreetDenizen = new Card("78f5c02c71f9795c99ff23e45dc52df000accad0", "normal", "Foundry Street Denizen", null, "{R}", 1, buildList("Red"), buildList("R"), "Creature — Goblin Warrior", null, buildList("Creature"), buildList("Goblin", "Warrior"), "Common", "Whenever another red creature enters the battlefield under your control, Foundry Street Denizen gets +1/+0 until end of turn.", "After the Foundry Street riot, Arrester Hulbein tried to ban bludgeons. Which, inevitably, resulted in another riot.", "Raoul Vitale", "92", "1", "1", null, "366472", null, null, null, false, null, null, false, null, false, null, buildForeignVariantsForSecondCard(), buildList("GTC", "M15", "DDT"), "Whenever another red creature enters the battlefield under your control, Foundry Street Denizen gets +1/+0 until end of turn.", "Creature — Goblin Warrior", buildLegalities(), null);
		cards.add(foundryStreetDenizen);
		
		// The number and rarity of cards to be found in the Set's booster packs
		ArrayList<Object> booster = new ArrayList<>();
		// The 'rare' or better card in each booster pack
		ArrayList<String> specialCards = new ArrayList<>();
		specialCards.add("rare");
		specialCards.add("mythic rare");
		booster.add(specialCards);
		booster.add("uncommon");
		booster.add("uncommon");
		booster.add("uncommon");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("common");
		booster.add("land");
		booster.add("marketing");
		// The name of the set in the various supported languages
		Translation translation = new Translation("Gildensturm", "Insurrection", "Irruzione", "Intrusión", "Portões Violados", "ギルド門侵犯", "兵临古城", "Незваные Гости", "兵臨古城", "충돌의 관문");
		// The build set for comparison
		Set expectedSet = new Set("Gatecrash", "GTC", "2013-02-01", "black", "expansion", "Return to Ravnica", false, booster, translation, cards);
		
		assertEquals(expectedSet.getBlock(), retrievedSet.getBlock());
		assertTrue(ListUtils.isEqualList(expectedSet.getBooster(), retrievedSet.getBooster()));
		assertEquals(expectedSet.getBorder(), retrievedSet.getBorder());
		assertEquals(expectedSet.getCode(), retrievedSet.getCode());
		assertEquals(expectedSet.getName(), retrievedSet.getName());
		assertEquals(expectedSet.getReleaseDate(), retrievedSet.getReleaseDate());
		assertEquals(expectedSet.getTranslations(), retrievedSet.getTranslations());
		assertEquals(expectedSet.getType(), retrievedSet.getType());
		assertEquals(expectedSet.isOnlineOnly(), retrievedSet.isOnlineOnly());
		assertTrue(ListUtils.isEqualList(expectedSet.getCards(), retrievedSet.getCards()));
		assertEquals(expectedSet, retrievedSet);
	}
	
	private List<String> buildList(String... elements) {
		List<String> list = new ArrayList<>();
		for (String element : elements) {
			list.add(element);
		}
		return list;
	}
	
	private List<Format> buildLegalities() {
		List<Format> legalities = new ArrayList<>();
		legalities.add(new Format("Commander", "Legal"));
		legalities.add(new Format("Legacy", "Legal"));
		legalities.add(new Format("Modern", "Legal"));
		legalities.add(new Format("Return to Ravnica Block", "Legal"));
		legalities.add(new Format("Vintage", "Legal"));
		return legalities;
	}

	private List<ForeignVariant> buildForeignVariantsForFirstCard() {
		List<ForeignVariant> foreignNames = new ArrayList<>();
		foreignNames.add(new ForeignVariant("Chinese Simplified", "空中计略", "365865"));
		foreignNames.add(new ForeignVariant("Chinese Traditional", "空中計略", "366132"));
		foreignNames.add(new ForeignVariant("French", "Manœuvre aérienne", "366672"));
		foreignNames.add(new ForeignVariant("German", "Luftiges Manöver", "366803"));
		foreignNames.add(new ForeignVariant("Italian", "Manovra Aerea", "366990"));
		foreignNames.add(new ForeignVariant("Korean", "공중 기동", "367472"));
		foreignNames.add(new ForeignVariant("Portuguese (Brazil)", "Manobra Aérea", "367581"));
		foreignNames.add(new ForeignVariant("Russian", "Воздушный Маневр", "367919"));
		foreignNames.add(new ForeignVariant("Spanish", "Maniobra aérea", "368214"));
		foreignNames.add(new ForeignVariant("Japanese", "天駆ける進撃", "368278"));
		return foreignNames;
	}
	
	private List<ForeignVariant> buildForeignVariantsForSecondCard() {
		List<ForeignVariant> foreignNames = new ArrayList<>();
		foreignNames.add(new ForeignVariant("Chinese Simplified", "锻炉街居民", "365974"));
		foreignNames.add(new ForeignVariant("Chinese Traditional", "鍛爐街居民", "366042"));
		foreignNames.add(new ForeignVariant("French", "Habitant de la rue de la Fonderie", "366665"));
		foreignNames.add(new ForeignVariant("German", "Bewohner des Schmelzenwegs", "366839"));
		foreignNames.add(new ForeignVariant("Italian", "Abitante di Via della Fonderia", "367022"));
		foreignNames.add(new ForeignVariant("Korean", "주조소 거리 거주민", "367405"));
		foreignNames.add(new ForeignVariant("Portuguese (Brazil)", "Habitante da Rua da Fundição", "367565"));
		foreignNames.add(new ForeignVariant("Russian", "Житель Литейной Улицы", "367823"));
		foreignNames.add(new ForeignVariant("Spanish", "Habitante de la Calle Fundición", "368065"));
		foreignNames.add(new ForeignVariant("Japanese", "鋳造所通りの住人", "368467"));
		return foreignNames;
	}

}
