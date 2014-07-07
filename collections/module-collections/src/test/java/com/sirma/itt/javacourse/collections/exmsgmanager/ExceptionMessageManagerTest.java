package com.sirma.itt.javacourse.collections.exmsgmanager;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

/**
 * Tester for the {@link ExceptionMessageManager}
 * 
 * @author radoslav
 */
public class ExceptionMessageManagerTest {
	private HashMap<String, String> table;
	private ExceptionMessageManager manager;

	/**
	 * Initializes the global variables.
	 */
	@Before
	public void init() {
		table = new HashMap<String, String>();
		table.put("1", "Wrong name");
		table.put("2", "You are crossing the line, sir!");
		manager = new ExceptionMessageManager(table);
	}

	/**
	 * Adds an exceptionMessage to manager and compare the output with the
	 * previous input.
	 * 
	 * @throws Exception
	 *             In case of trying to add a message which does not exist in
	 *             the exception table.
	 */
	@Test
	public void testAdd() throws Exception {
		int counter = 0;

		manager.addExceptionMessage("Wrong name");
		manager.addExceptionMessageUsingCode("1");
		manager.addExceptionMessageUsingCode("2");

		Collection<String> output = ExceptionMessageManager.getMessages(manager
				.getMessage());

		for (String msg : output) {
			if (counter < 2) {
				assertEquals(msg, "Wrong name");
			} else {
				assertEquals(msg, "You are crossing the line, sir!");
			}
			counter++;
		}
	}

	/**
	 * Tries to add a message which does not exist in the exception table.
	 * 
	 * @throws Exception
	 *             In case of trying to add a message which does not exist in
	 *             the exception table.
	 */
	@Test(expected = Exception.class)
	public void testAddWithBadCode() throws Exception {
		manager.addExceptionMessageUsingCode("4");
	}

}
