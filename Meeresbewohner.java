package Akteure;

import Exceptions.*;

/**
* @author oliver.keune, christian.supp, laurin.schubert
 * Unsere Hauptklasse für Fische und andere Meeresbewohner welche nicht direkt
 * Fische sind
 */
public class Meeresbewohner implements Leckerbissen {

	private Nahrungstyp nahrungstyp;
	private Esstyp esstyp;
	private boolean istLebendig = true;
	private int gewicht; // in gramm
	private int appetit;
	private String name;

	/**
	 * Konstruktor, der Meeresbewohner erzeugt.
	 * 
	 * @param name
	 * @param nahrungstyp
	 * @param esstyp
	 * @param magengroesse
	 * @param gewicht
	 * @throws DatenFehlerhaftException
	 */
	public Meeresbewohner(String name, Nahrungstyp nahrungstyp, Esstyp esstyp, int magengroesse, int gewicht)
			throws DatenFehlerhaftException {

		this.name = name;
		if (gewicht <= 0 || magengroesse <= 0) {
			throw new DatenFehlerhaftException("Fehlerhafte Dateneingabe: " + name + ": Daten <= 0");
		}
		this.gewicht = gewicht;
		this.appetit = magengroesse;
		this.nahrungstyp = nahrungstyp;
		this.esstyp = esstyp;

	}

	public String getName() {
		return name;
	}

	/**
	 * Methode in der überprüft wird, ob Meeresbewohner den Leckerbissen (@code
	 * beute) fressen kann. Dies wird in positivem Fall ausgeführt.
	 * 
	 * @param beute
	 * @return
	 * @throws FressException
	 */
	public boolean fressen(Leckerbissen beute) throws FressException {

		if (this.istLebendig()) {

			if (beute instanceof Meeresbewohner) {

				if (beute.istLebendig()) {

					if (esstyp.akzeptiert(beute.getNahrungstyp())) {

						if (appetit >= beute.getGramm()) {
							appetit -= beute.getGramm();
							gewicht += beute.getGramm();
							beute.gefressen();
							return true;

						} else {
							if (appetit == 0) {
								throw new MagenVollException();
							}
							throw new BeuteZuGrossException();

						}
					} else {
						throw new FalscherNahrungstypException();
					}
				} else {
					throw new NahrungBereitsGefressenException();
				}
			}

			else if (beute instanceof PassivesObjekt) {

				if (esstyp.akzeptiert(beute.getNahrungstyp())) {

					if (appetit >= beute.getGramm()) {
						appetit -= beute.getGramm();
						gewicht += beute.getGramm();
						beute.gefressen();
						return true;
					} else {
						if (appetit == 0) {
							throw new MagenVollException();
						}
						throw new BeuteZuGrossException();
					}
				} else {
					throw new FalscherNahrungstypException();
				}
			} else {
				throw new AkteurNichtErzeugtException();
			}

		} else {
			throw new AkteurBereitsGefressenException();
		}
	}

	/**
	 * Methode die das Gewicht (@code gewicht) zurückliefert.
	 * 
	 * @return gewicht
	 */
	@Override
	public int getGramm() {
		return gewicht;
	}

	/**
	 * Methode die boolean zurückliefert, ob der Meeresbewohner gefressen wurde
	 * (@code istLebendig).
	 * 
	 * @return istLebendig
	 */
	@Override
	public boolean gefressen() {
		gewicht = 0;
		return istLebendig = false;

	}

	/**
	 * Methode die boolean zurückliefert, ob der Meeresbewohner noch lebt (@code
	 * istLebendig).
	 * 
	 * @return istLebendig
	 */
	@Override
	public boolean istLebendig() {
		return istLebendig;
	}

	/**
	 * Methode die Nahrungstyp des Meeresbewohners zurückliefert (@code
	 * nahrungstyp).
	 * 
	 * @return nahrungstyp
	 */
	@Override
	public Nahrungstyp getNahrungstyp() {
		return nahrungstyp;
	}

}
