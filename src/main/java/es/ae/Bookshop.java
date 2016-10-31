package es.ae;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bookshop {

    private static final Double ONE_BOOK = 8.0;
    private static final Double ZERO = 0.0;

    // Map with the discounts per different books
    private static final Map<Integer, Double> DISCOUNTS = Stream.of(
        new SimpleEntry<>(1, 1.0D),
        new SimpleEntry<>(2, 0.95D),
        new SimpleEntry<>(3, 0.90D),
        new SimpleEntry<>(4, 0.80D),
        new SimpleEntry<>(5, 0.75D))
        .collect(Collectors.toMap((se) -> se.getKey(), (se) -> se.getValue()));

    public Bookshop() {

    }

    /**
     * Group the books and return the total price
     * @param books
     * @return
     */
    public Double price(Integer... books) {

        Map<Integer, Integer> groupedBooks = new HashMap<>();

        for (Integer book : books) {
            if (groupedBooks.containsKey(book)) {
                Integer count = groupedBooks.get(book);
                count++;
                groupedBooks.put(book, count);
            } else {
                groupedBooks.put(book, 1);
            }
        }

        Double price = ZERO;
        while (!groupedBooks.isEmpty()) {
            price += calculate(groupedBooks);
        }

        return price;

    }

    /**
     * Calculate the price for a given map with grouped books
     * @param groupedBooks
     * @return
     */
    private Double calculate(Map<Integer, Integer> groupedBooks) {
        // map size -> number of different books
        Double discount = DISCOUNTS.get(groupedBooks.size());
        Double price = ZERO;
        
        Iterator<Integer> it = groupedBooks.keySet().iterator();

        while (it.hasNext()) {
            Integer k = it.next();
            if (groupedBooks.get(k) == 1) {
            	it.remove(); // remove the book when the map has only one
            } else {
                groupedBooks.put(k, groupedBooks.get(k) - 1); // Or subtract one to the counter of this book
            }
            price += ONE_BOOK;
        }

        price *= discount;

        return price;
    }
}
