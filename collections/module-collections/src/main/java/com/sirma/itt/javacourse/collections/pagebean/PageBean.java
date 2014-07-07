package com.sirma.itt.javacourse.collections.pagebean;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Receives a list of elements and allocates them in pages.
 * 
 * @param <E>
 *            the type of the elements.
 * 
 * @author radoslav
 */
public class PageBean<E> {
	private ArrayList<List<E>> pages;
	private static final Logger LOG = LoggerFactory.getLogger(PageBean.class);
	private int currentPage;

	/**
	 * Initializes {@link PageBean} object.
	 * 
	 * @param elements
	 *            The list of elements.
	 * @param pageSize
	 *            The size of each page.
	 */
	public PageBean(List<E> elements, int pageSize) {
		currentPage = 0;
		int fromIndex = 0;
		pages = new ArrayList<List<E>>();
		while (true) {
			if (fromIndex + pageSize >= elements.size()) {
				pages.add(elements.subList(fromIndex, elements.size()));
				break;
			} else {
				pages.add(elements.subList(fromIndex, fromIndex + pageSize));
			}
			fromIndex += pageSize;
		}
	}

	/**
	 * Checks if there are more pages.
	 * 
	 * @return <tt>true</tt> if there are more pages ahead and false the other
	 *         way round.
	 */
	public boolean hasNext() {
		return currentPage < pages.size();
	}

	/**
	 * Checks if there are any pages before the current one.
	 * 
	 * @return <tt>true</tt> if there are any previous pages and false the other
	 *         way round.
	 */
	public boolean hasPrevious() {
		return currentPage > 0;
	}

	/**
	 * Gets the next set of elements.
	 * 
	 * @return The next page.
	 */

	public List<E> next() {
		if (hasNext()) {
			currentPage += 1;
		} else {
			LOG.warn("No more pages.");
		}
		return pages.get(currentPage);
	}

	/**
	 * Gets the previous set of elements.
	 * 
	 * @return The previous page.
	 */
	public List<E> previous() {
		if (hasPrevious()) {
			currentPage -= 1;
		} else {
			LOG.warn("No previous pages available.");
		}
		return pages.get(currentPage);
	}

	/**
	 * Goes to the first page and makes it current.
	 * 
	 * @return the page
	 */
	public List<E> firstPage() {
		currentPage = 0;
		return pages.get(currentPage);
	}

	/**
	 * Goes to the last page and makes it current.
	 * 
	 */
	public List<E> lastPage() {
		currentPage = pages.size() - 1;
		return pages.get(currentPage);
	}
}
