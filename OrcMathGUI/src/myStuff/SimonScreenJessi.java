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
	private int roundNumber = 0;
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
		sequence.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's Turn");
		label.setText("");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceJessi b = null;
		for(int i = 0; i < sequence.size(); i++) {
			if(b != null) {
				b.dim();
			}
			b = sequence.get(i).getButton();
			b.highlight();
			int sleepTime = (1000 - (roundNumber * 100)) + 100;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String string) {
		label.setText(string);
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		label.setText("");
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
		return new ProgressJessi(0,0,800,200);
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
		    		    Thread blink = new Thread(new Runnable(){
		    		        public void run(){
		    		        	b.highlight();
		    		            try {
		    		                Thread.sleep(800);
		    		            } catch (InterruptedException e) {
		    		                e.printStackTrace();
		    		            }
		    		            b.dim();
		    		        }
		    		    });
		    		    blink.start();
		    		    if(b == sequence.get(sequenceIndex).getButton()) {
		    		    	sequenceIndex++;
		    		    	if(sequenceIndex == sequence.size()){
			    		        Thread nextRound = new Thread(SimonScreenJessi.this);
			    		        nextRound.start();
			    		    }
		    		    }
		    		    else {
		    		    	progress.gameOver();
		    		    	for(int i = 0; i < buttons.length; i++) {
		    					buttons[i].setAction(null);
		    				}
		    		    }
		    		}
		    	}
		    });
		    buttons[i] = b;
		}
	}

	private ButtonInterfaceJessi getAButton() {
		return new ButtonJessi(0,0,50,50,"",null);
	}

	
	
}
