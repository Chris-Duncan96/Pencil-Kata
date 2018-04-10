package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.Pencil;

class PencilTests {

	@Test
	void pencilCanBeInitializedWithOneArgumentTest() {
		try {
			new Pencil(1);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
