package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	@FXML
	private Pane drawingAreaPane;

	@FXML
	private RadioButton pen;

	@FXML
	private RadioButton eraser;
	
	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
	    Color color;

	    if (eraser.isSelected()) {
	        color = Color.WHITE;  
	    } else {
	        color = Color.BLACK;   
	    }

	    Circle c = new Circle(event.getX(), event.getY(), 4, color);
	    drawingAreaPane.getChildren().add(c);
	}


	@FXML
	void clearButtonPressed() {
	    drawingAreaPane.getChildren().clear();
	}

}
