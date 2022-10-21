package Akteure;

import java.util.ArrayList;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 * 
 */
//	PFLANZE, FISCH, FLEISCH, NICHT_ESSBAR
public enum Esstyp {
	VEGANER(Nahrungstyp.PFLANZE), VEGETARIER(Nahrungstyp.PFLANZE), FLEXITARIER(Nahrungstyp.PFLANZE, Nahrungstyp.FISCH),
	FISCHESSER(Nahrungstyp.FISCH), FLEISCHESSER(Nahrungstyp.FISCH, Nahrungstyp.FLEISCH);

	private ArrayList<Nahrungstyp> verspeist = new ArrayList<>();

	/**
	 * Konstruktor, der der dynamischen Liste (@code verspeist) die Nahrungstypen
	 * zuweist.
	 * 
	 * @param isst
	 */
	private Esstyp(Nahrungstyp... isst) {
		for (Nahrungstyp typ : isst) {
			verspeist.add(typ);
		}
	}

	/**
	 * Methode, die bestimmt, welcher Meeresbewohner welche Nahrung akzeptiert.
	 * 
	 * @param typ
	 * @return boolean true, wenn Leckerbissen als Nahrung akzeptiert wird.
	 */
	public boolean akzeptiert(Nahrungstyp typ) {

		/**
		 * Wenn nicht essbar ODER Flexetarier Fisch oder Fleisch essen soll, dann wird
		 * der Leckerbissen mit 20-prozentiger Wahrscheinlichkeit verspeist.
		 */
		if ((this == FLEXITARIER && (typ == Nahrungstyp.FISCH || typ == Nahrungstyp.FLEISCH))
				|| typ == Nahrungstyp.NICHT_ESSBAR) {
			if (Math.random() > 0.8) {
				return true;
			}
			return false;
		}
		if (this.verspeist.contains(typ)) {
			return true;
		}
		return false;
	}
}