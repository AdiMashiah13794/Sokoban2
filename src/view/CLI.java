package view;

import java.util.LinkedList;
import java.util.Scanner;

import commands.DisplayLevelCommand;
import commands.Printer;

public class CLI {

	//private  Printer p;


	//public DisplayLevelCommand getDis() {
	//	return dis;
	//}

	//public void setDis(DisplayLevelCommand dis) {
		//this.dis = dis;
	//}

	//public Printer getP() {
	//	return p;
	//}

	//public void setP(Printer p) {
	//	this.p = p;
	//}


	public void start() {

		Scanner s= new Scanner(System.in);

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("test");
				while(true){
				System.out.println("Enter the command >");
				LinkedList<String>params= new LinkedList<String>();
				String str= s.nextLine();
				if(str.equals("exit")|| str.equals("Exit"))
						break;
				if(str.contains("move")||str.contains("Move"))
					params.add(str);
				else{
					String[] list=str.split(" ");
					for(String s:list)
						params.add(s);

				}
				//להעביר לכאו את סט קיינג ואת נוטיפיי אובסרבס


			}
			}
		}).start();

	}

}
