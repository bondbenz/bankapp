package banque;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientMain extends Application {
    private static Stage primaryStage;
    private  GridPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        this.primaryStage = primaryStage;
        showClientMain();
    }

    public void showClientMain() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClientMain.class.getResource("ClientView.fxml"));
        mainLayout = loader.load();
        primaryStage.setScene(new Scene(mainLayout));
        primaryStage.setTitle("Client Application");
        primaryStage.show();
    }

    public static void showCompteMain() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClientMain.class.getResource("CompteView.fxml"));
        GridPane CompteBancaire = loader.load();
        Stage CompteView = new Stage();
        CompteView.setTitle("Compte Bancaire Application");
        CompteView.initModality(Modality.WINDOW_MODAL);
        CompteView.initOwner(primaryStage);
        Scene scence = new Scene(CompteBancaire);
        CompteView.setScene(scence);
        CompteView.show();
    }
    public static void showErreur() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClientMain.class.getResource("DepassementView.fxml"));
        BorderPane Erreur = loader.load();
        Stage ErreurView = new Stage();
        ErreurView.setTitle("Erreur !");
        ErreurView.initModality(Modality.WINDOW_MODAL);
        ErreurView.initOwner(primaryStage);
        Scene scence = new Scene(Erreur);
        ErreurView.setScene(scence);
        ErreurView.show();
    }

    public static void showCreation() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClientMain.class.getResource("CompteCreationView.fxml"));
        BorderPane Creation = loader.load();
        Stage CreationView = new Stage();
        CreationView.setTitle("Compte Creation");
        CreationView.initModality(Modality.WINDOW_MODAL);
        CreationView.initOwner(primaryStage);
        Scene scence = new Scene(Creation);
        CreationView.setScene(scence);
        CreationView.show();
    }

    public static void showOpers() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClientMain.class.getResource("ListeOpView.fxml"));
        BorderPane Listeo = loader.load();
        Stage ListeopView = new Stage();
        ListeopView.setTitle("Liste Operations");
        ListeopView.initModality(Modality.WINDOW_MODAL);
        ListeopView.initOwner(primaryStage);
        Scene scence = new Scene(Listeo);
        ListeopView.setScene(scence);
        ListeopView.show();
    }

    public static void main(String[] args) {

        launch(args);

    }


}