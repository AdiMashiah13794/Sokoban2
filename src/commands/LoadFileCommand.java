package commands;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import common.Level;
import model.Model;
import model.data.LevelLoader;
import model.data.MyObjectLevelLoader;
import model.data.MyTextLevelLoader;
import model.data.MyXMLLevelLoader;


public class LoadFileCommand extends Command {
	private HashMap<String, LevelLoader> commands;
	private String filePath;
	private Level lev;
	private String type;


	public HashMap<String, LevelLoader> getCommands() {
		return commands;
	}

	public void setCommands(HashMap<String, LevelLoader> commands) {
		this.commands = commands;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Level getLev() {
		return lev;
	}
	public void setLev(Level lev) {
		this.lev = lev;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LoadFileCommand() {
		this.commands= new HashMap<>();
		commands.put("txt", new MyTextLevelLoader());
		commands.put("dat", new MyObjectLevelLoader());
		commands.put("xml", new MyXMLLevelLoader());


	}
	public LoadFileCommand(Model model) {
		this.model=model;
		this.commands= new HashMap<>();
		commands.put("txt", new MyTextLevelLoader());
		commands.put("dat", new MyObjectLevelLoader());
		commands.put("xml", new MyXMLLevelLoader());


	}


	@Override
	public void execute() {
		this.model.setLoad(this);
		this.model.load();

	}

	public Level load(){
		if(this.filePath.contains("txt"))
			this.type="txt";
		if(this.filePath.contains("dat"))
			this.type="dat";
		if(this.filePath.contains("xml"))
			this.type="xml";
		if(commands.containsKey(this.type)){
			File f= new File(this.filePath);
			FileInputStream fis;

			try {
				if(this.type=="xml")
					encoder(this.filePath, this.model.getLevel());
				fis = new FileInputStream(f);
					this.lev=commands.get(this.type).loadLevel(fis);

			} catch (FileNotFoundException e) {
				System.out.println("The file is not found");
				System.exit(1);
			}
		}
		return this.lev;

	}

	private void encoder(String filePath2, Level lev2) {
		FileOutputStream os;
		try {
			os = new FileOutputStream(filePath2);
			XMLEncoder encoderi= new XMLEncoder(os);
			encoderi.writeObject(lev2);
			encoderi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}

}
}

