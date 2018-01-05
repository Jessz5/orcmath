package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameJessi extends GUIApplication {

	public SimonGameJessi(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonScreenJessi screen = new SimonScreenJessi(getWidth(), getHeight());
		setScreen(screen);
	}
	
	public static void main(String[] args) {
		SimonGameJessi s = new SimonGameJessi(800,600);
		Thread runner = new Thread(s);
		runner.start();
	}

}
