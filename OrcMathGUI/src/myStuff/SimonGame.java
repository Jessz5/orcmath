package myStuff;

import guiTeacher.GUIApplication;

public class SimonGame extends GUIApplication {

	public SimonGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonScreen screen = new SimonScreen(getWidth(), getHeight());
		setScreen(screen);
	}
	
	public static void main(String[] args) {
		SimonGame s = new SimonGame(800,600);
		Thread runner = new Thread(s);
		runner.start();
	}

}
