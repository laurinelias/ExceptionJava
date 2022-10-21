package Akteure;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 * 
 */
public class Taucher extends PassivesObjekt {

	/**
	 * Konstrukter für die Klasse Taucher, mit super Aufruf (Konstrukter
	 * PassivesObjekt)
	 */
	public Taucher(String name, Nahrungstyp nahrungstyp, int gewicht) {
		super(name, nahrungstyp, gewicht);
	}

	/**
	 * Methode, die (@code super.getName) zurückliefert
	 * 
	 * @return (@code super.getName)
	 */
	@Override
	public String getName() {
		return super.getName();
	}

}
