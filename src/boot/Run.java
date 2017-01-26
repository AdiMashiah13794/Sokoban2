package boot;

import java.util.Scanner;

import commands.LevelPrinter;
import controller.MyController;
import general.Controller;
import model.MyModel;
import model.policy.MySokobanPolicy;
import view.MyView;

public class Run {

	public static void main(String [] args){
		MyModel model= new MyModel();
		MyView view= new MyView();
		MyController controller = new MyController(view,model);

		model.addObserver(controller);
		view.addObserver(controller);

		view.start();
	}

	/**public static void main(String[] args) {
		MySokobanPolicy msp= new MySokobanPolicy();
		String str;
		System.out.print("load: ");
	    Scanner s = new Scanner(System.in);
	    str = s.nextLine();
		MyView v = new MyView();
		MyModel m= new MyModel(str);
		Controller c= new Controller(v,m);
		v.addObserver(c);
		m.addObserver(c);
		//int port=Integer.parseInt(args[1]);
		//String ip= args[0];
		c.update(m, "Load");
		c.start();
		//c.start(ip,port);
 		System.out.print("> ");
		 str = s.nextLine();

		s.close();


	}
	*/

}
