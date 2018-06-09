package main.java;

public class Pencil {

	public Eraser eraser;
	public Writer writer;
	
	public Pencil (Paper argPaper, int argTipDurability, int argLength, int argEraserDurability) {
		this.writer = new Writer(argPaper, argLength, argTipDurability);
		this.eraser = new Eraser(argPaper, argEraserDurability);
	}
}
