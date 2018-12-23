package cr.dnc.ns.broom.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class PairTest {
	private static Pair pair;
	
	@BeforeClass
	public static void setUp() {
		pair = new Pair(new Category("TEST"), "value");
	}

	@Test
	public void testHashCode() {
		assertEquals(new Category("TEST").hashCode(), pair.hashCode());
	}

	@Test
	public void testGetCategory() {
		assertEquals(new Category("test"), pair.getCategory());
	}

	@Test
	public void testGetValue() {
		assertEquals("value", pair.getValue());
	}

	@Test
	public void testEqualsObject() {
		assertTrue(pair.equals(new Pair(new Category("Test"), "value")));
	}

}
