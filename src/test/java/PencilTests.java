package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Paper;
import main.java.Pencil;

class PencilTests {
	
	Paper paper;
	Pencil pencil;
	
	@BeforeEach
	void InitializePaperAndPencil() {
		paper = new Paper();
		pencil = new Pencil(paper, Integer.MAX_VALUE);
	}
	
	@Test
	void writingUppercaseCharReducesTipDurabilityBy2() {
		pencil.tipDurability = 3;
		pencil.write("A");
		assertEquals(1, pencil.tipDurability);
	}
	
	@Test
	void writingLowercaseCharReducesTipDurabilityBy1() {
		pencil.tipDurability = 3;
		pencil.write("a");
		assertEquals(2, pencil.tipDurability);
	}
	
	@Test
	void writingWhiteSpaceCharReducesTipDurabilityBy0() {
		pencil.tipDurability = 3;
		pencil.write(" ");
		assertEquals(3, pencil.tipDurability);
	}
	
	@Test
	void aPencilWith1DurabilityCanWriteSingleCharThenHasLessThan1DurabilityTest() {
		pencil.tipDurability = 1;
		pencil.write("a");
		assertTrue(1 > pencil.tipDurability);
	}
	
	@Test
	void whenGivenStringPencilWritesItToPaperTest() {
		pencil.write("a");
		assertEquals("a", paper.content);
	}
	
	@Test
	void whenGivenStringPencilAppendsItToPaperTest() {
		paper.content = "b";
		pencil.write("a");
		assertEquals("ba", paper.content);
	}
	
	@Test
	void whenPencilHasNoTipDurabilityItWritesBlankSpaceInsteadOfTextTest() {
		pencil.tipDurability = 0;
		pencil.write("a");
		assertEquals(" ", paper.content);
	}
	
	@Test
	void whenGivenStringTwoCharactersLongAnd0PointDurabilityPencilWritesTwoBlankSpacesTest() {
		pencil.tipDurability = 0;
		pencil.write("ab");
		assertEquals("  ", paper.content);
	}
}
