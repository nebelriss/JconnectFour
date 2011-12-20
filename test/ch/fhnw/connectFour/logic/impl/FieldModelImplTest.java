package ch.fhnw.connectFour.logic.impl;

import org.junit.Test;

import ch.fhnw.connectFour.application.ApplicationContext;
import ch.fhnw.connectFour.application.ApplicationProperties;
import ch.fhnw.connectFour.persistance.FieldOwner;

public class FieldModelImplTest {

	@Test
	public void testFieldModelImpl() {
		ApplicationProperties p = new ApplicationProperties();
		ApplicationContext a = new ApplicationContext(null, p);
		FieldModelImpl f = new FieldModelImpl(a);
		
		f.getFieldOwner(5, 5);
		
		f.setFieldChanged(5, 5, FieldOwner.blue);
		f.getFieldOwner(5, 5);
	}

}
