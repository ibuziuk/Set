package by.ilya.set;

import junit.framework.TestCase;
import org.junit.*;

import java.util.Iterator;
import java.util.Set;


/**
 * Created by IntelliJ IDEA.
 * User: Илья
 * Date: 23.3.12
 * Time: 4.09
 * To change this template use File | Settings | File Templates.
 */

public class TestClass extends TestCase {

    public static final String VALUE = "test";
    public static final String VALUE1 = "test1";
    public static final String VALUE2 = "test2";
    public static final String VALUE3 = "test3";
    public static final String VALUE4 = "test4";
    public static final String VALUE5 = "test5";

    Set test, test1;   // test object
    /* private String value, value1, value2, value3, value4, value5;*/
    Iterator iterator;  // test Iterator

    @BeforeClass
    public static void oneTimeSetUp() {

    }

    @AfterClass
    public static void oneTimeTearDown() {

    }

    @Before
    public void setUp() {

        test = new MySet();   // test object
        test1 = new MySet();  // test1 object

        iterator = test.iterator();
    }

    @After
    public void tearDown() {
        test.clear();
        test1.clear();
    }


    // My tests for MySet

    @Test
    public void testIsEmpty() {


        assertTrue(test.isEmpty());// must be empty

        test.add(VALUE);// add element
        assertFalse(test.isEmpty());// must be full

        test.remove(iterator.next());// remove this
        assertTrue(test.isEmpty());//must be empty
    }

    @Test
    public void testAdd() {

        int size = test.toArray().length;  // size from the very beginning

        assertTrue(test.add(VALUE));
        assertFalse(test.add(VALUE));
        assertTrue(test.toArray().length == size + 1);
        assertTrue(test.size() == size + 1);


    }

    @Test
    public void testRemove() {

        assertFalse(test.remove(VALUE)); // array is empty

        test.add(VALUE);
        test.add(VALUE1);

        assertTrue(test.remove(VALUE1));
        assertEquals(test.toArray()[0], VALUE);

    }

    @Test
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

    @Test
    public void testRemoveAll() {

        test.add(VALUE);
        test.add(VALUE2);
        test.add(VALUE3);

        test1.add(VALUE);
        test1.add(VALUE4);
        test1.add(VALUE5);

        assertTrue(test.removeAll(test1));
        assertEquals(test.size(), 2);

        assertFalse(test.contains(VALUE4));
        assertFalse(test.contains(VALUE));
    }

    @Test
    public void testContains() {

        test.add(VALUE);
        test.add(VALUE2);
        test.add(VALUE3);

        assertTrue(test.contains(VALUE));
        assertFalse(test.contains(VALUE4));
    }

    @Test
    public void testSize() {

        assertEquals(test.size(), 0);

        test.add(VALUE);
        test.add(VALUE2);
        test.add(VALUE3);

        assertEquals(test.size(), 3);

    }

    @Test
    public void testClear() {

        test.add(VALUE);
        test.add(VALUE2);
        test.add(VALUE3);
        assertEquals(test.size(), 3);

        test.clear();
        assertEquals(test.size(), 0);

    }

    @Test
    public void testRetainAll() {
        test.add(VALUE1);
        test.add(VALUE2);
        test.add(VALUE3);

        test1.add(VALUE1);
        test1.add(VALUE2);
        test1.add(VALUE4);

        test.retainAll(test1);

        assertEquals(test.size(), 2);
        assertEquals(test.toArray()[0], VALUE1);
        assertEquals(test.toArray()[1], VALUE2);

    }

    @Test
    public void testContainsAll() {

        test.add(VALUE1);
        test.add(VALUE2);
        test.add(VALUE3);

        test1.add(VALUE1);
        test1.add(VALUE2);
        test1.add(VALUE4);
        assertFalse(test.containsAll(test1));

        test1.remove(VALUE4);

        assertTrue(test.containsAll(test1));

    }

    @Test
    public void testIterator() {


        /* test.add(VALUE1);
                test.add(VALUE2);
                test.add(VALUE3);



                iterator.hasNext();
                System.out.println(iterator.next());
                System.out.println(iterator.next());
                System.out.println(iterator.next());
                System.out.println(iterator.next());
        */


        /*  test.add(value1);
    test.add(value2);
    test.add(value3);

    boolean illegalStateExceptionThrown = false;
    try {
        iterator.remove();
    } catch (IllegalStateException e) {
        illegalStateExceptionThrown = true;
    }
    assertTrue(illegalStateExceptionThrown);


    assertEquals(test.size(), 3);
    assertFalse(test.contains(value1));

    iterator.next();
    iterator.remove();

    assertFalse(test.contains(value3));
    assertTrue(test.contains(value2));
    assertFalse(iterator.hasNext());
    boolean exceptionThrown = false;
    try {
        iterator.next();
    } catch (NoSuchElementException e) {
        exceptionThrown = true;
    }
    assertTrue("NoSuchElementException must be thrown", exceptionThrown);*/
    }
}
