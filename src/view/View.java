package view;

import commands.Printer;
import common.Level;
import model.Model;

public interface View {

	public void start();
	public void stop();
	public boolean isFlag();
	public void setFlag(boolean flag);
	public void display(Level level);
	//public Printer getP();
	public void exit();
	public void setP(Printer p);
}
