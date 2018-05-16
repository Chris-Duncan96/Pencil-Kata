package main.java;

public class Pencil {

	Paper paper;
	public int tipDurability;
	public Pencil (Paper argPaper, int argTipDurability) {
		this.paper = argPaper;
		this.tipDurability = argTipDurability;
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
}
