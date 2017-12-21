package jessi;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {

	private TextField name;
	private TextField price;
	private TextArea text;
	private TextArea list;
	private Button addButton;
	private Button saveButton;
	private Button deleteButton;
	private FileOpenButton openButton;
	private CatalogMaker catalog;

	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		name = new TextField(40, 90, 200, 30, "insert name", "name");
		viewObjects.add(name);
		price = new TextField(40, 140, 200, 30, "insert price", "price");
		viewObjects.add(price);
		price.setInputType(TextField.INPUT_TYPE_NUMERIC);
		list = new TextArea(40, 200, 200, 30, "Candy Bars List");
		viewObjects.add(list);
		
		text = new TextArea(40, 40, 200, 30, "contents");
		viewObjects.add(text);
		
		addButton = new Button(40, 210, 200, 30, "Add", new Action() {
			
			@Override
			public void act() {
				addClick();
			}
		});
		viewObjects.add(addButton);
		
		saveButton = new Button(40, 230, 200, 30, "Save", new Action() {

			@Override
			public void act() {
				saveClick();
			}
		});
		viewObjects.add(saveButton);
		
		deleteButton = new Button(40, 250, 200, 30, "Delete", new Action() {

			@Override
			public void act() {
				deleteClick();
			}
		});
		viewObjects.add(deleteButton);
		
		openButton = new FileOpenButton(40, 280, 200, 30, null, this);
		viewObjects.add(openButton);
		
		catalog = new CatalogMaker();
	}
	
	protected void deleteClick() {
		text.setText("");
		
	}

	protected void saveClick() {
		text.setText("");
		
	}

	protected void addClick() {
		CandyBars a = new CandyBars(name.getText(), Integer.parseInt(price.getText()));
		catalog.addCandyBars(a);
		list.setText(catalog.getCSVContent());
		name.setText("");
		price.setText("");
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