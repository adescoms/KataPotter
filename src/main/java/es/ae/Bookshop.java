package es.ae;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bookshop {

    private static final Double ONE_BOOK = 8.0;
    private static final Double ZERO = 0.0;

    private static final Map<Integer, Double> DISCOUNTS = Stream.of(
        new SimpleEntry<>(1, 1.0D),
        new SimpleEntry<>(2, 0.95D),
        new SimpleEntry<>(3, 0.90D),
        new SimpleEntry<>(4, 0.80D),
        new SimpleEntry<>(5, 0.75D))
        .collect(Collectors.toMap((se) -> se.getKey(), (se) -> se.getValue()));

    public Bookshop() {

    }

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

        if (groupedBooks.size() > 0) {
        	price = books.length * ONE_BOOK * DISCOUNTS.get(groupedBooks.size());        	
        }

        return price;

    }
}
