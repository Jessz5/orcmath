package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJessi extends ClickableScreen implements Runnable {
	
	private TextLabel label;
	private ButtonInterfaceJessi[] buttons;
	private ProgressInterfaceJessi progress;
	private ArrayList<MoveInterfaceJessi> sequence;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenJessi(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText("");
		nextRound();
	}
	
	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		MoveInterfaceJessi move = randomMove();
		sequence.add(move);
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceJessi b = null;
		for(int i = 0; i < sequence.size(); i++) {
			if(b != null) {
				b.dim();
				b = sequence.get(i).getButton();
				b.highlight();
				int sleepTime = (10000 - (roundNumber * 100)) + 1000;
				try {
					Thread.sleep(sleepTime);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				b.dim();
			}
		}
		
	}

	private void changeText(String string) {
		label.setText(string);
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceJessi b: buttons) {
			viewObjects.add(b);
		}
		progress = getProcess();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceJessi>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		
	}
	
	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceJessi getProcess() {
		return new ProgressJessi(10,10,10,10);
	}

	private MoveInterfaceJessi randomMove() {
		int bIndex = (int)(Math.random()*buttons.length);
		while(bIndex == lastSelectedButton) {
			bIndex = (int)(Math.random()*buttons.length);
		}
		return getMove(bIndex);
	}


	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceJessi getMove(int bIndex) {
		return new MoveJessi(buttons[bIndex]);
	}

	private void addButtons() {
		int numberOfButtons = 5;
		buttons = new ButtonInterfaceJessi[numberOfButtons];
		Color[] colors = {Color.red, Color.yellow, Color.green, Color.cyan, Color.magenta};
		for(int i = 0; i < numberOfButtons; i++) {
			final ButtonInterfaceJessi b = getAButton();
			buttons[i] = b;
			b.setColor(colors[i]);
			b.setX(60+60*i);
			b.setY(60);
			b.setAction(new Action() {
				
				@Override
				public void act() {
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable() {
							
							@Override
							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
									} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									}
									b.dim();
							}
						});
						blink.start();
						if(b == sequence.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						}else {
							progress.gameOver();
						}
					}
					if(sequenceIndex == sequence.size()){ 
					    Thread nextRound = new Thread(SimonScreenJessi.this); 
					    nextRound.start(); 
					}
				}
			});
		}
	}

	private ButtonInterfaceJessi getAButton() {
		return new ButtonJessi(10,10,50,50,"",null);
	}

	
	
}
