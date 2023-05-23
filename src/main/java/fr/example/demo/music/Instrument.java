package fr.example.demo.music;

public class Instrument {

	String name;
	
	Instrument(String _name){
		this.name = _name;
	}
	
	public void play() {
		System.out.println(String.format("Play instrument : %s", this.name));
	}
}
