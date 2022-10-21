package Akteure;

/**
 * 
 * @author oliver.keune, christian.supp, laurin.schubert Interface mit
 *         abstrakten Methoden, welche an die Unterklassen vererbt werde
 */
public interface Leckerbissen {

	public String getName();

	public int getGramm();

	public boolean gefressen();

	public boolean istLebendig();

	public Nahrungstyp getNahrungstyp();

}
