package main.java;

public class Pencil {

	Paper paper;
	public int tipDurability;
	public Pencil (Paper argPaper, int argTipDurability) {
		this.paper = argPaper;
		this.tipDurability = argTipDurability;
	}
	
	public void write(String toWrite) {
		if(tipDurability > 0) {
			paper.content += toWrite;
		}
		else {
			paper.content += " ";
		}
	}
}
