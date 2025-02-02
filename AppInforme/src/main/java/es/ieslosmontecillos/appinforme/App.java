package es.ieslosmontecillos.appinforme;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App extends Application {
    public static Connection conexion = null;
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        conectaBD();
        App.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 340);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
    public void conectaBD(){
        //Establecemos conexión con la BD
        String baseDatos = "jdbc:hsqldb:hsql://localhost/SampleDB";
        String usuario = "sa";
        String clave = "";
        try{
            conexion = DriverManager.getConnection(baseDatos,usuario,clave);
        }
        catch (SQLException sqle){System.err.println("No se pudo conectar a BD");
            sqle.printStackTrace();
            System.exit(1);
        }
        catch (Exception ex){
            System.err.println("Imposible Conectar");
            ex.printStackTrace();
            System.exit(1);
        }
    }


}