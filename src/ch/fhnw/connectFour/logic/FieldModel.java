package ch.fhnw.connectFour.logic;

import ch.fhnw.connectFour.logic.listeners.FieldListener;
import ch.fhnw.connectFour.persistance.FieldOwner;

public interface FieldModel {
	
	public boolean setFieldChanged(int x, int y, FieldOwner fieldOwner);
	
	FieldOwner getFieldOwner(int x, int y);
	
	void addListener(FieldListener fieldListener);

}
