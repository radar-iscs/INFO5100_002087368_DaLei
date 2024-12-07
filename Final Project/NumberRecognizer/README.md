# Number Recognizer

This project is a JavaFX application that recognizes handwritten digits drawn by the user. It leverages TensorFlow for machine learning inference and follows the MVC (Model-View-Controller) architectural pattern.

## Features

- **Handwritten Digit Recognition:**  
  Users can draw digits on a canvas. The model processes this input and identifies the number.

- **MVC Pattern:**  
  The project is structured using the MVC design pattern:
    - **View:** `RecognizorView.java` handles the graphical user interface.
    - **Model:** `RecognizorModel.java` manages application data and business logic.
    - **Controller:** `RecognizorController.java` connects the view and model, handling user interaction and application flow.

- **Machine Learning with TensorFlow:**  
  The underlying model used for digit recognition is trained using TensorFlow. A Python script is provided to train and export the model.

## Project Structure

- **Java Codebase (MVC):**  
  Core classes for the application are organized and follow the MVC pattern.

- **Model Training (Python):**  
  The training script `model.py` (located at `./src/main/python/model.py`) uses TensorFlow to build and train the neural network model. After training, the model is exported for the Java application to use during runtime.

- **Class Diagram:**  
  A comprehensive class diagram illustrating the relationships and architecture is available in `./assets/Class Diagram.png`.

- **Test Cases:**  
  Screenshots demonstrating the execution of various test cases can be found in `./assets/test cases/`. These tests verify that the application behaves as expected and that the recognition accuracy meets the requirements.

## Requirements

- **JavaFX** for the graphical user interface.
- **TensorFlow for Java** to run the inference within the application.
- **Python 3.8 + TensorFlow 2.4.1** for training the model.
