package ca.corykruger.magic.magic_library.gui;

import java.io.IOException;

import ca.corykruger.magic.magic_library.card.Card;
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
		
		ImageView artwork = new ImageView();
		Text name = new Text("");
		Text manaCost = new Text("");
		Text types = new Text("");
		Text oracleText = new Text("");
		Text flavorText = new Text("");
		Text expansion = new Text("");
		Text rarity = new Text("");
		Text collectorNumber = new Text("");
		Text artist = new Text("");
		
		try {
			Card card = new CardPanelController(true, 14668).getCard();
			artwork.setImage(SwingFXUtils.toFXImage(card.getArtwork(), null));
			name.setText(card.getName());
			manaCost.setText(card.getManaCost());
			types.setText(card.getTypes());
			oracleText.setText(card.getOracleText());
			flavorText.setText(card.getFlavortext());
			expansion.setText(card.getExpansion());
			rarity.setText(card.getRarity());
			collectorNumber.setText(Integer.toString(card.getCollectorNumber()));
			artist.setText(card.getArtist());
		} catch (IOException ioe) {
			
		}
		
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		grid.add(artwork, 0, 0, 2, 1);
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
