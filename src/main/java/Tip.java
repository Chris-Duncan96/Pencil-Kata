package main.java;

public class Tip {

	public Paper paper;
	public int tipDurability;
	public int defaultTipDurability;
	public int length;
	
	public Tip(Paper argPaper, int argLength, int argTipDurability) {
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
	
	public void insert(String string, int startLocation) {
		for(int counter = 0; counter < string.length(); counter++){
			writeCharacterAtLocation(string.charAt(counter), startLocation + counter);
		}
	}
	
	private void writeCharacterAtLocation(char character, int location) {
		reducePencilDurabilityBy(character);
		if(paper.locationIsWhitespace(location)) {
			paper.setCharAtLocation(character, location);
		}
		else {
			paper.setCharAtLocation('@', location);
		}
	}

}
