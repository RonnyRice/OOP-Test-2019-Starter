package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet
{	

	int resistorID = 0;
	boolean lastPressed = false;

	ArrayList<Colour> colours =  new ArrayList<Colour>();
	ArrayList<Resistor> resistors =  new ArrayList<Resistor>();
	
	public void separate(int value)
	{
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100)  + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

	public void loadColours(){

		Table table = loadTable("colours.csv", "header");

		for(TableRow row : table.rows()){

			Colour colour = new Colour(row);
			colours.add(colour);

		}
	}

	public void printColours()
	{
		for (Colour c : colours) {

			println(c);
			
		}
	}

	public Colour findColor(int value){

		for(Colour t : colours){

			if(t.getValue() == value){

				return t;
			}
		}

		return null;
	}

	public void loadResistors(){

		Table table = loadTable("resistors.csv");

		for(TableRow  row: table.rows() )
		{
			resistors.add(new Resistor(this, row.getInt(0)));
		}
	}

	public void printResistors(){

		for( Resistor r: resistors)
		{
			int i = r.value;
			int hundreds = (i / 100);
			int tens = (i - (hundreds * 100)) / 10;
			int ones = i - ((hundreds * 100)  + (tens * 10));
			print(hundreds + ",");
			print(tens + ",");
			println(ones);	
		}
	}

	public void settings()
	{
		size(500, 800);
		
		loadColours();
		loadResistors();
		printResistors();
	}

	public void setup() 
	{

		
	}
	
	public void draw()
	{			
		background(200);
		stroke(225);
		

		for(int i = 0; i < resistors.size(); i++){
			float y = map(i, 0, resistors.size(), 100, height - 100);
			resistors.get(i).render(width/2,y);
		}
	}
}
