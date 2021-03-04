package books;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BookShopTest {
    BookShop b = new BookShop("LLCC");


    @Test
    public void onlyDifferentBook() {
        assertEquals(8.0, b.cost(new int[]{1}));
        assertEquals(8.0 * 2 * (1-0.07), b.cost(new int[]{1, 2}));
        assertEquals(8.0 * 3 * (1-0.14), b.cost(new int[]{1, 2, 3}));
        assertEquals(8.0 * 4 * (1-0.28), b.cost(new int[]{1, 2, 3, 4}));
        assertEquals(8.0 * 5 * (1-0.35), b.cost(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void noBook() {
        assertEquals(0, b.cost(new int[]{}));
    }

    @Test
    public void onlySameBook() {
        assertEquals(8 * 2, b.cost(new int[]{1, 1}));
        assertEquals(8 * 3, b.cost(new int[]{1, 1, 1}));
        assertEquals(8 * 4, b.cost(new int[]{2, 2, 2, 2}));
    }

    @Test
    public void bigCommand() {
        assertEquals(12*8 +  4*8*(1-0.28), b.cost(new int[]{1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4}));
        assertEquals(13*8 +  3*8*(1-0.14), b.cost(new int[]{1,2,3,1,1,2,3,1,1,2,3,1,1,2,3,1}));
        assertEquals(14*8 +  2*8*(1-0.07), b.cost(new int[]{1,2,1,1,1,2,1,1,1,2,1,1,1,2,1,1}));
        assertEquals(16*8 , b.cost(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }

    @Test
    public void negativeBooks(){
        assertEquals(3*8*(1-0.14), b.cost(new int[]{-1,-28,-48}));
    }

    @Test
    public void everyBookTwoTimes() {
        assertEquals(8 * 5 + 8 * 5 * (1-0.35), b.cost(new int[]{1,1,2,2,3,3,4,4,5,5}));
    }

}