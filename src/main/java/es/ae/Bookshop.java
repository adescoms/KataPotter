package es.ae;

public class Bookshop {

    private static Double ONE_BOOK = 8.0;

    public Double price(Integer... books) {

        Double price = books.length * ONE_BOOK;

        return price;

    }
}
