package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import commands.Command;
import commands.DisplayLevelCommand;
import commands.ExitCommand;
import commands.LevelPrinter;
import commands.LoadFileCommand;
import commands.MoveDownCommand;
import commands.MoveLeftCommand;
import commands.MoveRightCommand;
import commands.MoveUpCommand;
import commands.Printer;
import commands.SaveFileCommand;
import common.Level;
import general.Controller;
import model.Model;
import view.MainWindowController;
import view.View;

public class MyController implements Observer  {
	private View view;
	private Model model;
	private HashMap<String, Command>commands;
	//private Controller controller;
	//private Server server;
	//private Socket client;
	private Controller controller;

	public MyController() {
		commands=new HashMap<String,Command>();
		commands.put("Load", new LoadFileCommand(model));
		commands.put("Save", new SaveFileCommand(model));
		commands.put("Move Up",new MoveUpCommand(model));
		commands.put("Move Down",new MoveDownCommand(model));
		commands.put("Move Left",new MoveLeftCommand(model));
		commands.put("Move Right",new MoveRightCommand(model));


	}




	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

public MyController(View view,Model model) {
	this.view=view;
	this.model=model;

	this.controller =new Controller();
	commands=new HashMap<String,Command>();
	commands.put("Load", new LoadFileCommand(model));
	commands.put("Save", new SaveFileCommand(model));
	commands.put("Move Up",new MoveUpCommand(model));
	commands.put("Move Down",new MoveDownCommand(model));
	commands.put("Move Left",new MoveLeftCommand(model));
	commands.put("Move Right",new MoveRightCommand(model));
	commands.put("display",new DisplayLevelCommand(model,view));
	commands.put("Exit", new ExitCommand(view));
	this.view.setP(new LevelPrinter());
	this.controller.start();

}

	/*
public MyController(Controller c,Model model) {
	this.controller=c;
	this.model=model;


	commands=new HashMap<String,Command>();
	commands.put("Load", new LoadFileCommand(model));
	commands.put("Save", new SaveFileCommand(model));
	commands.put("Move Up",new MoveUpCommand(model));
	commands.put("Move Down",new MoveDownCommand(model));
	commands.put("Move Left",new MoveLeftCommand(model));
	commands.put("Move Right",new MoveRightCommand(model));
	commands.put("display",new DisplayLevelCommand(model,view));
	commands.put("Exit", new ExitCommand(view));
	//this.view.setP(new LevelPrinter());
	//controller.start();
	this.controller.start();
}
*/
	@Override
	public void update(Observable o, Object arg) {
		LinkedList<String> params=(LinkedList<String>) arg;
		String commandKey= params.removeFirst();
		Command c=commands.get(commandKey);
		if(c==null){
			System.out.println("Error finding "+ commandKey);
			return;
		}
		c.setParams(params);

		controller.insertCommand(c);


		//if(o== this.model){
			//String type =arg.toString();
			//Command command= commands.get(type);

			//this.currentCommand=command;
		//	commandsQueue.add(this.currentCommand);


		}








	//public void start(String ip,int port){
		//try {
		//	Socket theServer = new Socket(ip, port);
		//	System.out.println("connected to server");

		//} catch (IOException e) {
	//		// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}

//	}



}
