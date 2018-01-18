package test;

import guiTeacher.GUIApplication;

public class Task extends GUIApplication {

	public Task(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		Test1 screen = new Test1(getWidth(), getHeight());
		setScreen(screen);
	}
	
	public static void main(String[] args) {
		Task s = new Task(800,600);
		Thread runner = new Thread(s);
		runner.start();
	}

}