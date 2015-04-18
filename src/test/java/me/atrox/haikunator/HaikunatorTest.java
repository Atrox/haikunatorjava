package me.atrox.haikunator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HaikunatorTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HaikunatorTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HaikunatorTest.class );
    }

    public void testDefaultUse() {
        Haikunator haikunator = new HaikunatorBuilder().build();
        String haiku = haikunator.haikunate();

        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))(-)(\\d{4})$"));
    }

    public void testHexUse() {
        Haikunator haikunator = new HaikunatorBuilder().setTokenHex(true).build();
        String haiku = haikunator.haikunate();

        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))(-)(.{4})$"));
    }

    public void test9DigitsUse() {
        Haikunator haikunator = new HaikunatorBuilder().setTokenLength(9).build();
        String haiku = haikunator.haikunate();

        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))(-)(\\d{9})$"));
    }

    public void test9DigitsAsHexUse() {
        Haikunator haikunator = new HaikunatorBuilder().setTokenHex(true).setTokenLength(9).build();
        String haiku = haikunator.haikunate();

        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))(-)(.{9})$"));
    }

    public void testWontReturnSameForSubsequentCalls() {
        Haikunator haikunator = new HaikunatorBuilder().build();
        String haiku = haikunator.haikunate();
        String haiku2 = haikunator.haikunate();

        assertNotSame(haiku, haiku2);
    }

    public void testDropsToken() {
        Haikunator haikunator = new HaikunatorBuilder().setTokenLength(0).build();
        String haiku = haikunator.haikunate();

        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))$"));
    }

    public void testPermitsOptionalDelimiter() {
        Haikunator haikunator = new HaikunatorBuilder().setDelimiter(".").build();
        String haiku = haikunator.haikunate();

        assertTrue(haiku.matches("((?:[a-z][a-z]+))(\\.)((?:[a-z][a-z]+))(\\.)(\\d+)$"));
    }

    public void testSpaceDelimiterAndNoToken() {
        Haikunator haikunator = new HaikunatorBuilder().setDelimiter(" ").setTokenLength(0).build();
        String haiku = haikunator.haikunate();

        assertTrue(haiku.matches("((?:[a-z][a-z]+))( )((?:[a-z][a-z]+))$"));
    }

    public void testOneSingleWord() {
        Haikunator haikunator = new HaikunatorBuilder().setDelimiter("").setTokenLength(0).build();
        String haiku = haikunator.haikunate();

        assertTrue(haiku.matches("((?:[a-z][a-z]+))$"));
    }

    public void testCustomChars() {
        Haikunator haikunator = new HaikunatorBuilder().setTokenChars("A").build();
        String haiku = haikunator.haikunate();

        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))(-)(AAAA)$"));
    }
}
