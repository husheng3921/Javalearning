package com.hs.absin;

public class MainTest {
    public static void main(String[] args) {
        AbsBook book = new Book();
        book.paly(2);
        System.out.println(book.getI());
        BookInter bookInter = new InterBook();
        bookInter.play(8);
        System.out.println(3*0.1 == 0.3);
        System.out.println(3*0.1);
    }
}
