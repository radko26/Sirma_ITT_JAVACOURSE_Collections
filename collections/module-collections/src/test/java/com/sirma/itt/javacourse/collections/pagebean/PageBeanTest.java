package com.sirma.itt.javacourse.collections.pagebean;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link PageBean}.
 * 
 * @author radoslav
 */
public class PageBeanTest {

	private static final int PAGESIZE = 2;
	private PageBean<Integer> bean;
	private ArrayList<Integer> test;
	private List<?> temp;

	/**
	 * Initializes all variables before the real tests.
	 */
	@Before
	public void init() {
		test = new ArrayList<Integer>();
		test.add(5);
		test.add(10);
		test.add(15);
		test.add(2);
		test.add(4);
		test.add(6);
		test.add(3);
		bean = new PageBean<Integer>(test, PAGESIZE);
	}

	/**
	 * Loops through the pages and compare them with the source list. First goes
	 * to the next page and compare with the source then goes back and compare
	 * again, then move on.
	 */
	@Test
	public void testNextAndPrevious() {
		temp = bean.firstPage();
		temp = bean.previous();
		if (PAGESIZE > test.size()) {
			assertEquals(test.subList(0, test.size()), temp);
		} else {
			assertEquals(test.subList(0, PAGESIZE), temp);
		}
		for (int i = 0; i < (test.size() / PAGESIZE) + (test.size() % PAGESIZE)
				- 1; i++) {
			if ((i + 1) * PAGESIZE > test.size()) {
				assertEquals(test.subList(i * PAGESIZE, test.size()), temp);
			} else {
				assertEquals(test.subList(i * PAGESIZE, (i + 1) * PAGESIZE),
						temp);
			}
			temp = bean.next();
			temp = bean.previous();
			if ((i + 1) * PAGESIZE > test.size()) {
				assertEquals(test.subList(i * PAGESIZE, test.size()), temp);
			} else {
				assertEquals(test.subList(i * PAGESIZE, (i + 1) * PAGESIZE),
						temp);
			}
			temp = bean.next();
		}
	}

	/**
	 * Checks the returned page with the source list.
	 */
	@Test
	public void testLastPage() {
		temp = bean.lastPage();
		if (test.size() % PAGESIZE == 0) {
			assertEquals(test.subList(test.size() - PAGESIZE, test.size()),
					temp);
		} else {
			assertEquals(
					test.subList(test.size() - test.size() % PAGESIZE,
							test.size()), temp);
		}
	}

}