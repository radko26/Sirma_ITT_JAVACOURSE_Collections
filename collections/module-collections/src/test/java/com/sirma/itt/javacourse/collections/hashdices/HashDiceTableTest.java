package com.sirma.itt.javacourse.collections.hashdices;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testing {@link HashDiceTable};
 * 
 * @author radoslav
 */
public class HashDiceTableTest {
	private static final int SIDES = 3;
	private static final int ROLLS = 10;

	/**
	 * Simulates all the rolls and checks if the index has been added
	 * successfully.
	 */
	@Test
	public void testInsert() {
		HashDiceTable table = new HashDiceTable();
		String combination;

		for (int i = 0; i < ROLLS; i++) {
			int first = (int) (Math.random() * SIDES + 1);
			int second = (int) (Math.random() * SIDES + 1);
			combination = new String(first + "," + second);
			table.insert(combination, i);
			assertTrue(table.getTable().get(combination).contains(i));
		}
	}

}
