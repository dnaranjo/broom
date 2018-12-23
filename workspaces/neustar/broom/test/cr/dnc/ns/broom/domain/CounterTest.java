package cr.dnc.ns.broom.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class CounterTest {
	private static Counter counter;
	
	@BeforeClass
	public static void setUp() {
		counter = new Counter(new Category("TEST"), 10);
	}

	@Test
	public void testGetCategory() {
		assertEquals(new Category("test"), counter.getCategory());
	}

	@Test
	public void testGetOccurrences() {
		assertEquals(10, counter.getOccurrences());
	}

	@Test
	public void testCompareTo() {
		Counter smaller = new Counter(new Category("TEST2"), 5);
		Counter equal = new Counter(new Category("TEST3"), 10);
		Counter larger = new Counter(new Category("TEST4"), 15);
		
		assertTrue(counter.compareTo(smaller) < 0);
		assertEquals(0,counter.compareTo(equal));
		assertTrue(counter.compareTo(larger) > 0);
	}

}
