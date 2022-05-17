package fr.epsi.rennes.poec.phiv.exception;

public class TechnicalException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVariationUID = 1L;
	
	public TechnicalException(Exception e) {
		super(e);
	}
}
