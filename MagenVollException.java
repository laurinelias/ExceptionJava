package Exceptions;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */
public class MagenVollException extends FressException {

	private static final long serialVersionUID = 1L;

	public MagenVollException() {
		super();

	}

	public MagenVollException(String msg) {
		super(msg);
	}
}