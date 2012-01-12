package ch.fhnw.connectFour.persistance;

/**
 * Creates a field which can save a field owner enum.
 * 
 * @author Michel Heiniger
 * 
 */
public class Field {

	private FieldOwner fieldOwner;

	/**
	 * The field is initialized with no field owner.
	 */
	public Field() {

		fieldOwner = FieldOwner.none;
	}

	/**
	 * Returns a the field owner.
	 * 
	 * @return
	 */
	public FieldOwner getFieldOwner() {
		return fieldOwner;

	}

	/**
	 * sets a new field owner for the field
	 * 
	 * @param fieldOwner
	 */
	public void setFieldOwner(FieldOwner fieldOwner) {
		this.fieldOwner = fieldOwner;
	}

}
