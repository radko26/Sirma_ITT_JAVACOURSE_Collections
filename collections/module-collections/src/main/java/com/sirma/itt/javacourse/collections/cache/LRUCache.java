package com.sirma.itt.javacourse.collections.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implements a container that deletes the least recently used items.
 * 
 * @author radoslav
 * @param <K>
 * 		the type of the key
 * @param <V>
 * 		the type of the value
 */

public class LRUCache<K, V>{
	private LinkedHashMap<K, V> table;
	
	/**
	 * Initializes and predefines the build in removeEldestEntry
	 * @param capacity
	 * 		the capacity of the container
	 */
	@SuppressWarnings("serial")
	public LRUCache(final int capacity){
		table = new LinkedHashMap<K, V>(capacity,0.75f,true){
			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
			    return size() > capacity;
			}
		};
	}
	/**
	 * Adds query to the table.
	 * @param key
	 * 		the key which is used to get the value.
	 * @param value
	 * 		the value
	 */
	public void add(K key, V value){
		table.put(key, value);
	}
	
	/**
	 * Gets the query with that key.
	 * @param key
	 * 		the key which is used to get the value.
	 * @return
	 * 		the value
	 */
	public V get(K key){
		return table.get(key);
	}
	
	/**
	 * Returns the table with all not removed queries.
	 * @return
	 * 		the {@link LinkedHashMap} table.
	 */
	public LinkedHashMap<K, V> getTable(){
		return table;
	}
	
}
