package Exceptions;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */
public class FalscherNahrungstypException extends FressException {

	private static final long serialVersionUID = 1L;

	public FalscherNahrungstypException() {
		super();
	}

	public FalscherNahrungstypException(String msg) {
		super(msg);
	}

}
