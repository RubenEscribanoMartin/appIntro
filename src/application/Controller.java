package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller implements Initializable {

	@FXML
	private AnchorPane pane1;
	@FXML
	private ImageView image1;

	@FXML
	private AnchorPane pane2;
	@FXML
	private ImageView image2;

	@FXML
	private AnchorPane pane3;
	@FXML
	private ImageView image3;

	@FXML
	private AnchorPane pane4;
	@FXML
	private ImageView image4;

	@FXML
	private Label countLabel;

	public void translateAnimation(double duration, Node node, double byY) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByY(byY);
		translateTransition.play();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		translateAnimation(0.5, pane2, 615);
		translateAnimation(0.5, pane3,615);
		translateAnimation(0.5, pane4, 615);
	}

	int showSlide = 0;

	@FXML
	void nextAction(ActionEvent event) {

		if (showSlide == 0) {
			translateAnimation(0.7, pane2, -615);
			showSlide++; // showSlide=1
			countLabel.setText(" STEP 2/4");
		} else if (showSlide == 1) {

			translateAnimation(0.7, pane3, -615);
			showSlide++; // showSlide=2
			countLabel.setText("STEP 3/4");

		} else if (showSlide == 2) {

			translateAnimation(0.7, pane4, -615);
			showSlide++; // showSlide=3
			countLabel.setText("STEP 4/4");

		} else {
			System.out.println("No more slides");
		}

	}

	@FXML
	void backAction(ActionEvent event) {

		if (showSlide == 0) {
			System.out.println("No more slide");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 615);
			showSlide--; // showSlide=1
			countLabel.setText("1/4");

		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 615);
			showSlide--; // showSlide=1
			countLabel.setText("2/4");

		} else if (showSlide == 3) {

			translateAnimation(0.5, pane4, 615);
			showSlide--; // showSlide=2
			countLabel.setText("3/4");

		}
	}
	
	@FXML
	public void imageBlurON (){
		image1.setEffect(new GaussianBlur(7));
		image2.setEffect(new GaussianBlur(7));
		image3.setEffect(new GaussianBlur(7));
		image4.setEffect(new GaussianBlur(7));
		
	}
	
	@FXML
	public void BlurOFF (){
		image1.setEffect(new GaussianBlur(0));
		image2.setEffect(new GaussianBlur(0));
		image3.setEffect(new GaussianBlur(0));
		image4.setEffect(new GaussianBlur(0));
		
	}
	
	@FXML
	void buttonClose(ActionEvent event) {
		System.exit(0);
	}
}
