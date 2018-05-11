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
		pencil = new Pencil(paper);
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
}
