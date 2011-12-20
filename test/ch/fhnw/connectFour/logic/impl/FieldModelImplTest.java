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
		
		FieldOwner fo = f.getFieldOwner(5, 5);
		System.out.println(fo);
		
		f.setFieldChanged(5, 5, FieldOwner.red);
		FieldOwner fo2 = f.getFieldOwner(5, 5);
		System.out.println(fo2);
	}

}
