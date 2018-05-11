package main.java;

public class Pencil {

	Paper paper;
	public Pencil (Paper argPaper) {
		this.paper = argPaper;
	}
	
	public void write(String toWrite) {
		paper.content += toWrite;
	}
}
