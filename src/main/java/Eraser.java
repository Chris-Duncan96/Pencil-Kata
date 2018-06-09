package main.java;

public class Eraser {

	public int durability;
	private Pencil pencil;
	
	public Eraser(Pencil argPencil, int argEraserDurability){
		this.durability = argEraserDurability;
		this.pencil = argPencil;
	}
	
	public void erase(String substring) {
		int locationOfSubstring = pencil.paper.content.lastIndexOf(substring);
		if(locationOfSubstring > -1) {
			eraseCharactersFromPaper(substring.length(), locationOfSubstring);
		}
	}
	
	private void eraseCharactersFromPaper(int substringLength, int locationOfSubstring) {
		for(int offset = substringLength - 1; offset >= 0 ; offset--) {
			if(durability > 0) {
				eraseCharacterAtLocation(locationOfSubstring + offset);
			}
		}
	}
	
	private void eraseCharacterAtLocation(int location) {
		durability--;
		pencil.setCharAtLocation(' ', location);
	}
	
}
