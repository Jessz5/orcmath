package jessi;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {
	
	private TextField descriptionBox;
	private TextField name;
	private TextField price;
	private TextArea text;
	private Button addButton;
	private Button saveButton;
	private Button deleteButton;
	private FileOpenButton openButton;
	private Catalog catalog;

	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		descriptionBox = new TextField(40, 40, 200, 30, "insert text", "description");
		viewObjects.add(descriptionBox);
		name = new TextField(40, 90, 200, 30, "insert name", "name");
		viewObjects.add(name);
		price = new TextField(40, 140, 200, 30, "insert price", "price");
		viewObjects.add(price);
		//TextField.INPUT_TYPE_NUMERIC;
		
		text = new TextArea(40, 180, 200, 30, "contents");
		viewObjects.add(text);
		
		addButton = new Button(40, 210, 200, 30, "add", new Action() {
			
			@Override
			public void act() {
				addClick();
			}
		});
		viewObjects.add(addButton);
		saveButton = new Button(40, 230, 200, 30, "save", new Action() {

			@Override
			public void act() {
				saveClick();
			}
		});
		viewObjects.add(saveButton);
		deleteButton = new Button(40, 250, 200, 30, "delete", new Action() {

			@Override
			public void act() {
				deleteClick();
			}
		});
		viewObjects.add(deleteButton);
		
		openButton = new FileOpenButton(40, 280, 200, 30, null, this);
		viewObjects.add(openButton);
		
		catalog = new Catalog();
	}

	protected void addClick() {
		CandyBars = new CandyBars(descriptionBox.getText(), name.getText(), price.getText());
		text.setText("");
	}
	
	protected void saveClick() {
		text.setText("save button clicked");
	}
	
	protected void deleteClick() {
		text.setText("delete button clicked");
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}