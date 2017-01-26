package view;

import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import javax.naming.ldap.ManageReferralControl;
import javax.net.ssl.ManagerFactoryParameters;
import javax.print.DocFlavor.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import controller.MyController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.MyModel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {



			FXMLLoader loader= new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			BorderPane root= (BorderPane)loader.load();

			MainWindowController view= loader.getController();
			Scene scene = new Scene(root,1500,1500);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();


			init(view);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		/*
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			BorderPane root= fxmlLoader.load(getClass().getResource("MainWindow.fxml").openStream());
			MainWindowController mwc= fxmlLoader.getController();
			MyModel model= new MyModel();
			MyController controller = new MyController(mwc,model);
			mwc.addObserver(controller);
			model.addObserver(controller);


			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
	}
	private void init(MainWindowController view){
		MyModel model= new MyModel();
		MyController controller= new MyController(view,model);
		model.addObserver(controller);
		view.addObserver(controller);


		view.start();

	}
	public static void main(String[] args) {
		//launch(args);
		//MainWindowController mwc= new MainWindowController();
		//FXMLLoader fxmlLoader = new FXMLLoader();
		//try {
		//	Pane p = fxmlLoader.load(MainWindowController.class.getResource("MainWindow.fxml").openStream());
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		//mwc = (MainWindowController) fxmlLoader.getController();
		//MyModel model= new MyModel();
		//MyView view= new MyView();
		//MainWindowController mwc= new MainWindowController();
		//MyController controller = new MyController(mwc,model);
		//mwc.addObserver(controller);
		//mwc.start();


		launch(args);


		//model.addObserver(controller);
		//view.addObserver(controller);
	}
}
