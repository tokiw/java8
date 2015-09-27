package ex06_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLongestStringManager {

	@Test
	public void test() {
		LongestStringManager lsm = new LongestStringManager();
		assertEquals(null, lsm.get());
		lsm.setIfLonger("short");
		assertEquals("short", lsm.get());
		lsm.setIfLonger("longString");
		assertEquals("longString", lsm.get());
		lsm.setIfLonger("noLong");
		assertEquals("longString", lsm.get());
	}

}
