package cr.dnc.ns.broom.business;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import cr.dnc.ns.broom.domain.Category;
import cr.dnc.ns.broom.domain.CategoryCatalog;
import cr.dnc.ns.broom.domain.Pair;

public class PairingLogicTest {
	private static PairingLogic pr;
	private static CategoryCatalog categories;
	private static List<Pair> pairs;
	
	@BeforeClass
	public static void setUp() {
		pr = new PairingLogic();
		
		categories = new CategoryCatalog();
		categories.init();
		
		pairs = new ArrayList<>();
		
		pairs.add(new Pair(new Category("PERSON"), "Bob Jones"));
		pairs.add(new Pair(new Category("PLACE"), "Washington"));
		pairs.add(new Pair(new Category("PERSON"), "Mary"));
		pairs.add(new Pair(new Category("COMPUTER"), "Mac"));
		pairs.add(new Pair(new Category("PERSON"), "Bob Jones"));
		pairs.add(new Pair(new Category("OTHER"), "Tree"));
		pairs.add(new Pair(new Category("ANIMAL"), "Dog"));
		pairs.add(new Pair(new Category("PLACE"), "Texas"));
		pairs.add(new Pair(new Category("FOOD"), "Steak"));
		pairs.add(new Pair(new Category("ANIMAL"), "Cat"));
		pairs.add(new Pair(new Category("PERSON"), "Mac"));
	}

	@Test
	public void testProcess() {
		Set<Pair> expected = new LinkedHashSet<>();
		
		expected.add(new Pair(new Category("PERSON"), "Bob Jones"));
		expected.add(new Pair(new Category("PLACE"), "Washington"));
		expected.add(new Pair(new Category("PERSON"), "Mary"));
		expected.add(new Pair(new Category("COMPUTER"), "Mac"));
		//expected.add(new Pair(new Category("PERSON"), "Bob Jones"));
		expected.add(new Pair(new Category("OTHER"), "Tree"));
		expected.add(new Pair(new Category("ANIMAL"), "Dog"));
		expected.add(new Pair(new Category("PLACE"), "Texas"));
		//expected.add(new Pair(new Category("FOOD"), "Steak"));
		expected.add(new Pair(new Category("ANIMAL"), "Cat"));
		expected.add(new Pair(new Category("PERSON"), "Mac"));
		
		Set<Pair> actual = pr.process(pairs);
		
		assertNotNull(actual);
		assertTrue(actual instanceof LinkedHashSet);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

}
