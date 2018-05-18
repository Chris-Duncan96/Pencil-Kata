package test.java;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;


import main.java.Paper;
import main.java.Pencil;

public class EraserTests {
	
	Paper paper;
	Pencil pencil;
	
	static int BASE_ERASER_DURABILITY = 100;
	
	@Before
	public void InitializePaperAndPencil() {
		paper = new Paper();
		pencil = new Pencil(paper, Integer.MAX_VALUE, Integer.MAX_VALUE, BASE_ERASER_DURABILITY);
	}
	
	@Test
	public void with2DurabilityPencilCanEraseOnly2CharactersTest() {
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
	public void erasing3CharactersLeaves3WhiteSpacesTest() {
		paper.content = "aabc";
		pencil.erase("abc");
		assertEquals("a   ", paper.content);
	}
	
	@Test
	public void erasingCharacterReducesEraserDurabilityBy1Test() {
		paper.content = "a";
		pencil.erase("a");
		assertEquals(BASE_ERASER_DURABILITY - 1, pencil.eraserDurability);
	}
	
	@Test
	public void erasingWhiteSpaceReducesEraserDurabilityBy1Test() {
		paper.content = " ";
		pencil.erase(" ");
		assertEquals(BASE_ERASER_DURABILITY - 1, pencil.eraserDurability);
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
	
	@Test
	public void erasingFirstCharacterDoesNotShiftOtherCharactersTest() {
		paper.content = "abc";
		pencil.erase("a");
		assertEquals(" bc", paper.content);
	}
	
	@Test
	public void erasingMiddleCharacterDoesNotShiftOtherCharactersTest() {
		paper.content = "abc";
		pencil.erase("b");
		assertEquals("a c", paper.content);
	}
	
	@Test
	public void erasingLastCharacterDoesNotShiftOtherCharactersTest() {
		paper.content = "abc";
		pencil.erase("c");
		assertEquals("ab ", paper.content);
	}
}
