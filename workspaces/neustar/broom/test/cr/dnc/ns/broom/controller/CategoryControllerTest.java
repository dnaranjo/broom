package cr.dnc.ns.broom.controller;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;

import cr.dnc.ns.broom.domain.Category;
import cr.dnc.ns.broom.domain.CategoryCatalog;

public class CategoryControllerTest {
	private static CategoryController categoryController;
	private static List<Category> expectedCategories;
	
	@Before
	public void reload() throws ServletException {
		categoryController = new CategoryController();
		categoryController.init();
		
		expectedCategories = new ArrayList<>();
		expectedCategories.add(new Category("person"));
		expectedCategories.add(new Category("place"));
		expectedCategories.add(new Category("animal"));
		expectedCategories.add(new Category("computer"));
		expectedCategories.add(new Category("other"));
	}

	@Test
	public void testInit() {
		try {
			categoryController.init();
			assertFalse(CategoryCatalog.getValidCategories().isEmpty());
		} catch (ServletException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testListValidCategories() {
		assertEquals("[{\"name\":\"PERSON\"},{\"name\":\"PLACE\"},{\"name\":\"ANIMAL\"},{\"name\":\"COMPUTER\"},{\"name\":\"OTHER\"}]", categoryController.listValidCategories());
	}

	@Test
	public void testAddCategory() {
		assertTrue(categoryController.addCategory("TEST"));
		assertFalse(categoryController.addCategory("PERSON"));
		
		assertEquals("[{\"name\":\"PERSON\"},{\"name\":\"PLACE\"},{\"name\":\"ANIMAL\"},{\"name\":\"COMPUTER\"},{\"name\":\"OTHER\"},{\"name\":\"TEST\"}]", categoryController.listValidCategories());
	}

	@Test
	public void testDeleteCategory() {
		assertFalse(categoryController.deleteCategory("TEST"));
		assertTrue(categoryController.deleteCategory("PLACE"));
		
		assertEquals("[{\"name\":\"PERSON\"},{\"name\":\"ANIMAL\"},{\"name\":\"COMPUTER\"},{\"name\":\"OTHER\"}]", categoryController.listValidCategories());
	}

}
