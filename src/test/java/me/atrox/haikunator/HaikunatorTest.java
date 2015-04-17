package me.atrox.haikunator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class HaikunatorTest extends TestCase {
    private Map<String, Object> map = new HashMap<String, Object>();

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
        String haiku = Haikunator.haikunate(map);
        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))(-)(\\d{4})$"));
    }

    public void testHexUse() {
        map.put("tokenHex", true);

        String haiku = Haikunator.haikunate(map);
        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))(-)(.{4})$"));
    }

    public void test9DigitsUse() {
        map.put("tokenLength", 9);

        String haiku = Haikunator.haikunate(map);
        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))(-)(\\d{9})$"));
    }

    public void test9DigitsAsHexUse() {
        map.put("tokenLength", 9);
        map.put("tokenHex", true);

        String haiku = Haikunator.haikunate(map);
        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))(-)(.{9})$"));
    }

    public void testWontReturnSameForSubsequentCalls() {
        String haiku = Haikunator.haikunate(map);
        String haiku2 = Haikunator.haikunate(map);

        assertNotSame(haiku, haiku2);
    }

    public void testDropsToken() {
        map.put("tokenLength", 0);

        String haiku = Haikunator.haikunate(map);
        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))$"));
    }

    public void testPermitsOptionalDelimiter() {
        map.put("delimiter", ".");

        String haiku = Haikunator.haikunate(map);
        assertTrue(haiku.matches("((?:[a-z][a-z]+))(\\.)((?:[a-z][a-z]+))(\\.)(\\d+)$"));
    }

    public void testSpaceDelimiterAndNoToken() {
        map.put("delimiter", " ");
        map.put("tokenLength", 0);

        String haiku = Haikunator.haikunate(map);
        assertTrue(haiku.matches("((?:[a-z][a-z]+))( )((?:[a-z][a-z]+))$"));
    }

    public void testOneSingleWord() {
        map.put("delimiter", "");
        map.put("tokenLength", 0);

        String haiku = Haikunator.haikunate(map);
        assertTrue(haiku.matches("((?:[a-z][a-z]+))$"));
    }

    public void testCustomChars() {
        map.put("tokenChars", "A");

        String haiku = Haikunator.haikunate(map);
        assertTrue(haiku.matches("((?:[a-z][a-z]+))(-)((?:[a-z][a-z]+))(-)(AAAA)$"));
    }
}
