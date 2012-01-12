package ch.fhnw.connectFour.persistance;

/**
 * 
 * 
 *
 */
public class Field {

	private FieldOwner fieldOwner;
	
	public Field() {
		
		fieldOwner = FieldOwner.none;
	}
	
	public FieldOwner getFieldOwner() {		
		return fieldOwner;

	}
	
	public void setFieldOwner(FieldOwner fieldOwner) {
		this.fieldOwner = fieldOwner;
	}
	
}
