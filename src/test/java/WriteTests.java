package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.Paper;
import main.java.Pencil;

public class WriteTests {
	
	Paper paper;
	Pencil pencil;
	
	@Before
	public void InitializePaperAndPencil() {
		paper = new Paper();
		pencil = new Pencil(paper, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
	
	@Test
	public void whenGivenStringPencilWritesItToBlankPaperTest() {
		pencil.tip.write("a");
		assertEquals("a", paper.content);
	}
	
	@Test
	public void whenGivenStringPencilAppendsItToPaperTest() {
		paper.content = "b";
		pencil.tip.write("a");
		assertEquals("ba", paper.content);
	}
}
