package jessi;

import java.awt.Color;
import java.awt.Graphics2D;

//import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class CandyBars extends Component {
	
	private String name;
	private double price;
	

	public CandyBars(String name, double price) {
		super(40, 40, 180, 180);
		this.name = name;
		this.price = price;
	}
	

	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.blue);
		//g.fillRect(0, 0, getWidth(), getHeight());
		//super.update(g);
	}

	public String toString() {
		return name+","+price;
	}


}
































