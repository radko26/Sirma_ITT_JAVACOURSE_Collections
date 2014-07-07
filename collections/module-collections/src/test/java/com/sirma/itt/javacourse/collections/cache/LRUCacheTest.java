package com.sirma.itt.javacourse.collections.cache;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for {@link LRUCache}.
 * 
 * @author radoslav
 */
public class LRUCacheTest {

	/**
	 * Adds queries and checks if they have been discarded properly over the
	 * time.
	 */
	@Test
	public void testCache() {
		LRUCache<String, String> test = new LRUCache<String, String>(3);

		test.add("poza", "groza");
		test.add("hala", "dala");
		test.add("boza", "moza");
		test.add("mivka", "pivka");
		assertTrue(!test.getTable().containsKey("poza"));
	}

}
