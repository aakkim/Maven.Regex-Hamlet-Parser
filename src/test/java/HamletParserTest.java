import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String expected = hamletText;
        String actual = hamletParser.replaceText("hamlet", "leon");
//        System.out.println("Original: " + expected);
        System.out.println("Modified: " + actual);

        Assert.assertNotEquals(expected, actual);
        Assert.assertFalse(actual.contains("hamlet"));
        Assert.assertTrue(actual.contains("leon"));

    }

    @Test
    public void testChangeHoratioToTariq() {
        String expected = hamletText;
        String actual = hamletParser.replaceText("horatio", "tariq");
//        System.out.println("Original: " + expected);
        System.out.println("Modified: " + actual);

        Assert.assertNotEquals(expected, actual);
        Assert.assertFalse(actual.contains("horatio"));
        Assert.assertTrue(actual.contains("tariq"));

    }

    @Test
    public void testFindHoratio() {
        Boolean expected = true;
        Boolean actual = hamletParser.findText("horatio");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindHamlet() {
        Boolean expected = true;
        Boolean actual = hamletParser.findText("hamlet");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindBob() {
        Boolean expected = false;
        Boolean actual = hamletParser.findText("bob");

        Assert.assertEquals(expected, actual);
    }
}