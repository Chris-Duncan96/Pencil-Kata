package main.java;

public class Eraser {

	public int durability;
	private Paper paper;
	
	public Eraser(Paper argPaper, int argEraserDurability){
		this.durability = argEraserDurability;
		this.paper = argPaper;
	}
	
	public void erase(String substring) {
		int locationOfSubstring = paper.content.lastIndexOf(substring);
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
		paper.setCharAtLocation(' ', location);
	}
	
}
