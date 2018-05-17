package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.Paper;
import main.java.Pencil;

public class EditTests {
	
	Paper paper;
	Pencil pencil;
	
	static int BASE = 100;
	
	@Before
	public void InitializePaperAndPencil() {
		paper = new Paper();
		pencil = new Pencil(paper, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
	
	@Test
	public void insertingThreeCharactersOverDifferentCharacterResultsInCollisionTest() {
		paper.content = "abc";
		pencil.insert("bcd", 0);
		assertEquals("@@@", paper.content);
	}
	
	@Test
	public void insertingThreeCharacterOverPartialWhiteSpaceResultsInPartialCollisionTest() {
		paper.content = "a c";
		pencil.insert("xxx", 0);
		assertEquals("@x@", paper.content);
	}
	
	@Test
	public void insertingCharacterOverDifferentCharacterResultsInCollisionTest() {
		paper.content = "a";
		pencil.insert("b", 0);
		assertEquals("@", paper.content);
	}
	
	@Test
	public void insertingCharacterOverSameCharacterResultsInCollisionTest() {
		paper.content = "a";
		pencil.insert("a", 0);
		assertEquals("@", paper.content);
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
}
