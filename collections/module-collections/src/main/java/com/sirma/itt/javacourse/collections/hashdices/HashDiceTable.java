package com.sirma.itt.javacourse.collections.hashdices;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Saves information about dices combinations.
 * 
 * @author radoslav
 */
public class HashDiceTable {

	private HashMap<String, ArrayList<Integer>> table;
	private ArrayList<Integer> rolls;

	/**
	 * Initializes the table
	 */
	public HashDiceTable() {
		table = new HashMap<String, ArrayList<Integer>>();
	}

	/**
	 * 
	 * @param combination
	 *            The combination passed by string with format [ first,second ];
	 * @param rollNumber
	 *            Shows when the dice was thrown.
	 */
	public void insert(String combination, int rollNumber) {
		if (table.containsKey(combination)) {
			rolls = table.get(combination);
		} else {
			rolls = new ArrayList<Integer>();
		}
		rolls.add(rollNumber);
		table.put(combination, rolls);
	}

	/**
	 * Gets the table with all the results.
	 * 
	 * @return Returns the table.
	 */
	public HashMap<String, ArrayList<Integer>> getTable() {
		return table;
	}

}
