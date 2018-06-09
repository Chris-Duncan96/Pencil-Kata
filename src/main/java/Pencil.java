package main.java;

public class Pencil {

	public Paper paper;
	public int tipDurability;
	public int defaultTipDurability;
	public int length;
	public Eraser eraser;
	
	public Pencil (Paper argPaper, int argTipDurability, int argLength, int argEraserDurability) {
		this.paper = argPaper;
		this.tipDurability = argTipDurability;
		this.defaultTipDurability = argTipDurability;
		this.length = argLength;
		this.eraser = new Eraser(this, argEraserDurability);
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
	
	public void insert(String string, int startLocation) {
		for(int counter = 0; counter < string.length(); counter++){
			writeCharacterAtLocation(string.charAt(counter), startLocation + counter);
		}
	}
	
	private void writeCharacterAtLocation(char character, int location) {
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

	void setCharAtLocation(char inputChar, int location) {
		char[] characters = paper.content.toCharArray();
		characters[location] = inputChar;
		paper.content = new String(characters);
	}
}
