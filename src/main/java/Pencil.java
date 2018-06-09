package main.java;

public class Pencil {

	public Paper paper;
	public Eraser eraser;
	public Tip tip;
	
	public Pencil (Paper argPaper, int argTipDurability, int argLength, int argEraserDurability) {
		this.paper = argPaper;
		this.tip = new Tip(argPaper, argLength, argTipDurability);
		this.eraser = new Eraser(argPaper, argEraserDurability);
	}
}
