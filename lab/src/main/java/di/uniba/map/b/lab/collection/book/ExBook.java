/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.collection.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class ExBook {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Book b1 = new Book("ou4i3288w7re9w");
        b1.setTitle("titolo 1");
        b1.setPrice(13.5f);
        Book b2 = new Book("lkjlkjre34");
        b2.setTitle("titolo 2");
        b2.setPrice(10.5f);
        System.out.println(b1.equals(b2));
        List<Book> list = new ArrayList();
        list.add(b1);
        list.add(b2);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new BookTitleComparator());
        System.out.println(list);
    }

}
