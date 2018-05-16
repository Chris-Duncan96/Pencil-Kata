package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.Paper;
import main.java.Pencil;

class PencilTests {
	
	Paper paper;
	Pencil pencil;
	
	static int BASE = 100;
	
	@BeforeEach
	void InitializePaperAndPencil() {
		paper = new Paper();
		pencil = new Pencil(paper, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

	@Test
	void eraserDepleatesThrouhoutEraseCallAndStopsIfInsufficientDurabilityTest() {
		pencil.eraserDurability = 2;
		paper.content = "abc";
		pencil.erase("abc");
		assertEquals("a  ", paper.content);
	}
	
	@Test
	void eraserWith0DurabilityCannotEraseTest() {
		pencil.eraserDurability = 0;
		paper.content = "a";
		pencil.erase("a");
		assertEquals("a", paper.content);
	}
	
	@Test
	void erasingStringOnPageLeavesEquallyLongWhiteSpaceOnPaperTest() {
		paper.content = "aabc";
		pencil.erase("abc");
		assertEquals("a   ", paper.content);
	}
	
	@Test
	void erasingCharacterReducesEraserDurabilityBy1Test() {
		pencil.eraserDurability = BASE;
		paper.content = "a";
		pencil.erase("a");
		assertEquals(BASE - 1, pencil.eraserDurability);
	}
	
	@Test
	void erasingWhiteSpaceDoesNotReduceEraserDurabilityTest() {
		pencil.eraserDurability = BASE;
		paper.content = " ";
		pencil.erase(" ");
		assertEquals(BASE, pencil.eraserDurability);
	}
	
	@Test
	void erasingEntireStringOnPageLeavesEquallyLongWhiteSpaceOnPaperTest() {
		paper.content = "abc";
		pencil.erase("abc");
		assertEquals("   ", paper.content);
	}
	
	@Test
	void erasingStringOnPaperReplacesOnlyLastInstanceOfStringWithEquallyLongWhitespaceTest() {
		paper.content = "abc abc";
		pencil.erase("abc");
		assertEquals("abc    ", paper.content);
	}
	
	@Test
	void erasingCharacterFromPaperReplacesOnlyLastInstanceOfThatCharacterWithWhitespaceTest() {
		paper.content = "aa";
		pencil.erase("a");
		assertEquals("a ", paper.content);
	}
	
	@Test
	void erasingLoneCharacterOnPageLeavesSingleWhiteSpaceOnPaperTest() {
		paper.content = "a";
		pencil.erase("a");
		assertEquals(" ", paper.content);
	}
	
	@Test
	void sharpeningPencilRestoresTipDurabilityToOriginalValue() {
		pencil.tipDurability = 0;
		pencil.sharpen();
		assertEquals(Integer.MAX_VALUE, pencil.tipDurability);
	}
	
	@Test
	void sharpeningPencilWithLength2ReducesPencilLengthTo1() {
		pencil.length = 2;
		pencil.sharpen();
		assertEquals(1, pencil.length);
	}	
	
	@Test
	void sharpeningPencilWithLength1ReducesPencilLengthTo0() {
		pencil.length = 1;
		pencil.sharpen();
		assertEquals(0, pencil.length);
	}
	
	@Test
	void sharpeningPencilWith0LengthDoesNotChangeDurability() {
		pencil.tipDurability = BASE;
		pencil.length = 0;
		pencil.sharpen();
		assertEquals(BASE, pencil.tipDurability);
	}
	
	@Test
	void with0DurabilityAttemptingToWriteDoesNotReduceDurabilityFurtherTest() {
		pencil.tipDurability = 0;
		pencil.write("Ab ");
		assertEquals(0, pencil.tipDurability);
	}
	
	@Test
	void writing1UppcaseAnd1LowerCaseAnd1BlankSpaceCharReducesTipDurabilityBy3Test() {
		pencil.tipDurability = BASE;
		pencil.write("Ab ");
		assertEquals(BASE - 3, pencil.tipDurability);
	}
	
	@Test
	void writingUppercaseCharReducesTipDurabilityBy2Test() {
		pencil.tipDurability = BASE;
		pencil.write("A");
		assertEquals(BASE - 2, pencil.tipDurability);
	}
	
	@Test
	void writingLowercaseCharReducesTipDurabilityBy1Test() {
		pencil.tipDurability = BASE;
		pencil.write("a");
		assertEquals(BASE - 1, pencil.tipDurability);
	}
	
	@Test
	void writingWhiteSpaceCharReducesTipDurabilityBy0Test() {
		pencil.tipDurability = BASE;
		pencil.write(" ");
		assertEquals(BASE, pencil.tipDurability);
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
	void whenPencilHasNegative1TipDurabilityItWritesBlankSpaceInsteadOfTextTest() {
		pencil.tipDurability = -1;
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
