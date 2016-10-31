package es.ae;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test for BookshopTest.
 */
public class BookshopTest extends TestCase {

    Bookshop app;

    /**
     * @throws java.lang.Exception
     */
    @Override
    @Before
    public void setUp() throws Exception {
        app = new Bookshop();
    }

    /**
     * Basic Test method for {@link es.ae.Bookshop#price(Integer...)}
     */
    @Test
    public void testBasics() {

        assertEquals(0.0, app.price());
        assertEquals(8.0, app.price(0));
        assertEquals(8.0, app.price(1));
        assertEquals(8.0, app.price(2));
        assertEquals(8.0, app.price(3));
        assertEquals(8.0, app.price(4));
        assertEquals(8.0 * 2, app.price(0, 0));
        assertEquals(8.0 * 3, app.price(1, 1, 1));
    }

    /**
     * Test simple Discounts for {@link es.ae.Bookshop#price(Integer...)}
     */
    @Test
    public void testSimpleDiscounts() {

        assertEquals(8 * 2 * 0.95, app.price(0, 1));
        assertEquals(8 * 3 * 0.9, app.price(0, 2, 4));
        assertEquals(8 * 4 * 0.8, app.price(0, 1, 2, 4));
        assertEquals(8 * 5 * 0.75, app.price(0, 1, 2, 3, 4));

    }

}
