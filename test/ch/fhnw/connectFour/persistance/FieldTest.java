package ch.fhnw.connectFour.persistance;

import static org.junit.Assert.*;

import org.junit.Test;

public class FieldTest {

	@Test
	public void testField() {
		Field field = new Field();
		
		assertEquals("Owner:", FieldOwner.none, field.getFieldOwner());
		
		field.setFieldOwner(FieldOwner.red);
		assertEquals("Owner:", FieldOwner.red, field.getFieldOwner());
	}

}
