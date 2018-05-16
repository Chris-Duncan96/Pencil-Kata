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
	
	private void appendCharToPaper(char thisCharacter){
		if(this.tipDurability <= 0) {
			paper.content += ' ';
		} else {
			tipDurability -= 1;
			paper.content += thisCharacter;
		}	
	}
}
