package com.yhassanzadeh.spring5web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mID;
    private String mTitle;
    private String mPublisher;
    private String mISBAN;

    @ManyToMany()
    private Set<Author> mAuthors;

    public Book(String title, String publisher, String ISBAN, Set<Author> authors)
    {
        mTitle = title;
        mPublisher = publisher;
        mISBAN = ISBAN;
        mAuthors = authors;
    }

    public Book(String title, String publisher, String ISBAN)
    {
        mTitle = title;
        mPublisher = publisher;
        mISBAN = ISBAN;
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

    public String getPublisher()
    {
        return mPublisher;
    }

    public void setPublisher(String publisher)
    {
        mPublisher = publisher;
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
}
