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
	
	static int BASE_TIP_DURABILITY = 100;
	
	@Before
	public void InitializePaperAndPencil() {
		paper = new Paper();
		pencil = new Pencil(paper, BASE_TIP_DURABILITY, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
	
	@Test
	public void with0DurabilityAttemptingToWriteDoesNotReduceDurabilityFurtherTest() {
		pencil.tipDurability = 0;
		pencil.write("Ab ");
		assertEquals(0, pencil.tipDurability);
	}
	
	@Test
	public void writing1UppcaseAnd1LowerCaseAnd1BlankSpaceCharReducesTipDurabilityBy3Test() {
		pencil.write("Ab ");
		assertEquals(BASE_TIP_DURABILITY - 3, pencil.tipDurability);
	}
	
	@Test
	public void writingUppercaseCharReducesTipDurabilityBy2Test() {
		pencil.write("A");
		assertEquals(BASE_TIP_DURABILITY - 2, pencil.tipDurability);
	}
	
	@Test
	public void writingLowercaseCharReducesTipDurabilityBy1Test() {
		pencil.write("a");
		assertEquals(BASE_TIP_DURABILITY - 1, pencil.tipDurability);
	}
	
	@Test
	public void writingWhiteSpaceCharReducesTipDurabilityBy0Test() {
		pencil.write(" ");
		assertEquals(BASE_TIP_DURABILITY, pencil.tipDurability);
	}
	
	@Test
	public void aPencilWith1DurabilityCanWriteSingleCharThenReducesDurabilityTest() {
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
