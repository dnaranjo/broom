package cr.dnc.ns.broom.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import cr.dnc.ns.broom.domain.CategoryCatalog;

public class PairingControllerTest {
	private static PairingController pairingController;
	private static CategoryCatalog categories;
	
	@BeforeClass
	public static void setUp() {
		pairingController = new PairingController();
		categories = new CategoryCatalog();
		categories.init();
	}

	@Test
	public void testProcess() {
		String expectedOutput = "{\"processedList\":[{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Bob Jones\"},{\"category\":{\"name\":\"PLACE\"},\"subCategory\":\"Washington\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Mary\"},{\"category\":{\"name\":\"COMPUTER\"},\"subCategory\":\"Mac\"},{\"category\":{\"name\":\"OTHER\"},\"subCategory\":\"Tree\"},{\"category\":{\"name\":\"ANIMAL\"},\"subCategory\":\"Dog\"},{\"category\":{\"name\":\"PLACE\"},\"subCategory\":\"Texas\"},{\"category\":{\"name\":\"ANIMAL\"},\"subCategory\":\"Cat\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Mac\"}],\"count\":[{\"category\":{\"name\":\"PERSON\"},\"occurrences\":3},{\"category\":{\"name\":\"ANIMAL\"},\"occurrences\":2},{\"category\":{\"name\":\"PLACE\"},\"occurrences\":2},{\"category\":{\"name\":\"OTHER\"},\"occurrences\":1},{\"category\":{\"name\":\"COMPUTER\"},\"occurrences\":1}]}";
		
		String input = "{\"pairs\":[{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Bob Jones\"},{\"category\":{\"name\":\"PLACE\"},\"subCategory\":\"Washington\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Mary\"},{\"category\":{\"name\":\"COMPUTER\"},\"subCategory\":\"Mac\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Bob Jones\"},{\"category\":{\"name\":\"OTHER\"},\"subCategory\":\"Tree\"},{\"category\":{\"name\":\"ANIMAL\"},\"subCategory\":\"Dog\"},{\"category\":{\"name\":\"PLACE\"},\"subCategory\":\"Texas\"},{\"category\":{\"name\":\"FOOD\"},\"subCategory\":\"Steak\"},{\"category\":{\"name\":\"ANIMAL\"},\"subCategory\":\"Cat\"},{\"category\":{\"name\":\"PERSON\"},\"subCategory\":\"Mac\"}]}";
		String actualOutput = pairingController.process(input);
		
		assertEquals(expectedOutput, actualOutput);
	}

}
