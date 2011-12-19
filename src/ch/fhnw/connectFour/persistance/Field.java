package ch.fhnw.connectFour.persistance;

public class Field {

	private final int x;
	private final int y;
	private FieldOwner fieldOwner;
	
	public Field(int x, int y) {
		this.x = x;
		this.y = y;
		fieldOwner = FieldOwner.none;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public FieldOwner getFieldOwner() {
		return fieldOwner;
	}
	
	public void setFieldOwner(FieldOwner fieldOwner) {
		this.fieldOwner = fieldOwner;
	}
	
}
