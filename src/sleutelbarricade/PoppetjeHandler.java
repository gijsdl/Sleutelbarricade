/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
