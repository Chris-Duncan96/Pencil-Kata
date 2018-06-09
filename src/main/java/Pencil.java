package main.java;

public class Pencil {

	public Paper paper;
	public Eraser eraser;
	public Writer writer;
	
	public Pencil (Paper argPaper, int argTipDurability, int argLength, int argEraserDurability) {
		this.paper = argPaper;
		this.writer = new Writer(argPaper, argLength, argTipDurability);
		this.eraser = new Eraser(argPaper, argEraserDurability);
	}
}
