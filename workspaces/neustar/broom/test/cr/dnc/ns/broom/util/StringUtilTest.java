package cr.dnc.ns.broom.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testCanonize() {
		assertEquals("GROUND", StringUtil.canonize(" ground "));
		assertEquals("CONTROL", StringUtil.canonize("Control "));
		assertEquals("TO", StringUtil.canonize(" TO"));
		assertEquals("MAJOR", StringUtil.canonize("   mAjOr "));
		assertEquals("TOM", StringUtil.canonize("TOM"));
	}

}
