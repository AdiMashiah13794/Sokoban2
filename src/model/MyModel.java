package model;

import java.util.LinkedList;
import java.util.Observable;

import commands.Command;
import commands.ExitCommand;
import commands.LoadFileCommand;
import commands.MoveDownCommand;
import commands.MoveLeftCommand;
import commands.MoveRightCommand;
import commands.MoveUpCommand;
import commands.SaveFileCommand;
import common.Level;
import model.policy.MySokobanPolicy;

public class MyModel extends Observable implements Model   {
	private Level level;
	private Command command;
	private LoadFileCommand load= new LoadFileCommand();
	private SaveFileCommand save;
	private MoveUpCommand up = new MoveUpCommand(this);
	private MoveDownCommand down= new MoveDownCommand(this);
	private MoveLeftCommand left= new MoveLeftCommand(this);
	private MoveRightCommand right= new MoveRightCommand(this);
	private String filePath;
	private MySokobanPolicy msp= new MySokobanPolicy();
	boolean changed=false;
	LinkedList<String> params= new LinkedList<String>();


	public void moveLeft(){
		this.msp.setPlayer(this.level.getPlayers().get(0));

		this.msp.moveLeft(this.level);
		this.setChanged();
		//this.notifyObservers();
		params.add("display");
		this.notifyObservers(params);

	}

	public void moveRight(){
		this.msp.setPlayer(this.level.getPlayers().get(0));

		this.msp.moveRight(this.level);
		this.setChanged();
		//this.notifyObservers();
		params.add("display");
		this.notifyObservers(params);

	}

	public void moveUp(){
		this.msp.setPlayer(this.level.getPlayers().get(0));
		this.msp.moveUp(this.level);
		this.setChanged();
		//this.notifyObservers();
		params.add("display");
		this.notifyObservers(params);
	}

	public void moveDown()
	{
		this.msp.setPlayer(this.level.getPlayers().get(0));
		this.msp.moveDown(this.level);
		this.setChanged();
		//this.notifyObservers();
		params.add("display");
		this.notifyObservers(params);


	}
	public void load()
	{
		this.load.setFilePath(this.load.getParams().removeFirst());
		this.level=this.load.load();
		this.setChanged();
		params.add("display");
		this.notifyObservers(params);

	}

	public void save(){
		this.save.setFilePath(this.save.getParams().removeFirst());
		this.save.save();
		this.setChanged();
		params.add("display");

		this.notifyObservers(params); //לבדוק מה לעשות במצב כזה

	}

	public MySokobanPolicy getMsp() {
		return msp;
	}


	public void setMsp(MySokobanPolicy msp) {
		this.msp = msp;
	}


	public boolean isChanged() {
		return changed;
	}


	public void setChanged(boolean changed) {
		this.changed = changed;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



	public MyModel(String filePath) {
		this.filePath=filePath;
		this.load= new LoadFileCommand(this);
	}

	public MyModel() {

	}

	public MyModel(MySokobanPolicy policy){
		this.msp=policy;
		}


	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		//notifyObservers();
	}

	public LoadFileCommand getLoad() {
		return load;
	}

	public void setLoad(LoadFileCommand load) {
		this.load = load;
		//notifyObservers();

	}

	public SaveFileCommand getSave() {
		return save;
	}

	public void setSave(SaveFileCommand save) {
		this.save = save;
		//notifyObservers();

	}

	public MoveUpCommand getUp() {
		return up;
	}

	public void setUp(MoveUpCommand up) {
		this.up = up;

	}

	public MoveDownCommand getDown() {
		return down;
	}

	public void setDown(MoveDownCommand down) {
		this.down = down;

	}

	public MoveLeftCommand getLeft() {
		return left;
	}

	public void setLeft(MoveLeftCommand left) {
		this.left = left;

	}

	public MoveRightCommand getRight() {
		return right;
	}

	public void setRight(MoveRightCommand right) {
		this.right = right;

	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;

	}

	public MyModel(Command command,Level level) {
		this.command=command;
		this.level=level;

	}






	@Override
	public Level getcCurrentLevel() {
		return this.level;

		}


	@Override
	public MySokobanPolicy getPolicy() {
		return this.msp;
	}


	@Override
	public void setPolicy(MySokobanPolicy policy) {
		this.msp=policy;
	}

	@Override
	public void exit() {
		this.setChanged();
		params.add("Exit");

		this.notifyObservers(params);

	}




}






