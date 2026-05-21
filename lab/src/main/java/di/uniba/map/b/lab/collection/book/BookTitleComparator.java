/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.collection.book;

import java.util.Comparator;

/**
 *
 * @author pierpaolo
 */
public class BookTitleComparator implements Comparator<Book> {

    /**
     *
     * @param t
     * @param t1
     * @return
     */
    @Override
    public int compare(Book t, Book t1) {
        return t.getTitle().compareTo(t1.getTitle());
    }
    
}
