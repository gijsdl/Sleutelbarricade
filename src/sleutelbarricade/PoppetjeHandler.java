/*
 * 
 * @author Crhis Bruijn, Ruben Buijck, Gijs de Lange
 */
package sleutelbarricade;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
// deze class is er voor om te zorgen dat niet iedere keer als poppetje een nieuwe sleutel krijgt een nieuw object word aangemaakt.
public class PoppetjeHandler {

	private static Set<Poppetje> poppetjes = new HashSet<>(); //Er wordt hier een HashSet gebruikt inplaats van een HashMap omdat er geen volgorde nodig is

	public static Set<Poppetje> getPoppetjes() {
		return poppetjes;
	}

	public static Poppetje getPoppetje(UUID uuid) {
		for (Poppetje poppetje : poppetjes) {
			if (poppetje.getUuid() == uuid)
				return poppetje;
		}
		return null;
	}
}
