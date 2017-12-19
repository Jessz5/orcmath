package jessi;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class CandyBars extends AnimatedComponent {
	
	String name;
	double price;
	

	public CandyBars(String name, double price) {
		super(40, 40, 6144, 512);
		addSequence("resources/spritesheet.png", 100, 0, 0, 50, 60, 5);
		Thread animation = new Thread(this);
		animation.start();
		update();

	}
	

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.blue);
		//g.fillRect(0, 0, getWidth(), getHeight());
		super.update(g);
	}

	public String toString() {
		return name+","+price;
	}
}
































