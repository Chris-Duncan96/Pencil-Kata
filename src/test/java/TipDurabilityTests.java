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
		pencil.writer.tipDurability = 0;
		pencil.writer.write("Ab ");
		assertEquals(0, pencil.writer.tipDurability);
	}
	
	@Test
	public void writing1UppcaseAnd1LowerCaseAnd1BlankSpaceCharReducesTipDurabilityBy3Test() {
		pencil.writer.write("Ab ");
		assertEquals(BASE_TIP_DURABILITY - 3, pencil.writer.tipDurability);
	}
	
	@Test
	public void writingUppercaseCharReducesTipDurabilityBy2Test() {
		pencil.writer.write("A");
		assertEquals(BASE_TIP_DURABILITY - 2, pencil.writer.tipDurability);
	}
	
	@Test
	public void writingLowercaseCharReducesTipDurabilityBy1Test() {
		pencil.writer.write("a");
		assertEquals(BASE_TIP_DURABILITY - 1, pencil.writer.tipDurability);
	}
	
	@Test
	public void writingWhiteSpaceCharReducesTipDurabilityBy0Test() {
		pencil.writer.write(" ");
		assertEquals(BASE_TIP_DURABILITY, pencil.writer.tipDurability);
	}
	
	@Test
	public void aPencilWith1DurabilityCanWriteSingleCharThenReducesDurabilityTest() {
		pencil.writer.tipDurability = 1;
		pencil.writer.write("a");
		assertTrue(1 > pencil.writer.tipDurability);
	}
	
	@Test
	public void whenPencilHasNoTipDurabilityItWritesBlankSpaceInsteadOfTextTest() {
		pencil.writer.tipDurability = 0;
		pencil.writer.write("a");
		assertEquals(" ", paper.content);
	}
	
	@Test
	public void whenPencilHasNegative1TipDurabilityItWritesBlankSpaceInsteadOfTextTest() {
		pencil.writer.tipDurability = -1;
		pencil.writer.write("a");
		assertEquals(" ", paper.content);
	}
	
	@Test
	public void whenGivenStringTwoCharactersLongAnd0PointDurabilityPencilWritesTwoBlankSpacesTest() {
		pencil.writer.tipDurability = 0;
		pencil.writer.write("ab");
		assertEquals("  ", paper.content);
	}

}
