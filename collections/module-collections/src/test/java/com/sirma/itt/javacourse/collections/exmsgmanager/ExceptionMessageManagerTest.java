package com.sirma.itt.javacourse.collections.exmsgmanager;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;

/**
 * Tester for the {@link ExceptionMessageManager}
 * 
 * @author radoslav
 */
public class ExceptionMessageManagerTest {

	/**
	 * Adds an exceptionMessage to manager and compare the output with the
	 * previous input.
	 * 
	 * @throws Exception
	 *             In case of wrong input regarding to the given task of the
	 *             problem.
	 */
	@Test
	public void testAdd() throws Exception {
		HashMap<String, String> table = new HashMap<String, String>();
		table.put("1", "Wrong name");

		ExceptionMessageManager manager = new ExceptionMessageManager(table);
		manager.addExceptionMessage("Wrong name");
		manager.addExceptionMessageUsingCode("1");
		Collection<String> output = ExceptionMessageManager.getMessages(manager.getMessage());
		for (String msg : output) {
			assertEquals(msg, "Wrong name");
		}
	}

}
