module com.neu.numberrecognizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires org.tensorflow.core.api;
    requires org.tensorflow.core.platform;
    requires org.tensorflow;

    opens com.neu.numberrecognizer to javafx.fxml;
    exports com.neu.numberrecognizer;
}