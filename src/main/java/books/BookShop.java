package books;

import java.util.HashSet;

public class BookShop {

    private final String name;

    /**
     * Constructor of the class Book shop
     *
     * @param name name of the book shop
     */
    public BookShop(String name) {
        this.name = name;
    }

    /**
     * method to compute the cost of a basket
     *
     * @param books array corresponding to the number of each harry potter book the client desire to buy (books.length should return 5)
     * @return the cost in euro with the discount
     */
    public double cost(int[] books) {
        HashSet<Integer> booknumber = new HashSet<>();
        int unique = 0;
        int duplicated = 0;

        //checks for double
        for (int book : books) {
            if (booknumber.contains(book)) {
                duplicated++;
            } else {
                booknumber.add(book);
                unique++;
            }
        }
        double discount;
        //get the discount
        switch (unique) {

            case 2:
                discount = (1.0 - 0.07);
                break;
            case 3:
                discount = (1.0 - 0.14);
                break;
            case 4:
                discount = (1.0 - 0.28);
                break;
            case 5:
                discount = (1.0 - 0.35);
                break;
            default:
                discount = 1;
        }
        return unique * 8.0 * discount + duplicated * 8.0;
    }
}
