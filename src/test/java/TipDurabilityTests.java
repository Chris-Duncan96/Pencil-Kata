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
		pencil.tip.tipDurability = 0;
		pencil.tip.write("Ab ");
		assertEquals(0, pencil.tip.tipDurability);
	}
	
	@Test
	public void writing1UppcaseAnd1LowerCaseAnd1BlankSpaceCharReducesTipDurabilityBy3Test() {
		pencil.tip.write("Ab ");
		assertEquals(BASE_TIP_DURABILITY - 3, pencil.tip.tipDurability);
	}
	
	@Test
	public void writingUppercaseCharReducesTipDurabilityBy2Test() {
		pencil.tip.write("A");
		assertEquals(BASE_TIP_DURABILITY - 2, pencil.tip.tipDurability);
	}
	
	@Test
	public void writingLowercaseCharReducesTipDurabilityBy1Test() {
		pencil.tip.write("a");
		assertEquals(BASE_TIP_DURABILITY - 1, pencil.tip.tipDurability);
	}
	
	@Test
	public void writingWhiteSpaceCharReducesTipDurabilityBy0Test() {
		pencil.tip.write(" ");
		assertEquals(BASE_TIP_DURABILITY, pencil.tip.tipDurability);
	}
	
	@Test
	public void aPencilWith1DurabilityCanWriteSingleCharThenReducesDurabilityTest() {
		pencil.tip.tipDurability = 1;
		pencil.tip.write("a");
		assertTrue(1 > pencil.tip.tipDurability);
	}
	
	@Test
	public void whenPencilHasNoTipDurabilityItWritesBlankSpaceInsteadOfTextTest() {
		pencil.tip.tipDurability = 0;
		pencil.tip.write("a");
		assertEquals(" ", paper.content);
	}
	
	@Test
	public void whenPencilHasNegative1TipDurabilityItWritesBlankSpaceInsteadOfTextTest() {
		pencil.tip.tipDurability = -1;
		pencil.tip.write("a");
		assertEquals(" ", paper.content);
	}
	
	@Test
	public void whenGivenStringTwoCharactersLongAnd0PointDurabilityPencilWritesTwoBlankSpacesTest() {
		pencil.tip.tipDurability = 0;
		pencil.tip.write("ab");
		assertEquals("  ", paper.content);
	}

}
