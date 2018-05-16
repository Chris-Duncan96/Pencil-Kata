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
		char[] characters = paper.content.toCharArray();
		reduceEraserDurabilityBy(characters[location]);
		characters[location] = ' ';
		paper.content = new String(characters);
	}
	
	private void reduceEraserDurabilityBy(char erasedChar) {
		if(!Character.isWhitespace(erasedChar)) {
			this.eraserDurability--;
		}
	}
	
	public void insert(String string, int startLocation) {
		for(int counter = 0; counter < string.length(); counter++){
			writeCharAtLocation(string.charAt(counter), startLocation + counter);
		}
	}

	private void writeCharAtLocation(char inputChar, int location) {
		if(this.tipDurability <= 0) {
			return;
		}
		reducePencilDurabilityBy(inputChar);
		Character replacementChar;
		if(Character.isWhitespace(paper.content.charAt(location)) || paper.content.charAt(location) == inputChar) {
			replacementChar = inputChar;
		}
		else {
			replacementChar = '@';
		}
		char[] characters = paper.content.toCharArray();
		characters[location] = replacementChar;
		paper.content = new String(characters);
	}
}
