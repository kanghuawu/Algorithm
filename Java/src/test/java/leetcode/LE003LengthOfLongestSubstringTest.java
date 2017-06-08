package leetcode;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class LE003LengthOfLongestSubstringTest{

	private LE003LengthOfLongestSubstring t;
	@Before
    public void setUp()
    {
        t = new LE003LengthOfLongestSubstring();
    }
    @After
    public void tearDown()
    {
    }
	@Test
	public void test1() {
		assertEquals(3, t.lengthOfLongestSubstring("abcabcbb"));
	}

	@Test
	public void test2() {
		assertEquals(1, t.lengthOfLongestSubstring("bbbbb"));
	}
	@Test
	public void test3() {
		assertEquals(3, t.lengthOfLongestSubstring("pwwkew"));
	}
	@Test
	public void test4() {
		assertEquals(1, t.lengthOfLongestSubstring("c"));
	}
	@Test
	public void test5() {
		assertEquals(3, t.lengthOfLongestSubstring("dvdf"));
	}
	@Test
	public void test6() {
		assertEquals(5, t.lengthOfLongestSubstring("nfpdmpi"));
	}
	@Test
	public void test7() {
		assertEquals(5, t.lengthOfLongestSubstring("tmmzuxt"));
	}
}