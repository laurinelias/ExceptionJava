package Akteure;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 * 
 *         Ein Leckerbissen ohne spezielle Fähigkeiten
 */
public class PassivesObjekt implements Leckerbissen {
	private String name;
	private Nahrungstyp nahrungstyp;
	private int gewicht;

	/**
	 * Konstruktor für Klasse PassivesObjekt
	 */
	public PassivesObjekt(String name, Nahrungstyp nahrungstyp, int gewicht) {
		this.name = name;
		this.nahrungstyp = nahrungstyp;
		this.gewicht = gewicht;
	}

	@Override
	public int getGramm() {
		return gewicht;
	}

	/**
	 * Methode, die boolean (@code gefressen) zurückliefert
	 * 
	 * @return gefressen
	 */
	@Override
	public boolean gefressen() {
		return false;

	}

	/**
	 * Methode, die false zurückgibt, da PassivesObjekt nicht lebendig ist
	 * 
	 * @return false;
	 */
	@Override
	public boolean istLebendig() {
		return false;
	}

	/**
	 * Methode, die Nahrungstyp (@code nahrungstyp) des passiven Objektes
	 * zurückgibt.
	 * 
	 * @return nahrungstyp;
	 */
	@Override
	public Nahrungstyp getNahrungstyp() {
		return nahrungstyp;
	}

	/**
	 * Methode, die den Namen des Passiven Objektes zurückliefert (@code name)
	 * 
	 * @return false
	 */
	@Override
	public String getName() {
		return name;

	}

}
