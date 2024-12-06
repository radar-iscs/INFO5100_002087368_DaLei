package com.neu.numberrecognizer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RecognizerApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Initialize model & view & controller
        RecognizerView view = new RecognizerView();
        RecognizerModel model = new RecognizerModel();
        RecognizerController controller = new RecognizerController(view, model);

        // Initialize scene
        Scene scene = new Scene(view.getCanvas().getParent(), 300, 380);
        primaryStage.setTitle("Number Recognizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
