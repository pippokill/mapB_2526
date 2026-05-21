/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.collection.book;

import java.util.Objects;
import java.util.Set;

/**
 *
 * @author pierpaolo
 */
public class Book implements Comparable<Book> {

    private String isbn;

    private String title;

    private Set<String> authors;

    private Set<String> generes;

    private float price;

    /**
     *
     * @param isbn
     */
    public Book(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @param isbn
     * @param title
     */
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public Set<String> getAuthors() {
        return authors;
    }

    /**
     *
     * @param authors
     */
    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    /**
     *
     * @return
     */
    public Set<String> getGeneres() {
        return generes;
    }

    /**
     *
     * @param generes
     */
    public void setGeneres(Set<String> generes) {
        this.generes = generes;
    }

    /**
     *
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        return Objects.equals(this.isbn, other.isbn);
    }

    /**
     *
     * @param t
     * @return
     */
    @Override
    public int compareTo(Book t) {
       return Float.compare(price, t.getPrice());
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", price=" + price + '}';
    }
    
    

}
