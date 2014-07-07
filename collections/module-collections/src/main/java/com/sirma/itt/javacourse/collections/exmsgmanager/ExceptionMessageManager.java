package com.sirma.itt.javacourse.collections.exmsgmanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Codes exceptions to a string.
 * 
 * @author radoslav
 */
public class ExceptionMessageManager {

	private Map<String, String> exceptions;
	private static final char SEPARATOR = '-';
	private static final Pattern PATTERN = Pattern.compile("[^+" + SEPARATOR
			+ "]+?" + SEPARATOR);
	private StringBuilder message = new StringBuilder();
	/**
	 * Initializes the map.
	 * @param exceptions
	 * 		A map containing all the exception messages.
	 */
	public ExceptionMessageManager(Map<String, String> exceptions) {
		this.exceptions = exceptions;
	}

	/**
	 * Getter for the private filed message
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message.toString();
	}

	/**
	 * Adds new exception to the message string only if the message has not been
	 * added before.
	 * 
	 * @param mess
	 *            is the message
	 * @throws Exception
	 *             Throws custom exception.
	 */
	public void addExceptionMessage(String mess) throws Exception {
		if (exceptions.containsValue(mess)) {
			message.append(mess);
			message.append(SEPARATOR);
		} else {
			throw new Exception("This message has already been added");
		}
	}

	/**
	 * Adds new exception to the message string only if such key has already
	 * been entered.
	 * 
	 * @param messageCode
	 *            is the key
	 * @throws Exception
	 *             Custom Exception if there is not such key in the {@link Map}
	 */
	public void addExceptionMessageUsingCode(String messageCode)
			throws Exception {
		if (exceptions.containsKey(messageCode)) {
			message.append(SEPARATOR);
			message.append(exceptions.get(messageCode));
		} else {
			throw new Exception("No such key found");
		}
	}

	/**
	 * Returns the exceptions which were separated with the separator constant.
	 * 
	 * @param messagesCombination
	 *            is the message
	 * @return collection of strings, the sub-messages
	 */
	public static Collection<String> getMessages(String messagesCombination) {
		ArrayList<String> collection = new ArrayList<String>();
		Matcher m = PATTERN.matcher(messagesCombination);
		while (m.find()) {
			collection.add(m.group().substring(0, m.group().length() - 1));
		}
		return collection;
	}

}
