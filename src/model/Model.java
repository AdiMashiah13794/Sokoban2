package model;

import commands.LoadFileCommand;
import commands.MoveDownCommand;
import commands.MoveLeftCommand;
import commands.MoveRightCommand;
import commands.MoveUpCommand;
import commands.SaveFileCommand;
import common.Level;
import model.policy.MySokobanPolicy;

public interface Model  {
	public Level getLevel();
	public void setLevel(Level level);
	public LoadFileCommand getLoad();
	public void setLoad(LoadFileCommand load);
	public SaveFileCommand getSave();
	public void setSave(SaveFileCommand save);
	public MoveUpCommand getUp();
	public void setUp(MoveUpCommand up);
	public MoveDownCommand getDown();
	public void setDown(MoveDownCommand down);
	public MoveLeftCommand getLeft();
	public void setLeft(MoveLeftCommand left);
	public MoveRightCommand getRight();
	public void setRight(MoveRightCommand right);
	public Level getcCurrentLevel();
	public MySokobanPolicy getPolicy();
	public void setPolicy(MySokobanPolicy policy);
	public void moveLeft();
	public void exit();
	public void moveRight();
	public void moveUp();
	public void moveDown();
	public void load();
	public void save();

}
