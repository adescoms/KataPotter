package es.ae;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test for BookshopTest.
 */
public class BookshopTest extends TestCase {

    Bookshop bookshop;

    /**
     * @throws java.lang.Exception
     */
    @Override
    @Before
    public void setUp() throws Exception {
        bookshop = new Bookshop();
    }

    /**
     * Basic Test method for {@link es.ae.Bookshop#price(Integer...)}
     */
    @Test
    public void testBasics() {
        assertEquals(0.0, bookshop.price());
        assertEquals(8.0, bookshop.price(0));
        assertEquals(8.0, bookshop.price(1));
        assertEquals(8.0, bookshop.price(2));
        assertEquals(8.0, bookshop.price(3));
        assertEquals(8.0, bookshop.price(4));
        assertEquals(8.0 * 2, bookshop.price(0, 0));
        assertEquals(8.0 * 3, bookshop.price(1, 1, 1));
    }

    /**
     * Test simple Discounts for {@link es.ae.Bookshop#price(Integer...)}
     */
    @Test
    public void testSimpleDiscounts() {
        assertEquals(8 * 2 * 0.95, bookshop.price(0, 1));
        assertEquals(8 * 3 * 0.9, bookshop.price(0, 2, 4));
        assertEquals(8 * 4 * 0.8, bookshop.price(0, 1, 2, 4));
        assertEquals(8 * 5 * 0.75, bookshop.price(0, 1, 2, 3, 4));
    }

    /**
     * Test Several Discounts for {@link es.ae.Bookshop#price(Integer...)}
     */
    @Test
    public void testSeveralDiscounts() {
        assertEquals(8 + (8 * 2 * 0.95), bookshop.price(0, 0, 1));
        assertEquals(2 * (8 * 2 * 0.95), bookshop.price(0, 0, 1, 1));
        assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), bookshop.price(0, 0, 1, 2, 2, 3));
        assertEquals(8 + (8 * 5 * 0.75), bookshop.price(0, 1, 1, 2, 3, 4));
    }
}
