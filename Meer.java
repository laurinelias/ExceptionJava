
package Szene;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Akteure.*;
import de.hsrm.mi.prog2.TextIO;

import Exceptions.*;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */

/**
 * Hauptklasse in der die Akteure instanziert werden und Szene abgespielt sowie
 * die Exceptions abgefangen werden
 */
public class Meer {
	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> aufgetreteneExceptions = new HashMap<>();
		ArrayList<Leckerbissen> leckerbissenList = new ArrayList<>();
		ArrayList<String> szeneListe = new ArrayList<>();
		Leckerbissen akteur1 = null, akteur2 = null;
		String interaktion = null;
		String akteure;
		String szene;
		String emoji1 = "";
		String emoji2 = "";

		try {
			akteure = args[0];
			szene = args[1];
		} catch (Exception e) {
			akteure = "akteure.txt";
			szene = "szene.txt";
		}
		List<String> akteureListe = new ArrayList<>();
		try {
			akteureListe = TextIO.read(new File(akteure));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String akteur : akteureListe) {
			String[] details = akteur.split(",");

			try {
				switch (details[0]) {
				case "Meeresbewohner":
					leckerbissenList.add(new Meeresbewohner(details[1].trim(), Nahrungstyp.valueOf(details[2].trim()),
							Esstyp.valueOf(details[3].trim()), Integer.parseInt(details[4].trim()),
							Integer.parseInt(details[5].trim())));

					break;
				case "Taucher":
					leckerbissenList.add(new Taucher(details[1].trim(), Nahrungstyp.valueOf(details[2].trim()),
							Integer.parseInt(details[3].trim())));
					break;
				case "PassivesObjekt":
					for (int i = 0; i < Integer.parseInt(details[3].trim()); i++) {
						leckerbissenList.add(new PassivesObjekt(details[1].trim(),
								Nahrungstyp.valueOf(details[2].trim()), Integer.parseInt(details[4].trim())));
					}

					break;
				default:
					throw new DatenFehlerhaftException(details[0] + ": unbekannte Klasse.");

				}
			} catch (IllegalArgumentException iae) {
				throw new DatenFehlerhaftException(details[1] + ": Fehlerhafte Dateneingabe");
			}
		}

		try {
			szeneListe = TextIO.read(new File(szene));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String beschreibung : szeneListe) {
			String[] details = beschreibung.split(" ");
			try {
				interaktion = details[1];
			} catch (IndexOutOfBoundsException e) {
				addException(e, aufgetreteneExceptions);
				throw new DatenFehlerhaftException();
			}

			try {
				for (Leckerbissen akt : leckerbissenList) {
					if (akteur1 != null && akteur2 != null) {
						break;
					}

					if (compareType(akt, details[0])) {
						akteur1 = akt;
						emoji1 = (akt.getNahrungstyp()).toString();

					}

					if (compareType(akt, details[details.length - 1])) {
						akteur2 = akt;
						emoji2 = (akt.getNahrungstyp()).toString();
					}

				}
				if (akteur1 == null || akteur2 == null) {
					throw new AkteurNichtErzeugtException();
				}
			} catch (NullPointerException e) {
				addException(e, aufgetreteneExceptions);
				throw new DatenFehlerhaftException();
			} catch (AkteurNichtErzeugtException e) {
				addException(e, aufgetreteneExceptions);
				System.out.println("Die angegebene Ressource ist nicht (mehr) vorhanden...");
			}
			// 🐢🐋
			switch (emoji1) {
			case "FISCH":
				emoji1 = "🐠";
				break;
			case "PFLANZE":
				emoji1 = "🌱";
				break;
			case "FLEISCH":
				emoji1 = "🦈";
				break;
			case "NICHT_ESSBAR":
				emoji1 = "🥡";
				break;
			default:
				emoji1 = "";
			}

			switch (emoji2) {
			case "FISCH":
				emoji2 = "🐠";
				break;
			case "PFLANZE":
				emoji2 = "🌱";
				break;
			case "FLEISCH":
				emoji2 = "🦈";
				break;
			case "NICHT_ESSBAR":
				emoji2 = "🥡";
				break;
			default:
				emoji2 = "";
			}

			switch (interaktion) {
			case "frisst":
			case "fressen":
			case "isst":
				try {
					System.out.print(akteur1.getName() + " " + emoji1 + " versucht " + akteur2.getName() + " " + emoji2
							+ " zu fressen...           \t");
					try {
						((Meeresbewohner) akteur1).fressen(akteur2);
					} catch (ClassCastException e) {
						throw (new KannNichtFressenException());
					}
					System.out.println(akteur1.getName() + " hat " + akteur2.getName() + " erfolgreich gefressen.");
					if (akteur2 instanceof PassivesObjekt)
						leckerbissenList.remove(akteur2);

				} catch (NullPointerException e) {
				}

				catch (RessourcenErschoepftException e) {
					addException(e, aufgetreteneExceptions);
					System.out.println("Die Nahrungsquelle ist erschöpft und nicht mehr vorhanden.");
				}

				catch (FalscherNahrungstypException e) {
					addException(e, aufgetreteneExceptions);
					System.out.println("Nahrungstyp ist für " + akteur1.getName() + " unzulässig... "
							+ akteur2.getName() + " wurde wieder ausgespuckt.");
				} catch (NahrungBereitsGefressenException e) {
					addException(e, aufgetreteneExceptions);
					System.out.println(
							akteur2.getName() + " kann nicht mehr gefressen werden, da er bereits gefressen wurde.");
				} catch (MagenVollException e) {
					addException(e, aufgetreteneExceptions);
					System.out
							.println(akteur1.getName() + " kann nichts mehr fressen, da sein Magen bereits voll ist.");
				} catch (BeuteZuGrossException e) {
					addException(e, aufgetreteneExceptions);
					System.out.println(akteur1.getName() + " kann " + akteur2.getName() + " nicht fressen, da "
							+ akteur2.getName() + " zu groß für den Magen von " + akteur1.getName() + " ist");
				} catch (AkteurNichtErzeugtException e) {
					addException(e, aufgetreteneExceptions);
					System.out.println(akteur1.getName() + " ist unbekannt und wurde noch nicht erzeugt.");
				} catch (AkteurBereitsGefressenException e) {
					addException(e, aufgetreteneExceptions);
					System.out.println(akteur1.getName() + " ist bereits tot und kann nicht mehr handeln.");
				} catch (KannNichtFressenException e) {
					addException(e, aufgetreteneExceptions);
					System.out.println(akteur1.getName() + " ist ein kein Fisch und kann daher nichts fressen.");
				}
				break;

			default:
				break;
			}

			akteur1 = null;
			akteur2 = null;
		}
		System.out.println("\n============================================================");
		if (aufgetreteneExceptions.size() < 1) {
			System.out.println("Bei der Szene sind keine Exceptions aufgetreten.");
		} else {
			System.out.println("Folgende Exceptions sind während der Szene aufgetreten:");
			int anzahlExceptions = 0;
			for (HashMap.Entry<String, Integer> entry : aufgetreteneExceptions.entrySet()) {
				String dieException = entry.getKey();
				int dieAnzahl = entry.getValue();
				System.out.println(dieException.replace("Exceptions.", "") + ": " + dieAnzahl + " mal aufgetreten.");
				anzahlExceptions += dieAnzahl;
			}
			System.out.println("Insgesamt sind " + anzahlExceptions + " Exceptions aufgetreten und davon sind "
					+ aufgetreteneExceptions.size() + " Exceptions verschieden.");
		}
	}

	/**
	 * Überprüft ob Leckerbissen der in der Szene gesuchte ist
	 * 
	 * @param lecker der zu überprüfende Leckerbissen
	 * @param string Zeichenkette auf der der Leckerbissen geprüft wird
	 */
	public static boolean compareType(Leckerbissen lecker, String string) {
		if (lecker.getName().equalsIgnoreCase(string))
			return true;
		return false;

	}

	/**
	 * Fügt Exception hinzu und zählt das vorkommen hoch falls es schon vorhanden
	 * ist
	 * 
	 * @param e   Exception die zur Liste hinzugefügt wird
	 * @param map Hash Map zu welcher die Exception hinzugefügt wird
	 */
	public static void addException(Exception e, HashMap<String, Integer> map) {
		String name = e.getClass().getName();
		if (map.get(name) == null) {
			map.put(name, 1);
		} else {
			int anz = map.get(e.getClass().getName());
			map.replace(name, anz + 1);
		}
	}

}
