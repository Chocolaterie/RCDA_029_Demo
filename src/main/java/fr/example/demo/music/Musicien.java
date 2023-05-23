package fr.example.demo.music;

public class Musicien<T extends Instrument> {

	/**
	 * Le prenom
	 */
	String firstname;
	
	/**
	 * L'instrument
	 */
	T instrument;
	
	Musicien(String _firstname, T _instrument){
		this.firstname = _firstname;
		this.instrument = _instrument;
	}
	
	public void playInstrument() {
		this.instrument.play();
	}
	
	public T getInstrument() {
		return instrument;
	}
	
}
