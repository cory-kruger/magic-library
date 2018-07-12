package ca.corykruger.magic.magic_library.gatherer.exceptions;

import ca.corykruger.magic.magic_library.gatherer.CardRetriever;

/**
 * To be thrown from {@link CardRetriever} when no <code>elements</code> can be selected using a given <code>selector</code>
 */
public class MissingElementException extends Exception {

	private static final long serialVersionUID = -2809875181762059619L;

	/**
	 * Instantiates the <code>exception</code> with a descriptive message
	 * @param selector The <code>selector</code> used that caused the exception
	 */
	public MissingElementException(String selector) {
		super("Unable to find element with selector " + selector);
	}

}
