package cr.dnc.ns.broom.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CategoryCatalogTest {
	private static CategoryCatalog categoryCatalog;
	List<Category> expectedCategories;
	
	@BeforeClass
	public static void setUp() {
		categoryCatalog = new CategoryCatalog();
	}
	
	@Before
	public void reload() {
		categoryCatalog.init();
		
		expectedCategories = new ArrayList<>();
		expectedCategories.add(new Category("person"));
		expectedCategories.add(new Category("place"));
		expectedCategories.add(new Category("animal"));
		expectedCategories.add(new Category("computer"));
		expectedCategories.add(new Category("other"));
	}

	@Test
	public void testInit() {
		categoryCatalog.init();
		
		assertArrayEquals(expectedCategories.toArray(), CategoryCatalog.getValidCategories().toArray());
	}

	@Test
	public void testAddStringArray() {
		categoryCatalog.add("FRUIT", "DESSERT");
		
		expectedCategories.add(new Category("fruit"));
		expectedCategories.add(new Category("dessert"));
		
		assertArrayEquals(expectedCategories.toArray(), CategoryCatalog.getValidCategories().toArray());
	}

	@Test
	public void testAddString() {
		categoryCatalog.add("THING");
		
		expectedCategories.add(new Category("Thing"));
		
		assertArrayEquals(expectedCategories.toArray(), CategoryCatalog.getValidCategories().toArray());
	}

	@Test
	public void testDelete() {
		categoryCatalog.delete("ANIMAL");
		
		expectedCategories.remove(new Category("animal"));
		
		assertArrayEquals(expectedCategories.toArray(), CategoryCatalog.getValidCategories().toArray());
	}

	@Test
	public void testGetValidCategories() {
		Set<Category> validCategories = CategoryCatalog.getValidCategories();
		
		assertNotNull(validCategories);
		assertTrue(validCategories instanceof CopyOnWriteArraySet);
	}

}
