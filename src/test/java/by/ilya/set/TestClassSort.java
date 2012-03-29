package by.ilya.set;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Илья
 * Date: 26.3.12
 * Time: 16.30
 * To change this template use File | Settings | File Templates.
 */
public class TestClassSort extends TestCase {

    public static final String VALUE = "value";
    public static final String VALUE1 = "value1";
    public static final String VALUE2 = "value2";
    public static final String VALUE3 = "value3";
    public static final String VALUE4 = "value4";
    public static final String VALUE5 = "value5";

    Set test, test1;   // test object

    Iterator iterator;  // test Iterator

    @BeforeClass
    public static void oneTimeSetUp() {

    }

    @AfterClass
    public static void oneTimeTearDown() {

    }

    @Before
    public void setUp() {

        test = new MySortSet();   // test object
        test1 = new MySortSet();  // test1 object

        iterator = test.iterator();
    }

    @After
    public void tearDown() {
        test.clear();
        test1.clear();
    }


    // My tests for MySet
    public void testAdd() {
        assertTrue(test.toArray().length == 0);
        assertTrue(test.add(VALUE));
        assertFalse(test.add(VALUE));
        test.add(VALUE1);
        test.add(VALUE2);
        test.add(VALUE3);

        for (Object x : test) {
            System.out.println(x.hashCode());  // ordered output
        }

    }

    public void testRemove() {
        assertFalse(test.remove(VALUE));

        assertTrue(test.toArray().length == 0);

        assertTrue(test.add(VALUE));
        assertTrue(test.add(VALUE1));
        assertTrue(test.add(VALUE2));

        assertTrue(test.remove(VALUE));
        assertTrue(test.remove(VALUE1));

        System.out.println(test.toArray().length);

        for (Object x : test) {
            System.out.println(x);
        }


        /* assertTrue(test.toArray().length == 1);*/

    }

    public void testContains() {
        assertTrue(test.add(VALUE));
        assertTrue(test.add(VALUE4));
        assertTrue(test.contains(VALUE));
        assertFalse(test.contains(VALUE2));

        for (Object x : test) {
            System.out.println(x);
        }

    }

    public void testAddAll() {

        test.add(VALUE);
        test.add(VALUE2);
        test.add(VALUE3);

        assertTrue(test.size() == 3);

        test1.add(VALUE);
        test1.add(VALUE4);
        test1.add(VALUE5);

        assertTrue(test.addAll(test1));
        assertTrue(test.size() == 5);
        assertTrue(test.contains(VALUE5));
        assertTrue(test.contains(VALUE4));

    }


}
