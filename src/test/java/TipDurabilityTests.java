package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.java.Paper;
import main.java.Pencil;

public class TipDurabilityTests {
	
	Paper paper;
	Pencil pencil;
	
	static int BASE = 100;
	
	@Before
	public void InitializePaperAndPencil() {
		paper = new Paper();
		pencil = new Pencil(paper, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
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
