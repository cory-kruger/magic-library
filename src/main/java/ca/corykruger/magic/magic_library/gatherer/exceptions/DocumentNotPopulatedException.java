package ca.corykruger.magic.magic_library.gatherer.exceptions;

import ca.corykruger.magic.magic_library.gatherer.CardRetriever;

/**
 * To be thrown from {@link CardRetriever} when attempting to use a null <code>Document</code>
 */
public class DocumentNotPopulatedException extends Exception {

	private static final long serialVersionUID = 6109467548223519785L;

	/**
	 * Instantiates the <code>exception</code>
	 */
	public DocumentNotPopulatedException() {
		super();
	}

}
