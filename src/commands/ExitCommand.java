package commands;

import common.Level;
import view.View;

public class ExitCommand extends Command {
	private Level lev;
	private boolean flag;


	public ExitCommand(View view){
		this.lev=null;
		this.view=view;

	}
	public ExitCommand(){
		this.lev=null;

	}


	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Level getLev() {
		return lev;
	}

	public void setLev(Level lev) {
		this.lev = lev;
	}


	public ExitCommand(Level lev,boolean flag){
		this.lev=lev;
		this.flag=flag;
	}
	@Override
	public void execute() {
		this.flag=true;

	}

}
