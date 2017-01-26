package view;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

import commands.Command;
import commands.ExitCommand;
import commands.Printer;
import common.Level;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MainWindowController extends java.util.Observable  implements Initializable,View {

	boolean stop=false;
	private Command ExitCommand= new ExitCommand();
	private double opacity;
	private int counter;
	private Timer timer;
	private long min;
	private long sec;
	private StringProperty timeCounting;
	String ssound;
	Media sound;
	MediaPlayer mediaPlayer;

	@FXML
	private Label won;

	@FXML
	private Label label;

	@FXML
	SokobanDisplayer sokobanDisplayer;

	@FXML
	private Text timerGame;



public MainWindowController() {
	this.sokobanDisplayer=new SokobanDisplayer();
	this.counter=0;
	this.timer= new Timer();
	this.timeCounting= new SimpleStringProperty();
	this.ssound="SPONGEBOB TRAP REMIX! KRUSTY KRAB Vine Remix.mp3";
	this.sound = new Media(new File(ssound).toURI().toString());
	this.mediaPlayer = new MediaPlayer(sound);
	mediaPlayer.setAutoPlay(true);

	mediaPlayer.play();




}
/*
	String[][] sokobanData= new String[][]{
		{"#","#","#","#","A"},
		{"#","#","#","#","O"},
		{" "," "," "," ","#","#","#"},
		{"#","#","#","#","A"},
		{"#","A","#","#","O"},
		{"#","#","O","#","A"},
		{"#","#","#","#","O"},
		{"#","#","@","#","A"},
		{"#","#","#","#","O"},

	};


*/

/*
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sokobanDisplayer.setSokoboanData(sokobanData); //להכניס את המשחק
sokobanDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)->sokobanDisplayer.requestFocus()); //כשלוחצים על משהו
		sokobanDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {

	@Override
	public void handle(KeyEvent event) {
int r=sokobanDisplayer.getcRow();
int c= sokobanDisplayer.getcCol();

if(event.getCode()==KeyCode.UP){
sokobanDisplayer.setCharacterPosition(r-1, c);
}

if(event.getCode()==KeyCode.DOWN){
sokobanDisplayer.setCharacterPosition(r+1, c);
}

if(event.getCode()==KeyCode.RIGHT){
sokobanDisplayer.setCharacterPosition(r, c+1);
}

if(event.getCode()==KeyCode.UP){
sokobanDisplayer.setCharacterPosition(r, c-1);

}

	}
});
	}
	*/
	public void start(){


		String command ="Load";
		LinkedList<String>params= new LinkedList<String>();
		params.add(command);
		params.add("level1.txt");
		this.setChanged();
		this.notifyObservers(params);
		startTimer(0, 0);

		   //Timer t = new Timer("Display Timer");

          // TimerTask task = new TimerTask() {
             //  @Override
            //   public void run() {
                  // Task to be executed every second

                //   DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                //   Calendar cali = Calendar.getInstance();
                //   cali.getTime();
                //   String time = timeFormat.format(cali.getTimeInMillis());
                //   System.out.println(timeFormat.format(cali.getTimeInMillis()));
                 //  timer.setText(time);
             //  }
       //    };

          // This will invoke the timer every second
          // t.scheduleAtFixedRate(task, 1000, 1000);

		//Calendar c= new GregorianCalendar();
		//int sec=c.get(Calendar.SECOND);
		//int min=c.get(Calendar.MINUTE);
		//int hour= c.get(Calendar.HOUR);

		//timer.setText("time: "+hour+" " +min+" "+sec);
	//



	}

		/*

		new Thread(new Runnable() {


			@Override
			public void run() {
				while(stop==false)
				{
					try {
						Command c=commandsQueue.poll(10,TimeUnit.SECONDS);

						if(c!=null){
							if(c.getClass()==ExitCommand.getClass()){
								c.execute();
								stop();
							}
							else
								c.execute();
						}


					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();
	}

*/

	public void openFile(){

	FileChooser fc= new FileChooser();
	fc.setTitle("open sokoboan file");
	fc.setInitialDirectory(new File("./resources"));
	fc.setSelectedExtensionFilter(new ExtensionFilter("XML files", "*.xml"));
	File chosen= fc.showOpenDialog(null);
	if(chosen!= null){
		System.out.println(chosen.getName());
		LinkedList<String>params= new LinkedList<String>();
		String str= chosen.getName();
		params.add("Load");
		params.add(str);
		this.counter=0;


		mediaPlayer.stop();
		mediaPlayer.play();
		this.setChanged();
		this.notifyObservers(params);
		startTimer(0, 0);


		}

	}

	public void saveFile(){
		FileChooser fc= new FileChooser();
		fc.setTitle("save sokoboan file");
		fc.setInitialDirectory(new File("./resources"));
		fc.setSelectedExtensionFilter(new ExtensionFilter("XML files", "*.xml"));
		File chosen= fc.showSaveDialog(null);
		if(chosen!= null){
			System.out.println(chosen.getName());
			LinkedList<String>params= new LinkedList<String>();
			String str= chosen.getName();
			params.add("Save");
			params.add(str);
			this.setChanged();
			this.notifyObservers(params);
			}

		}





	//LinkedList<String>params= new LinkedList<String>();
//	String str= s.nextLine();
	//if(str.equals("exit")|| str.equals("Exit")){
		//params.add(str);
	//	setChanged();
		//notifyObservers(params);




	public void stopMusic(){

		mediaPlayer.pause();

	}

	//public void insertCommand(Command c){

		//	try {
		///		commandsQueue.put(c);
		//	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}


	//}

	@Override
	public boolean isFlag() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFlag(boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void display(Level level) {
		if(level!=null)
			sokobanDisplayer.setSokoboanData(level.getDynamicObjects());



	}

	private void startTimer(long mini,long seco){
		this.timer= new Timer();
		this.min=mini;
		this.sec=seco;
		this.timerGame.textProperty().bind(this.timeCounting);
		this.timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				sec++;
				if(sec>59){
					min++;
					sec=0;
				}
				if(min<10){
					if(sec<10)
						timeCounting.set("0"+min+".0"+sec);
					else
						timeCounting.set("0"+min+"."+sec);
				}
				else
					timeCounting.set(""+min+"."+sec);

			}
		}, 0, 1000);



	}
	public void stopTimer(){
		if(this.timer!=null)
			this.timer.cancel();

	}
	public void continTimer(){
		startTimer(min, sec);

	}
	public void continSong(){
		this.mediaPlayer.play();

	}

	@Override
	public void exit() {
		stop=true;
		LinkedList<String>params= new LinkedList<String>();

		params.add("Exit");

		this.setChanged();
		this.notifyObservers(params);
		Platform.exit();
		System.exit(0);

	}

	@Override
	public void setP(Printer p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sokobanDisplayer.setSokoboanData(sokobanDisplayer.getSokoboanData());
		sokobanDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)->sokobanDisplayer.requestFocus());
		sokobanDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()==KeyCode.UP){
				LinkedList<String>params= new LinkedList<String>();
				params.add("Move Up");
				setChanged();

				notifyObservers(params);
				counter++;
				label.setText("steps: "+counter+" ");
				event.consume();
				sokobanDisplayer.requestFocus();
				}
				if(event.getCode()==KeyCode.DOWN){

					LinkedList<String>params= new LinkedList<String>();
					params.add("Move Down");
					setChanged();

					notifyObservers(params);
					counter++;
					label.setText("steps: "+counter+" ");
					event.consume();
					sokobanDisplayer.requestFocus();
					}
				if(event.getCode()==KeyCode.RIGHT){

					LinkedList<String>params= new LinkedList<String>();
					params.add("Move Right");
					setChanged();
					notifyObservers(params);
					counter++;
					label.setText("steps: "+counter+" ");
					event.consume();
					sokobanDisplayer.requestFocus();
					}
				if(event.getCode()==KeyCode.LEFT){

					LinkedList<String>params= new LinkedList<String>();
					params.add("Move Left");
					setChanged();
					notifyObservers(params);
					counter++;
					label.setText("steps: "+counter+" ");
					event.consume();
					sokobanDisplayer.requestFocus();
					}


			}
		});

	}

	//private void finishLevel(Level level){
		//if(level.Win()==true){
		//	Platform.runLater(new Runnable() {

			//	@Override
			//	public void run() {
			//		stopTimer();
			//		won.setText("You won!!!");
			//	}
			//});
		//}
	//}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}








}


