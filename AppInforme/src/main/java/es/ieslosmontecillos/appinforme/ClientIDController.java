package es.ieslosmontecillos.appinforme;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientIDController {

    private String clientID;
    @FXML
    private TextField tfID;
    Stage stage;

    public ClientIDController(Stage escenario) throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client-view.fxml"));
        fxmlLoader.setController(this);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Client ID");
        stage.initOwner(escenario);
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    @FXML
    public void onValidar(ActionEvent actionEvent) {
        clientID = tfID.getText();
        stage.close();
    }

    @FXML
    public void onCancelar(ActionEvent actionEvent) {
        stage.close();
    }

    public String showClientID(){
        stage.showAndWait();
        return clientID;
    }


}
