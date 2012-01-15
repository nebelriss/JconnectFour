/*
 * Copyright 2011 Michel Heiniger
 * This file is part of JconnectFour.
 * JconnectFour is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * JconnectFour is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with JconnectFour. If not, see http://www.gnu.org/licenses/.
 */

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
