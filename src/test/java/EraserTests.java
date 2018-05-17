package test.java;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;


import main.java.Paper;
import main.java.Pencil;

public class EraserTests {
	
	Paper paper;
	Pencil pencil;
	
	static int BASE = 100;
	
	@Before
	public void InitializePaperAndPencil() {
		paper = new Paper();
		pencil = new Pencil(paper, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
	
	@Test
	public void eraserDepleatesThrouhoutEraseCallAndStopsIfInsufficientDurabilityTest() {
		pencil.eraserDurability = 2;
		paper.content = "abc";
		pencil.erase("abc");
		assertEquals("a  ", paper.content);
	}
	
	@Test
	public void eraserWith0DurabilityCannotEraseTest() {
		pencil.eraserDurability = 0;
		paper.content = "a";
		pencil.erase("a");
		assertEquals("a", paper.content);
	}
	
	@Test
	public void erasingStringOnPageLeavesEquallyLongWhiteSpaceOnPaperTest() {
		paper.content = "aabc";
		pencil.erase("abc");
		assertEquals("a   ", paper.content);
	}
	
	@Test
	public void erasingCharacterReducesEraserDurabilityBy1Test() {
		pencil.eraserDurability = BASE;
		paper.content = "a";
		pencil.erase("a");
		assertEquals(BASE - 1, pencil.eraserDurability);
	}
	
	@Test
	public void erasingWhiteSpaceDoesNotReduceEraserDurabilityTest() {
		pencil.eraserDurability = BASE;
		paper.content = " ";
		pencil.erase(" ");
		assertEquals(BASE, pencil.eraserDurability);
	}
	
	@Test
	public void erasingEntireStringOnPageLeavesEquallyLongWhiteSpaceOnPaperTest() {
		paper.content = "abc";
		pencil.erase("abc");
		assertEquals("   ", paper.content);
	}
	
	@Test
	public void erasingStringOnPaperReplacesOnlyLastInstanceOfStringWithEquallyLongWhitespaceTest() {
		paper.content = "abc abc";
		pencil.erase("abc");
		assertEquals("abc    ", paper.content);
	}
	
	@Test
	public void erasingCharacterFromPaperReplacesOnlyLastInstanceOfThatCharacterWithWhitespaceTest() {
		paper.content = "aa";
		pencil.erase("a");
		assertEquals("a ", paper.content);
	}
	
	@Test
	public void erasingLoneCharacterOnPageLeavesSingleWhiteSpaceOnPaperTest() {
		paper.content = "a";
		pencil.erase("a");
		assertEquals(" ", paper.content);
	}
}
