package com.yhassanzadeh.spring5web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mID;
    private String mTitle;
    private Publisher mPublisher;
    private String mISBAN;

    @ManyToMany()
    @JoinTable(name = "book_author",
            joinColumns =  @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> mAuthors;

    public Book(String title, String ISBAN)
    {
        mTitle = title;
        mISBAN = ISBAN;
        mAuthors = new HashSet<>();
    }

    public Book(String title, Publisher publisher, String ISBAN)
    {
        mTitle = title;
        mPublisher = publisher;
        mISBAN = ISBAN;
        mAuthors = new HashSet<>();
    }

    public Book(String title, Publisher publisher, String ISBAN, Set<Author> authors)
    {
        mTitle = title;
        mPublisher = publisher;
        mISBAN = ISBAN;
        mAuthors = authors;
    }

    public Long getID()
    {
        return mID;
    }

    public void setID(Long ID)
    {
        mID = ID;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }



    public String getISBAN()
    {
        return mISBAN;
    }

    public void setISBAN(String ISBAN)
    {
        mISBAN = ISBAN;
    }

    public Set<Author> getAuthors()
    {
        return mAuthors;
    }

    public void setAuthors(Set<Author> authors)
    {
        mAuthors = authors;
    }

    public Publisher getPublisher()
    {
        return mPublisher;
    }

    public void setPublisher(Publisher publisher)
    {
        mPublisher = publisher;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getID(), book.getID());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getID());
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "mID=" + mID +
                ", mTitle='" + mTitle + '\'' +
                ", mPublisher=" + mPublisher.getName() +
                ", mISBAN='" + mISBAN + '\'' +
                ", mAuthors=" + mAuthors +
                '}';
    }
}
