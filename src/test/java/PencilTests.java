package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;


import main.java.Paper;
import main.java.Pencil;

public class PencilTests {
	
	Paper paper;
	Pencil pencil;
	
	static int BASE = 100;
	
	@Before
	public void InitializePaperAndPencil() {
		paper = new Paper();
		pencil = new Pencil(paper, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
	
	@Test
	public void insertingThreeCharactersOverSomeDifferentCharacterResultsInPartialCollisionTest() {
		paper.content = "abc";
		pencil.insert("xbx", 0);
		assertEquals("@b@", paper.content);
	}
	
	@Test
	public void insertingThreeCharactersOverDifferentCharacterResultsInCollisionTest() {
		paper.content = "abc";
		pencil.insert("bcd", 0);
		assertEquals("@@@", paper.content);
	}
	
	@Test
	public void insertingCharacterOverDifferentCharacterResultsInCollisionTest() {
		paper.content = "a";
		pencil.insert("b", 0);
		assertEquals("@", paper.content);
	}
	
	@Test
	public void insertingCharacterOverSameCharacterDoesNotResultaInCollisionTest() {
		paper.content = "a";
		pencil.insert("a", 0);
		assertEquals("a", paper.content);
	}
	
	@Test
	public void insertingCharacterDoesNotShiftTextTest() {
		paper.content = " b";
		pencil.insert("a", 0);
		assertEquals("ab", paper.content);
	}
	
	@Test
	public void insertingCharacterOverWhitespaceResultsInOverwrittenWhitespaceTest() {
		paper.content = "a c";
		pencil.insert("b", 1);
		assertEquals("abc", paper.content);
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
	
	@Test
	public void sharpeningPencilRestoresTipDurabilityToOriginalValue() {
		pencil.tipDurability = 0;
		pencil.sharpen();
		assertEquals(Integer.MAX_VALUE, pencil.tipDurability);
	}
	
	@Test
	public void sharpeningPencilWithLength2ReducesPencilLengthTo1() {
		pencil.length = 2;
		pencil.sharpen();
		assertEquals(1, pencil.length);
	}	
	
	@Test
	public void sharpeningPencilWithLength1ReducesPencilLengthTo0() {
		pencil.length = 1;
		pencil.sharpen();
		assertEquals(0, pencil.length);
	}
	
	@Test
	public void sharpeningPencilWith0LengthDoesNotChangeDurability() {
		pencil.tipDurability = BASE;
		pencil.length = 0;
		pencil.sharpen();
		assertEquals(BASE, pencil.tipDurability);
	}
	
	@Test
	public void with0DurabilityAttemptingToWriteDoesNotReduceDurabilityFurtherTest() {
		pencil.tipDurability = 0;
		pencil.write("Ab ");
		assertEquals(0, pencil.tipDurability);
	}
	
	@Test
	public void writing1UppcaseAnd1LowerCaseAnd1BlankSpaceCharReducesTipDurabilityBy3Test() {
		pencil.tipDurability = BASE;
		pencil.write("Ab ");
		assertEquals(BASE - 3, pencil.tipDurability);
	}
	
	@Test
	public void writingUppercaseCharReducesTipDurabilityBy2Test() {
		pencil.tipDurability = BASE;
		pencil.write("A");
		assertEquals(BASE - 2, pencil.tipDurability);
	}
	
	@Test
	public void writingLowercaseCharReducesTipDurabilityBy1Test() {
		pencil.tipDurability = BASE;
		pencil.write("a");
		assertEquals(BASE - 1, pencil.tipDurability);
	}
	
	@Test
	public void writingWhiteSpaceCharReducesTipDurabilityBy0Test() {
		pencil.tipDurability = BASE;
		pencil.write(" ");
		assertEquals(BASE, pencil.tipDurability);
	}
	
	@Test
	public void aPencilWith1DurabilityCanWriteSingleCharThenHasLessThan1DurabilityTest() {
		pencil.tipDurability = 1;
		pencil.write("a");
		assertTrue(1 > pencil.tipDurability);
	}
	
	@Test
	public void whenGivenStringPencilWritesItToPaperTest() {
		pencil.write("a");
		assertEquals("a", paper.content);
	}
	
	@Test
	public void whenGivenStringPencilAppendsItToPaperTest() {
		paper.content = "b";
		pencil.write("a");
		assertEquals("ba", paper.content);
	}
	
	@Test
	public void whenPencilHasNoTipDurabilityItWritesBlankSpaceInsteadOfTextTest() {
		pencil.tipDurability = 0;
		pencil.write("a");
		assertEquals(" ", paper.content);
	}
	
	@Test
	public void whenPencilHasNegative1TipDurabilityItWritesBlankSpaceInsteadOfTextTest() {
		pencil.tipDurability = -1;
		pencil.write("a");
		assertEquals(" ", paper.content);
	}
	
	@Test
	public void whenGivenStringTwoCharactersLongAnd0PointDurabilityPencilWritesTwoBlankSpacesTest() {
		pencil.tipDurability = 0;
		pencil.write("ab");
		assertEquals("  ", paper.content);
	}
}
