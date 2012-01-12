package ch.fhnw.connectFour.logic;

import ch.fhnw.connectFour.logic.listeners.FieldListener;
import ch.fhnw.connectFour.persistance.FieldOwner;

public interface FieldModel {
	
	public boolean setMove(int x, FieldOwner fieldOwner);
	public boolean rmMove(int x);
	public boolean movePosible(int x);
	
	public boolean setFieldChanged(int x, int y, FieldOwner fieldOwner);
	
	FieldOwner getFieldOwner(int x, int y);
	public boolean isRowFull(int x);
	
	public void clearFields();
	
	void addListener(FieldListener fieldListener);

}
