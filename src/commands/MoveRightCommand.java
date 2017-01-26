package commands;

import common.Level;
import common.Player;
import model.Model;
import model.policy.MySokobanPolicy;

public class MoveRightCommand extends Move {



	public MoveRightCommand(Model model){
		this.model=model;
	}




	@Override
	public void execute() {
		this.setLev(this.model.getLevel());
		this.setMsp(this.model.getPolicy());
		this.setPlayer(this.model.getLevel().getPlayers().get(0));
		this.model.moveRight();


	}

}
