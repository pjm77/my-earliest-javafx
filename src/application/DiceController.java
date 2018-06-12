package application;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class DiceController extends GridPane{

	@FXML
	public Label infoLabel;
	public Label rollResultLabel;
	public Button rollButton;
	@FXML
	public ToggleGroup diceTypeTG;
	public Label multiplierL;
	public Label diceTypeL;
	public Label modifierL;
	public TextField multiplierTF;
	public Button multiplierPlusB;
	public Button multiplierMinusB;
	public TextField modifierTF;
	public Button modifierPlusB;
	public Button modifierMinusB;
	public ToggleButton tBD3;
	public ToggleButton tBD4;
	public ToggleButton tBD6;
	public ToggleButton tBD8;
	public ToggleButton tBD10;
	public ToggleButton tBD12;
	public ToggleButton tBD20;
	public ToggleButton tBD100;
	
	@FXML
	void initialize() {
		multiplierL.setUserData(1);
		modifierL.setUserData(0);
		tBD3.setUserData(3);
		tBD4.setUserData(4);
		tBD6.setUserData(6);
		tBD8.setUserData(8);
		tBD10.setUserData(10);
		tBD12.setUserData(12);
		tBD20.setUserData(20);
		tBD100.setUserData(100);
	}
	
	public void handleRollButton() {
		Random rand = new Random(); // dice roll and result output
		int multiplier = (int) multiplierL.getUserData();
		int modifier = (int) modifierL.getUserData();
		int diceType = (int) diceTypeL.getUserData(); 
		long finalResult = 0;
		for (int l = 0; l < multiplier; l++) {
			int result = rand.nextInt(diceType) + 1;
			finalResult = finalResult + result;
		}
		finalResult = finalResult + modifier;
		rollResultLabel.setText("" + finalResult);
	}
	
	public void handleMultiplierTF() {
		try {
			int multiplier = Integer.parseInt(multiplierTF.getText());
			if(multiplier<1) {
				multiplierTF.setText("1");
				multiplierL.setUserData(1);
			}else {
				multiplierL.setUserData(multiplier);
			}
		}catch(Exception e){
			multiplierTF.setText("1");
			multiplierL.setUserData(1);
		}
	}
	
	public void handleMultiplierPlusB() {
		int multiplier = (Integer) multiplierL.getUserData();
		multiplier++;
		multiplierTF.setText("" + multiplier);
		multiplierL.setUserData(multiplier);
	}
	
	public void handleMultiplierMinusB() {
		int multiplier = (Integer) multiplierL.getUserData();
		if(multiplier>1) {
			multiplier--;
			multiplierTF.setText("" + multiplier);
			multiplierL.setUserData(multiplier);
		}
	}
	
	public void handleModifierTF() {
		try {
			int modifier = Integer.parseInt(modifierTF.getText());
			modifierL.setUserData(modifier);
		}catch(Exception e){
			modifierTF.setText("1");
			modifierL.setUserData(1);
		}
	}
	
	public void handleModifierPlusB() {
		int modifier = (Integer) modifierL.getUserData();
		modifier++;
		modifierTF.setText("" + modifier);
		modifierL.setUserData(modifier);
	}
	
	public void handleModifierMinusB() {
		int modifier = (Integer) modifierL.getUserData();
		modifier--;
		modifierTF.setText("" + modifier);
		modifierL.setUserData(modifier);
	}
	
	public void handleToggleButtons() {
		diceTypeL.setUserData(diceTypeTG.getSelectedToggle().getUserData());
	}
}