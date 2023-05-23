package fr.example.demo.music;

import java.util.ArrayList;
import java.util.List;

public class Orchestre {

	List<Musicien> musiciens;
	
	public Orchestre() {
		musiciens = new ArrayList<Musicien>();
	}
	
	public void play() {
		// Faire jouer l'instrument de tout les musiciens
		for (Musicien musicien : musiciens) {
			musicien.playInstrument();
		}
	}
}
