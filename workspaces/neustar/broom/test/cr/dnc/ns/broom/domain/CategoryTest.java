package cr.dnc.ns.broom.domain;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CategoryTest {

	@Test
	public void testHashCode() {
		assertEquals(new String("TEST").hashCode(), new Category("TEST").hashCode());
	}

	@Test
	public void testGetName() {
		assertEquals("TEST", new Category("TEST").getName());
	}

	@Test
	public void testEqualsObject() {
		assertTrue(new Category("TEST").equals(new Category("test")));
	}

}
