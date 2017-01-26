package view;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import common.Element;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SokobanDisplayer extends Canvas {
	ArrayList<ArrayList<Element>>  sokoboanData;

	private StringProperty wallFileName;
	int cCol, cRow;


	public SokobanDisplayer() {
		wallFileName=new SimpleStringProperty();
		cCol=0;
		cRow=2;
	}
public void setCharacterPosition(int row,int col){
cCol=col;
cRow=row;
redraw();
}

	public int getcCol() {
		return cCol;
	}


	public int getcRow() {
		return cRow;
	}


	public String  getWallFileName() {
		return wallFileName.get();
	}

	public void setWallFileName(String wallFileName) {
		this.wallFileName.set(wallFileName);
	}






	public ArrayList<ArrayList<Element>> getSokoboanData() {
		return sokoboanData;
	}

	public void setSokoboanData(ArrayList<ArrayList<Element>>sokoboanData) {
		this.sokoboanData = sokoboanData;
		redraw();
	}

	public void redraw(){
		if(sokoboanData==null)
			return;

		GraphicsContext gc= getGraphicsContext2D();
		gc.setFill(javafx.scene.paint.Color.WHITESMOKE);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());

		int rows= sokoboanData.size();
		int cols=sokoboanData.get(0).size();
		double cellWidth= getWidth()/ cols;
		double cellHeight= getHeight()/rows;


		//gc.clearRect(0, 0, cellWidth, cellHeight);
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(sokoboanData.get(i).get(j)!=null)
					sokoboanData.get(i).get(j).draw(gc, i, j, cellWidth, cellHeight);
			}
			}
		}

	}
		/*
		if(sokoboanData!=null){
			double W =getWidth();
			double H= getHeight();
			double w=W/sokoboanData[0].length;
			double h= H/sokoboanData.length;
			GraphicsContext gc= getGraphicsContext2D();
			Image wall=null;
			try {
				wall = new Image(new FileInputStream(wallFileName.get()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gc.clearRect(0, 0, W, H);
			for(int i=0;i<sokoboanData.length;i++)
				for(int j=0;j<sokoboanData[i].length;j++){
					if(sokoboanData[i][j]=="#"){
						if(wall== null)
							gc.fillRect(j*w, i*h, w, h);
						else
							gc.drawImage(wall, j*w,i*h, w, h);

					}
				}
			gc.setFill(javafx.scene.paint.Color.RED);
			gc.fillOval(cCol*w,cRow*h, w, h);

			}


	}
	*/




