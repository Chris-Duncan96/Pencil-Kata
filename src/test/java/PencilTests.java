package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.Paper;
import main.java.Pencil;

class PencilTests {
	
	@Test
	void paperCanBeInitializedWithNoArgumentsTest() {
		try {
			new Paper();
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void paperCanBeInjectedIntoPencilAsLoneArgumentTest() {
		try {
			Paper paper = new Paper();
			Pencil pencil = new Pencil(paper);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void whenGivenStringPencilWritesItToPaperTest() {
		Paper paper = new Paper();
		Pencil pencil = new Pencil(paper);
		pencil.write("a");
		assertEquals("a", paper.content);
	}
	
	@Test
	void whenGivenStringPencilAppendsItToPaperTest() {
		Paper paper = new Paper();
		paper.content = "b";
		Pencil pencil = new Pencil(paper);
		pencil.write("a");
		assertEquals("ba", paper.content);
	}


}
