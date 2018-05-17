package main.java;

public class Pencil {

	public Paper paper;
	public int tipDurability;
	public int defaultTipDurability;
	public int length;
	public int eraserDurability;
	
	public Pencil (Paper argPaper, int argTipDurability, int argLength, int argEraserDurability) {
		this.paper = argPaper;
		this.tipDurability = argTipDurability;
		this.defaultTipDurability = argTipDurability;
		this.length = argLength;
		this.eraserDurability = argEraserDurability;
	}
	
	public void write(String thoughtsToWrite){
		for (char nextCharacter: thoughtsToWrite.toCharArray()) {
			appendCharToPaper(nextCharacter);
		}
	}
	
	private void appendCharToPaper(char characterToAppend){
		if(this.tipDurability <= 0) {
			paper.content += ' ';
		} else {
			reducePencilDurabilityBy(characterToAppend);
			paper.content += characterToAppend;
		}	
	}
	
	private void reducePencilDurabilityBy(char letterThatWasWritten) {
		if(Character.isUpperCase(letterThatWasWritten)) {
			this.tipDurability -= 2;
		}
		else if(Character.isLowerCase(letterThatWasWritten)) {
			this.tipDurability -= 1;
		}
	}
	
	public void sharpen() {
		if(length > 0) {
			this.tipDurability = this.defaultTipDurability;
			this.length--;
		}
	}
	
	public void erase(String substring) {
		int locationOfSubstring = paper.content.lastIndexOf(substring);
		if(locationOfSubstring > -1) {
			eraseCharactersFromPaper(substring.length(), locationOfSubstring);
		}
	}
	
	private void eraseCharactersFromPaper(int substringLength, int locationOfSubstring) {
		for(int offset = substringLength - 1; offset >= 0 ; offset--) {
			if(this.eraserDurability > 0) {
				eraseCharacterAtLocation(locationOfSubstring + offset);
			}
		}
	}
	
	private void eraseCharacterAtLocation(int location) {
		this.eraserDurability--;
		setCharAtLocation(' ', location);
	}
	
	public void insert(String string, int startLocation) {
		for(int counter = 0; counter < string.length(); counter++){
			insertCharacterAtLocation(string.charAt(counter), startLocation + counter);
		}
	}
	
	private void insertCharacterAtLocation(char character, int location) {
		reducePencilDurabilityBy(character);
		if(locationIsWhitespace(location)) {
			setCharAtLocation(character, location);
		}
		else {
			setCharAtLocation('@', location);
		}
	}
	
	private boolean locationIsWhitespace(int location) {
		char[] characters = paper.content.toCharArray();
		return Character.isWhitespace(characters[location]);
	}

	private void setCharAtLocation(char inputChar, int location) {
		char[] characters = paper.content.toCharArray();
		characters[location] = inputChar;
		paper.content = new String(characters);
	}
}
