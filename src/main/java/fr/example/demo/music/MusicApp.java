package fr.example.demo.music;

public class MusicApp {

	public static void main(String[] args) {
		// instancier un orchestre
		Orchestre orchestre = new Orchestre();
		
		// ajout 1 (Violon, Antoine)
		Instrument instru1 = new Instrument("Violon");
		Musicien musicien1 = new Musicien("Antoine", instru1);
		
		orchestre.musiciens.add(musicien1);
		
		// ajout 2 (Piano, Gael)
		Musicien musicien2 = new Musicien("Gael", new Instrument("Piano"));
				
		orchestre.musiciens.add(musicien2);
		
		// ajout 3 (Guitare, Cedric)
		orchestre.musiciens.add(new Musicien("Cedric", new Instrument("Guitare")));
	
		// ajout 4
		orchestre.musiciens.add(new Musicien("Axelle", new Guitare()));
		
		// ajout 5
		Musicien<Guitare> lea = new Musicien<Guitare>("Léa", new Guitare());
		orchestre.musiciens.add(lea);
		
		
		// Cast dangereux
		Guitare guitare = lea.getInstrument();
		System.out.println("Les cordes : " + guitare.cordes);
		
		// ajout 5
		Musicien<Violon> toto = new Musicien<Violon>("Toto", new Violon());
		orchestre.musiciens.add(toto);
		
		toto.getInstrument().caGrince();
		
		// jouer l'ochestre
		orchestre.play();
	}

}
