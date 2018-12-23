package cr.dnc.ns.broom.dto;

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
import cr.dnc.ns.broom.domain.Counter;
import cr.dnc.ns.broom.domain.Pair;

public class PairingResponseTest {
	private static PairingResponse pr;
	private static List<Counter> expectedCount;
	
	@BeforeClass
	public static void setUp() {
		Set<Pair> processedList = new LinkedHashSet<>();
		processedList.add(new Pair(new Category("PERSON"), "Bob Jones"));
		processedList.add(new Pair(new Category("PLACE"), "Washington"));
		processedList.add(new Pair(new Category("PERSON"), "Mary"));
		processedList.add(new Pair(new Category("COMPUTER"), "Mac"));
		processedList.add(new Pair(new Category("OTHER"), "Tree"));
		processedList.add(new Pair(new Category("ANIMAL"), "Dog"));
		processedList.add(new Pair(new Category("PLACE"), "Texas"));
		processedList.add(new Pair(new Category("ANIMAL"), "Cat"));
		processedList.add(new Pair(new Category("PERSON"), "Mac"));
		
		pr = new PairingResponse(processedList);
		
		expectedCount = new ArrayList<>();
		expectedCount.add(new Counter(new Category("person"), 3));
		expectedCount.add(new Counter(new Category("animal"), 2));
		expectedCount.add(new Counter(new Category("place"), 2));
		expectedCount.add(new Counter(new Category("other"), 1));
		expectedCount.add(new Counter(new Category("computer"), 1));
	}

	@Test
	public void testUpdateCounters() {
		pr.updateCounters();
		
		assertArrayEquals(expectedCount.toArray(), pr.getCount().toArray());
	}

	@Test
	public void testGetProcessedList() {
		Set<Pair> processedList = new LinkedHashSet<>();
		processedList.add(new Pair(new Category("PERSON"), "Bob Jones"));
		processedList.add(new Pair(new Category("PLACE"), "Washington"));
		processedList.add(new Pair(new Category("PERSON"), "Mary"));
		processedList.add(new Pair(new Category("COMPUTER"), "Mac"));
		processedList.add(new Pair(new Category("OTHER"), "Tree"));
		processedList.add(new Pair(new Category("ANIMAL"), "Dog"));
		processedList.add(new Pair(new Category("PLACE"), "Texas"));
		processedList.add(new Pair(new Category("ANIMAL"), "Cat"));
		processedList.add(new Pair(new Category("PERSON"), "Mac"));
		
		assertNotNull(pr.getProcessedList());
		assertTrue(pr.getProcessedList() instanceof LinkedHashSet);
		assertArrayEquals(processedList.toArray(), pr.getProcessedList().toArray());
	}

	@Test
	public void testGetCount() {
		assertNotNull(pr.getCount());
		assertTrue(pr.getCount() instanceof ArrayList);
		assertArrayEquals(expectedCount.toArray(), pr.getCount().toArray());
	}

}
