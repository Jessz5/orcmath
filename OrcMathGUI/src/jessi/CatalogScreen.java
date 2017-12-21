package jessi;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
////import jessi.CatalogMaker;
//import jessi.CandyBars;

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
		list = new TextArea(320, 300, 100, 100, "List");
		viewObjects.add(list);
		
		text = new TextArea(40, 200, 200, 30, "contents");
		viewObjects.add(text);
		
		addButton = new Button(600, 90, 40, 40, "Add", new Action() {
			
			@Override
			public void act() {
				addClicked("Added");
				
			}
		} );
		viewObjects.add(addButton);
		saveButton = new Button(600, 120, 40, 40, "Save", new Action() {
			
			@Override
			public void act() {
				saveClicked("Saved");
				
			}
		});
		viewObjects.add(saveButton);
		deleteButton = new Button(600, 150, 40,40, "Delete", new Action() {
			
			@Override
			public void act() {
				deleteClicked("Deleted");
				
			}
		} );
		viewObjects.add(deleteButton);
		openButton = new FileOpenButton(600, 180, 40, 40, null, this);
		viewObjects.add(openButton);
		catalog = new CatalogMaker();
		}

	protected void deleteClicked(String string) {
		text.setText(string);
		
	}

	protected void saveClicked(String string) {
		text.setText(string);
		
	}

	protected void addClicked(String s) {
		catalog.addCandyBars(new CandyBars(name.getText(), Integer.parseInt(price.getText())));
		text.setText(s);
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