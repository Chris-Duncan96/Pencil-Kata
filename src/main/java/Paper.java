package main.java;

public class Paper {
	public String content;
	public Paper () {
		content = "";
	}
	
	void setCharAtLocation(char inputChar, int location) {
		char[] characters = this.content.toCharArray();
		characters[location] = inputChar;
		this.content = new String(characters);
	}
	
	boolean locationIsWhitespace(int location) {
		char[] characters = content.toCharArray();
		return Character.isWhitespace(characters[location]);
	}
}
