package common;

import java.io.Serializable;
import java.util.ArrayList;

import model.data.ConvertStrToObj;

@SuppressWarnings("serial")

public class Level  implements Serializable {
 ArrayList<Element>elements=new ArrayList<Element>();
 ArrayList<Box> boxes= new ArrayList<Box>();
 ArrayList<Wall> walls= new ArrayList<Wall>();
ArrayList<Destination> destinations = new ArrayList<Destination>();
ArrayList<Player>sokobans = new ArrayList<Player>();
ArrayList<Space>spaces = new ArrayList<Space>();
ArrayList<String>elementsString;
ArrayList<ArrayList<Element>> dynamicObjects=null;
int maxCol;
int maxRow;


// get set methods
public ArrayList<Element> getElements() {
	return elements;
}
public void setElements(ArrayList<Element> elements) {
	this.elements = elements;
}
public ArrayList<String> getElementsString() {
	return elementsString;
}
public void setElementsString(ArrayList<String> elementsString) {
	this.elementsString = elementsString;
}
public ArrayList<ArrayList<Element>> getDynamicObjects() {
	return dynamicObjects;
}
public void setDynamicObjects(ArrayList<ArrayList<Element>> dynamicObjects) {
	this.dynamicObjects = dynamicObjects;
}
public ArrayList<Space> getSpaces() {
	return spaces;
}
public void setSpaces(ArrayList<Space> spaces) {
	this.spaces = spaces;
}
public ArrayList<String> getelementsString() {
	return elementsString;
}
public void setelementsString(ArrayList<String> elementsString) {
	this.elementsString = elementsString;
}

public ArrayList<Element> getCharacters() {
	return elements;
}
public void setCharacters(ArrayList<Element> characters) {
	this.elements = characters;
}

public ArrayList<Box> getBoxes() {
	return boxes;
}

public void setBoxes(ArrayList<Box> boxes) {
	this.boxes = boxes;
}

public ArrayList<Wall> getWalls() {
	return walls;
}


public void setWalls(ArrayList<Wall> walls) {
	this.walls = walls;
}


public ArrayList<Destination> getDestinations() {
	return destinations;
}


public int getMaxCol() {
	return maxCol;
}
public void setMaxCol(int maxCol) {
	this.maxCol = maxCol;
}
public int getMaxRow() {
	return maxRow;
}
public void setMaxRow(int maxRow) {
	this.maxRow = maxRow;
}
public void setDestinations(ArrayList<Destination> destinations) {
	this.destinations = destinations;
}


public ArrayList<Player> getPlayers() {
	return sokobans;
}

public void setPlayers(ArrayList<Player> players) {
	this.sokobans = players;
}

public int getBoxNumber(){
	return this.getBoxes().size();
}
public int getDestNumber(){
	return this.getDestinations().size();
}
public int getSpaceNumber(){
	return this.getSpaces().size();
}
public int getPlayerNumber(){
	return this.getPlayers().size();
}
public int getWallNumber(){
	return this.getWalls().size();
}

public int boxOnDest (){
	int counter=0;
	for(int i=0;i<elementsString.size();i++){
		int j=0;
		String temp=elementsString.get(i);
		for (char tav: temp.toCharArray()){
			if((tav=='O') &&(dynamicObjects.get(i).get(j).getClass()==getBoxes().get(0).getClass()))
					counter++;
			j++;
		}

	}
	return counter;
}

public boolean Win(){
	int boxes= getBoxNumber();
	if(boxOnDest()==boxes)
		return true;
	return false;

}
public Level()
{
elements=new ArrayList<Element>();
ArrayList<Box> boxes= new ArrayList<Box>();
ArrayList<Wall> walls=new ArrayList<Wall>();
ArrayList<Destination> destinations =new ArrayList<Destination>();
ArrayList<Player>players = new ArrayList<Player>();
}

public Level (ArrayList<String> c){
elementsString = new ArrayList<String>();
this.elementsString=c;
Position pos= new Position();
int col=0;
dynamicObjects=new ConvertStrToObj().convert(c);

for(int i=0;i<c.size();i++){
	String temp=c.get(i);
	pos.setX(i);
	if(this.maxRow<=i)
		this.maxRow=i;
	for (char tav: temp.toCharArray())
	{
		if(tav==' '){
			Space space= new Space(new Position(i,col));
			dynamicObjects.get(i).add(space);
			elements.add(space);
			spaces.add(space);		}
		if(tav=='#'){
			Wall wall= new Wall(new Position(i,col));
			dynamicObjects.get(i).add(wall);
			elements.add(wall);
			walls.add(wall);
		}
		if(tav=='O'){
			Destination des= new Destination(new Position(i,col));
			dynamicObjects.get(i).add(des);
			elements.add(des);
			destinations.add(des);

		}
		if(tav=='A'){
			Player player= new Player(new Position(i,col));
			dynamicObjects.get(i).add(player);
			elements.add(player);
			sokobans.add(player);
		}
		if(tav=='@'){
			Box box= new Box(new Position(i,col));
			dynamicObjects.get(i).add(box);
			elements.add(box);
			boxes.add(box);
		}

	col++;
	if(col>= this.maxCol)
	{
		this.maxCol=col;

	}
	pos.setY(col);

}
	col=0;
}
for(int i=0;i<=maxRow;i++)
	for(int j=dynamicObjects.get(i).size();j<=maxCol;j++)
	{
		if (dynamicObjects.get(i).size()<maxCol)
			dynamicObjects.get(i).add(j, new Space(new Position(i,j)));
	}
}
}
