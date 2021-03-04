package books;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookShopTest {
    BookShop b = new BookShop("LLCC");

    //Only different books will be in the command
    @Test
    public void onlyDifferentBook1() {
        assertEquals(8.0, b.cost(new int[]{1}));
    }

    @Test
    public void onlyDifferentBook2() {
        assertEquals(8.0 * 2 * (1 - 0.07), b.cost(new int[]{1, 2}));
    }

    @Test
    public void onlyDifferentBook3() {
        assertEquals(8.0 * 3 * (1 - 0.14), b.cost(new int[]{1, 2, 3}));
    }

    @Test
    public void onlyDifferentBook4() {
        assertEquals(8.0 * 4 * (1 - 0.28), b.cost(new int[]{1, 2, 3, 4}));

    }

    @Test
    public void onlyDifferentBook5() {
        assertEquals(8.0 * 5 * (1 - 0.35), b.cost(new int[]{1, 2, 3, 4, 5}));
    }


    //if no books are taken then it should be 0
    @Test
    public void noBook() {
        assertEquals(0, b.cost(new int[]{}));
    }

    //No discount should be applied here
    @Test
    public void onlySameBookWith2Books() {
        assertEquals(8 * 2, b.cost(new int[]{1, 1}));
    }

    @Test
    public void onlySameBookWith3Books() {
        assertEquals(8 * 3, b.cost(new int[]{1, 1, 1}));
    }


    @Test
    public void onlySameBookWith4Books() {
        assertEquals(8 * 4, b.cost(new int[]{2, 2, 2, 2}));
    }


    //Tring to go with more then 5 books to see if the system can handle it
    @Test
    public void bigCommandWith3Differents() {
        assertEquals(13 * 8 + 3 * 8 * (1 - 0.14), b.cost(new int[]{1, 2, 3, 1, 1, 2, 3, 1, 1, 2, 3, 1, 1, 2, 3, 1}));
    }

    @Test
    public void bigCommandWith2differents() {
        assertEquals(14 * 8 + 2 * 8 * (1 - 0.07), b.cost(new int[]{1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1}));
    }

    @Test
    public void bigCommandWith0Differents() {
        assertEquals(16 * 8, b.cost(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void bigCommandWith4Differents() {
        assertEquals(12 * 8 + 4 * 8 * (1 - 0.28), b.cost(new int[]{1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4}));
    }


    //Doesn't make sense but if a book has a negativ number the system should be able to handle it as well.
    @Test
    public void negativeBooks() {
        assertEquals(3 * 8 * (1 - 0.14), b.cost(new int[]{-1, -28, -48}));
    }

    //Taking all the books two times giving the big discount + 5 times the 8$ price.
    @Test
    public void everyBookTwoTimes() {
        assertEquals(8 * 5 + 8 * 5 * (1 - 0.35), b.cost(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}));
    }

}