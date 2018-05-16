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
			for(int offset = substring.length(); offset > 0 ; offset--) {
				eraseCharacterAtLocation(locationOfSubstring + offset);
			}
		}
	}
	
	private void eraseCharacterAtLocation(int location) {
		char[] characters = paper.content.toCharArray();
		characters[location - 1] = ' ';
		paper.content = new String(characters);
	}
}
