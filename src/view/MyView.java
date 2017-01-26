package view;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Scanner;

import commands.DisplayLevelCommand;
import commands.Printer;
import common.Level;
import model.Model;



public class MyView extends Observable implements View  {

	private DisplayLevelCommand dis;
	private  Printer p;
	boolean flag;
	Level level;

	public boolean isFlag() {
	return flag;
}

public void setFlag(boolean flag) {
	this.flag = flag;
}

	public DisplayLevelCommand getDis() {
		return dis;
	}

	public void setDis(DisplayLevelCommand dis) {
		this.dis = dis;
	}

	public Printer getP() {
		return p;
	}

	public void setP(Printer p) {
		this.p = p;
	}

	@Override
	public void start() {

		Scanner s= new Scanner(System.in);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while(flag==false){
				System.out.println("Enter the command >");
				LinkedList<String>params= new LinkedList<String>();
				String str= s.nextLine();
				if(str.equals("exit")|| str.equals("Exit")){
					params.add(str);
					setChanged();
					notifyObservers(params);
					exit();

				}

				if(str.contains("move")||str.contains("Move"))
					params.add(str);
				else{
					String[] list=str.split(" ");
					for(String s:list)
						params.add(s);

				}
				setChanged();
				notifyObservers(params);

			}
			}
		}).start();

	}

	public void display(Level level){
this.p.print(level);

	}



	@Override
	public void stop() {
this.flag=true;
	}

	@Override
	public void exit() {
this.flag=true;

	}





}





