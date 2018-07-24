package ca.corykruger.magic.magic_library.mtgjson.set_list;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SetTest {
	
	private Set setA;
	
	@Before
	public void setUp() {
		setA = new Set("Unstable", "UST", "2017-12-08");
	}

	@Test
	public void sameObjectIsEqual() {
		assertTrue(setA.equals(setA));
	}
	
	@Test
	public void nonSetObjectNotEqual() {
		assertFalse(setA.equals(new Object()));
	}
	
	@Test
	public void wrongNameNotEqual() {
		Set setB = new Set("!Unstable", setA.getCode(), setA.getReleaseDate());
		assertFalse(setA.equals(setB));
		assertFalse(setB.equals(setA));
	}
	
	@Test
	public void wrongCodeNotEqual() {
		Set setB = new Set(setA.getName(), "!UST", setA.getReleaseDate());
		assertFalse(setA.equals(setB));
		assertFalse(setB.equals(setA));
	}
	
	@Test
	public void wrongReleaseDateNotEqual() {
		Set setB = new Set(setA.getName(), setA.getCode(), "1970-01-01");
		assertFalse(setA.equals(setB));
		assertFalse(setB.equals(setA));
	}
	
	@Test
	public void sameFieldsAreEqual() {
		Set setB = new Set(setA.getName(), setA.getCode(), setA.getReleaseDate());
		assertTrue(setA.equals(setB));
		assertTrue(setB.equals(setA));
	}

}
