package com.neu.numberrecognizer;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RecognizerView {

    private Canvas canvas;
    private Label predictionLabel;
    private Button clearButton;
    private VBox layout;

    private final String DESCRIPTION = "Draw a number (0-9)";

    public RecognizerView() {
        canvas = new Canvas(280, 280); // standard size of mnist model

        // label that shows description & prediction
        predictionLabel = new Label(DESCRIPTION);
        predictionLabel.setPrefHeight(50);
        predictionLabel.setFont(new Font(15));
        // reset button
        clearButton = new Button("Clear");
        clearButton.setOnAction(e -> onClickClearButton());

        layout = new VBox();
        layout.getChildren().addAll(canvas, predictionLabel, clearButton);
        layout.setAlignment(Pos.CENTER);

        initializeCanvas();
    }

    private void initializeCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK); // set background color
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void onClickClearButton() {
        initializeCanvas();
        predictionLabel.setText(DESCRIPTION);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Label getPredictionLabel() {
        return predictionLabel;
    }
}
