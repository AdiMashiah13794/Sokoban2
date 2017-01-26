package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Destination extends Element implements Serializable {

	private Image destImage;

	public Destination() {
		this.pos.setX(0);
		this.pos.setY(0);
		try {
			destImage= new Image(new FileInputStream("./resources/net.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Destination(Position pos){
		this.setPos(pos);
		try {
			destImage= new Image(new FileInputStream("./resources/net.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public String toString()
	{
		return "O";
	}

@Override
public void draw(GraphicsContext gc, int i, int j, double cellWidth, double cellHeight) {
	gc.drawImage(destImage, j*cellWidth, i*cellHeight,0.95*cellWidth,0.95*cellHeight);

}
}
