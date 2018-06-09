package main.java;

public class Pencil {

	public Paper paper;
	public Eraser eraser;
	public Tip tip;
	
	public Pencil (Paper argPaper, int argTipDurability, int argLength, int argEraserDurability) {
		this.paper = argPaper;
		this.tip = new Tip(this, argLength, argTipDurability);
		this.eraser = new Eraser(this, argEraserDurability);
	}

	void setCharAtLocation(char inputChar, int location) {
		char[] characters = paper.content.toCharArray();
		characters[location] = inputChar;
		paper.content = new String(characters);
	}
}
