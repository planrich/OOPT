
public class Factory {

	public static Factory create(String name) { //name must be unique
		Factory factory = new Factory(name);
		return factory;
	}
	
	private final String name;
	
	public String getName() {
		return name;
	}
	
	Factory(String name) { //name must be unique
		this.name = name;
	}
	
	/**
	 * Die durchschnittliche Anzahl der Betriebstunden aller Roboter einer
	 * Fabrik – alle Roboter zusammen und zusätzlich aufgeschlüsselt nach den
	 * Einsatzarten (Schweißroboter oder Lackierroboter).
	 * 
	 * Die durchschnittliche Anzahl der Betriebstunden aller Roboter einer
	 * Fabrik – alle Roboter zusammen und zusätzlich aufgeschlüsselt nach den
	 * Einsatzarten (Schweißroboter oder Lackierroboter).
	 * 
	 * Die durchschnittliche Anzahl der Betriebstunden aller Roboter einer
	 * Fabrik aufgeschlüsselt nach den Robotertyp (Schwenkarmroboter oder
	 * Raupenroboter).
	 * 
	 * Die durchschnittliche Anzahl der Rotationen aller Schwenkarmroboter einer
	 * Fabrik – alle zusammen und zusätzlich aufgeschlüsselt nach den
	 * Einsatzarten (Schweißroboter oder Lackierroboter).
	 * 
	 * Die durchschnittliche zurückgelegte Wegstrecke aller Raupenroboter einer
	 * Fabrik – alle zusammen und zusätzlich aufgeschlüsselt nach den
	 * Einsatzarten.
	 * 
	 * Die minimale und maximale Arbeitstemperatur aller Schweißroboter
	 * insgesamt und aufgeschlüsselt nach Robotertyp (Schwenkarmroboter oder
	 * Raupenroboter).
	 * 
	 * Die durchschnittlich zurückgelegte Wegstrecke aller Raupenroboter
	 * insgesamt und aufgeschlüsselt nach Robotertyp.
	 */
}
