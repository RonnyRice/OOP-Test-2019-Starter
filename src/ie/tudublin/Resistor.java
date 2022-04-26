package ie.tudublin;

import processing.core.PApplet
;

public class Resistor {

    int value;
    UI ui;
    Colour os;
    Colour ts;
    Colour hs;


    public Resistor(UI ui, int resistance) {
        this.ui = ui;
        this.value = resistance;

        int hundreds = (value / 100);
        int tens = (value - (hundreds * 100)) / 10;
        int ones = value - ((hundreds * 100)  + (tens * 10));
        
        this.os = ui.findColor(ones);
        this.ts = ui.findColor(tens);
        this.hs = ui.findColor(hundreds);
    }

    public void render(float x, float y){
        ui.pushMatrix();
        ui.translate(x, y);
        ui.stroke(0);
        ui.line(-100, 0, -50, 0);
        ui.line(-50, 0, -50, -50);
        ui.line(-50, -50, 50, -50);
        
        ui.line(50, -50, 50, 0);
        ui.line(50, 0, 100, 0);
        ui.line(50, 0, 50, 50);
        ui.line(50, 50, -50, 50);
        ui.line(-50, 50, -50, 0);

        // Draw the color bars
        ui.noStroke();
        ui.fill(hs.getR(), hs.getG(), hs.getB());
        ui.rect(-40, -49, 10, 99);
        
        ui.fill(ts.getR(), ts.getG(), ts.getB());
        ui.rect(-20, -49, 10, 99);
        
        ui.fill(os.getR(), os.getG(), os.getB());
        ui.rect(0, -49, 10, 99);
        ui.fill(0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(30);
        ui.text(value, 200, 0);
        ui.popMatrix();
    }
    
}
