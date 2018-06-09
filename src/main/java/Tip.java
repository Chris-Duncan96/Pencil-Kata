package main.java;

public class Tip {

	public Pencil pencil;
	public int tipDurability;
	public int defaultTipDurability;
	public int length;
	
	public Tip(Pencil argPencil, int argLength, int argTipDurability) {
		this.pencil = argPencil;
		this.tipDurability = argTipDurability;
		this.defaultTipDurability = argTipDurability;
		this.length = argLength;
	}
	
	public void write(String thoughtsToWrite){
		for (char nextCharacter: thoughtsToWrite.toCharArray()) {
			appendCharToPaper(nextCharacter);
		}
	}
	
	private void appendCharToPaper(char characterToAppend){
		if(this.tipDurability <= 0) {
			pencil.paper.content += ' ';
		} else {
			reducePencilDurabilityBy(characterToAppend);
			pencil.paper.content += characterToAppend;
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
			pencil.setCharAtLocation(character, location);
		}
		else {
			pencil.setCharAtLocation('@', location);
		}
	}
	
	private boolean locationIsWhitespace(int location) {
		char[] characters = pencil.paper.content.toCharArray();
		return Character.isWhitespace(characters[location]);
	}

}
