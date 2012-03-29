package by.ilya.set;

import junit.framework.TestCase;
import org.junit.*;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Илья
 * Date: 27.3.12
 * Time: 9.45
 * To change this template use File | Settings | File Templates.
 */
public class TestAutoArray extends TestCase {

    public static final String VALUE =  "0";
    public static final String VALUE1 = "1";
    public static final String VALUE2 = "2";
    public static final String VALUE3 = "3";
    public static final String VALUE4 = "4";
    public static final String VALUE5 = "5";

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

        test = new MyAutoArray();   // test object
        test1 = new MyAutoArray();  // test1 object

        iterator = test.iterator();
    }

    @After
    public void tearDown() {
        test.clear();
        test1.clear();
    }

    @Test
    public void testAdd() {

        assertTrue(test.size() == 0);
        assertTrue(test.add(VALUE));
        assertFalse(test.add(VALUE));
        test.add(VALUE1);
        test.add(VALUE2);
        test.add(VALUE3);

        System.out.println(test.size());

        for (Object x : test) {
            System.out.println(x.hashCode());  // ordered output
        }

    }

    @Test
    public void testContains() {
        assertTrue(test.add(VALUE));
        assertTrue(test.add(VALUE4));
        assertTrue(test.contains(VALUE));
        assertFalse(test.contains(VALUE2));

        for (Object x : test) {
            System.out.println(x);
        }

    }

    @Test
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
    public void testRetainAll() {
        test.add(VALUE2);
        test.add(VALUE3);
        test.add(VALUE4);
        test.add(VALUE5);

        test1.add(VALUE);
        test1.add(VALUE3);
        test1.add(VALUE4);
        test1.add(VALUE5);


        test.retainAll(test1);

        for(Object element : test ){
            System.out.println(element);
        }
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
}
