package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Most_Popular_WordsController extends BorderPane {
	
	@FXML public VBox websitesVBox;
	@FXML public Button scanButton;
	@FXML public Button addButton;

	@FXML
	void initialize() {}
	
	public void handleAddButton() {
		VBox websiteVBox = new VBox();
		TextField websiteNameTF = new TextField("add website...");
		websiteNameTF.setPrefWidth(135);
		TextField websiteSearchCriteriaTF = new TextField("add search criteria...");
		websiteSearchCriteriaTF.setPrefWidth(135);
		Button deleteButton = new Button("delete website");
		deleteButton.setPrefWidth(135);
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				websitesVBox.getChildren().remove(websiteVBox);
			}
		});
		websiteVBox.getChildren().addAll(websiteNameTF, websiteSearchCriteriaTF, deleteButton);
		websitesVBox.getChildren().add(websiteVBox);
	}
	
	public void handleScanButton() {
		List<String> websitesList = new ArrayList<>();
		List<String> searchCriteriaList = new ArrayList<>();
		int numberOfWebsites=websitesVBox.getChildren().size();
		System.out.println(numberOfWebsites-2);
		for(int i=2;i<numberOfWebsites;i++) {
			VBox currentVBox = (VBox) websitesVBox.getChildren().get(i);
			TextField websiteNameTF = (TextField) currentVBox.getChildren().get(0);
			websitesList.add(websiteNameTF.getText());
			TextField websiteSearchCriteriaTF = (TextField) currentVBox.getChildren().get(1);
			searchCriteriaList.add(websiteSearchCriteriaTF.getText());
		}
		System.out.println(websitesList.toString());
		System.out.println(searchCriteriaList.toString());
	}
}