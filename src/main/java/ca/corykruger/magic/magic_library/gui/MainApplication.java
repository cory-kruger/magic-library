package ca.corykruger.magic.magic_library.gui;

import ca.corykruger.magic.magic_library.card.Card;
import ca.corykruger.magic.magic_library.gatherer.ArtworkRetriever;
import ca.corykruger.magic.magic_library.gatherer.ArtworkRetrieverFactory;
import ca.corykruger.magic.magic_library.gatherer.CardRetriever;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		final int multiverseId = 14668;
		
		String gathererAddress = String.format(CardRetriever.GATHERER_ADDRESS, false, multiverseId);
		CardRetriever cardRetriever = new CardRetriever(gathererAddress).populate();
		
		ArtworkRetrieverFactory factory = new ArtworkRetrieverFactory();
		ArtworkRetriever artworkRetriever = factory.getArtworkRetriever(multiverseId);
		
		Card card = new Card(multiverseId, 
			cardRetriever.getElementText(CardRetriever.SELECTOR_NAME),
			cardRetriever.getElementText(CardRetriever.SELECTOR_MANA_COST),
			cardRetriever.getElementText(CardRetriever.SELECTOR_TYPES),
			cardRetriever.getElementText(CardRetriever.SELECTOR_ORACLE_TEXT),
			cardRetriever.getElementText(CardRetriever.SELECTOR_FLAVOR_TEXT),
			cardRetriever.getElementText(CardRetriever.SELECTOR_EXPANSION),
			cardRetriever.getElementText(CardRetriever.SELECTOR_RARITY),
			Integer.parseInt(cardRetriever.getElementText(CardRetriever.SELECTOR_SET_NUMBER)),
			cardRetriever.getElementText(CardRetriever.SELECTOR_ARTIST),
			artworkRetriever.getArtwork()
		);
		
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		
		ImageView imageView = new ImageView(SwingFXUtils.toFXImage(card.getArtwork(), null));
		Text name = new Text(card.getName());
		Text manaCost = new Text(card.getManaCost());
		Text types = new Text(card.getTypes());
		Text oracleText = new Text(card.getOracleText());
		Text flavorText = new Text(card.getFlavortext());
		Text expansion = new Text(card.getExpansion());
		Text rarity = new Text(card.getRarity());
		Text collectorNumber = new Text(Integer.toString(card.getCollectorNumber()));
		Text artist = new Text(card.getArtist());
		
		
		
		grid.add(imageView, 0, 0, 2, 1);
		grid.add(name, 1, 1);
		grid.add(manaCost, 1, 2);
		grid.add(types, 1, 3);
		grid.add(oracleText, 1, 4);
		grid.add(flavorText, 1, 5);
		grid.add(expansion, 1, 6);
		grid.add(rarity, 1, 7);
		grid.add(collectorNumber, 1, 8);
		grid.add(artist, 1, 9);

		Scene scene = new Scene(grid, 800, 600);
		primaryStage.setScene(scene);

		
		primaryStage.setTitle("Magic Library");
		primaryStage.show();
	}

}
