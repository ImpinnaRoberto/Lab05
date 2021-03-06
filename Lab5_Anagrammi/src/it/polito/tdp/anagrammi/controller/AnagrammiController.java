/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdo.anagrammi.dao.*;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	private Model model=new Model();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInserimento"
    private TextField txtInserimento; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResultEsatti"
    private TextArea txtResultEsatti; // Value injected by FXMLLoader

    @FXML // fx:id="txtResultErrati"
    private TextArea txtResultErrati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCalcola(ActionEvent event) {
    	txtResultEsatti.clear();
    	txtResultErrati.clear();
    	AnagrammaDAO a=new AnagrammaDAO();
    	LinkedList<String> elenco=model.calcola(txtInserimento.getText());
    	
    	for(String s: elenco){
    		if(a.isCorrect(s)){
    			txtResultEsatti.appendText(s+"\n");
    		}else{
    			txtResultErrati.appendText(s+"\n");
    		}
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResultEsatti.clear();
    	txtResultErrati.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInserimento != null : "fx:id=\"txtInserimento\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultEsatti != null : "fx:id=\"txtResultEsatti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultErrati != null : "fx:id=\"txtResultErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
