package cr.dnc.ns.broom.dto;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import cr.dnc.ns.broom.domain.Category;
import cr.dnc.ns.broom.domain.Pair;

public class PairingInputParamTest {
	private static PairingInputParam pip;
	private static List<Pair> expected;
	
	@BeforeClass
	public static void setUp() {
		pip = new PairingInputParam();
		
		List<Pair> pairs = new ArrayList<>();
		pairs.add(new Pair(new Category("PERSON"), "Bob Jones"));
		pairs.add(new Pair(new Category("PERSON"), "Bob Jones"));
		pairs.add(new Pair(new Category("PLACE"), "Texas"));
		pairs.add(new Pair(new Category("FOOD"), "Steak"));
		pairs.add(new Pair(new Category("ANIMAL"), "Cat"));
		pip.setPairs(pairs);
		
		expected = new ArrayList<>();
		expected.add(new Pair(new Category("person"), "Bob Jones"));
		expected.add(new Pair(new Category("person"), "Bob Jones"));
		expected.add(new Pair(new Category("place"), "Texas"));
		expected.add(new Pair(new Category("food"), "Steak"));
		expected.add(new Pair(new Category("animal"), "Cat"));
	}
	
	@Test
	public void testGetPairs() {
		assertArrayEquals(expected.toArray(), pip.getPairs().toArray());
	}

	@Test
	public void testSetPairs() {
		List<Pair> pairs = new ArrayList<>();
		pairs.add(new Pair(new Category("TEST"), "value"));
		pairs.add(new Pair(new Category("OTHER"), "other value"));
		pairs.add(new Pair(new Category("THIRD"), "Last One"));
		pip.setPairs(pairs);
		
		expected = new ArrayList<>();
		expected.add(new Pair(new Category("test"), "value"));
		expected.add(new Pair(new Category("other"), "other value"));
		expected.add(new Pair(new Category("third"), "Last One"));
		
		assertArrayEquals(expected.toArray(), pip.getPairs().toArray());
	}

}
