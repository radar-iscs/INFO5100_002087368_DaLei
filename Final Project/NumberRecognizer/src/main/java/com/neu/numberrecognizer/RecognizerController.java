package com.neu.numberrecognizer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class RecognizerController {

    private RecognizerView view;
    private RecognizerModel model;
    private GraphicsContext context;

    public RecognizerController(RecognizerView view, RecognizerModel model) {
        this.view = view;
        this.model = model;

        this.context = view.getCanvas().getGraphicsContext2D();
        context.setStroke(Color.WHITE); // set brush color
        context.setLineWidth(15); // set brush width

        // handle drawing numbers' event
        addEventHandlers();
    }

    private void addEventHandlers() {
        Canvas canvas = view.getCanvas();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                event -> context.beginPath());

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                event -> {
                    context.lineTo(event.getX(), event.getY());
                    context.stroke();
                });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
                event -> {
                    context.closePath();
                    predictNumber();
                });
    }

    private void predictNumber() {
        try {
            int prediction = model.predictNumber(view.getCanvas());
            view.getPredictionLabel().setText("Prediction: " + prediction);
        } catch (Exception e) {
            view.getPredictionLabel().setText("Error in prediction");
            System.out.println("prediction error: " + e);
            e.printStackTrace();
        }
    }
}
