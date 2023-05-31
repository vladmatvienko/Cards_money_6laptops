package com.example.sampleproject;

import java.io.IOException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
public class GameWindowController {

    @FXML
    private Button addCardButton;

    @FXML
    private GridPane deskAttackCardPane;

    @FXML
    private GridPane deskAnswerCardPane;
    
    @FXML
    private ScrollPane firstPlayerScroll;

    @FXML
    private ScrollPane secondPlayerScroll;

    @FXML
    private FlowPane firstPlayerPane;

    @FXML
    private FlowPane secondPlayerPane;

    @FXML
    void addCard(ActionEvent event) throws IOException, InterruptedException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Card.fxml"));
    	Pane newPane = (Pane)loader.load();
        String[] nominal = {"6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};
        String[] mask = {"Бубны♦", "Червы♥", "Крести♣", "Пики♠"};
        Random random = new Random();
        int index_1 = random.nextInt(nominal.length);
        int index_2 = random.nextInt(mask.length);
    	CardController cardController = loader.getController();
    	cardController.setCardParameters(nominal[index_1], mask[index_2], this, newPane);



    	firstPlayerPane.getChildren().add(newPane);

    	firstPlayerScroll = new ScrollPane();
    	firstPlayerScroll.setContent(firstPlayerPane);
    }

    public void addCardOnTable(CardController card) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Card.fxml"));
        
    	Pane newPane = (Pane)loader.load();
    	
    	CardController cardController = loader.getController();
    	cardController.setCardParameters(card.getNominal(), card.getMask(), this, newPane);
    	
    	deskAttackCardPane.add(newPane, deskAttackCardPane.getChildren().size(), 0);
    }
}
