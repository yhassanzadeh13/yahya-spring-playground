package com.yhassanzadeh.spring5web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long mId;
    private String mFirstName;
    private String mLastName;

    @ManyToMany(mappedBy = "mAuthors")
    private Set<Book> mBooks;

    public Author()
    {
    }

    public Author(String firstName, String lastName)
    {
        mFirstName = firstName;
        mLastName = lastName;
        mBooks = new HashSet<>();
    }

    public Author(String firstName, String lastName, Set<Book> books)
    {
        mFirstName = firstName;
        mLastName = lastName;
        mBooks = books;
    }

    public Long getId()
    {
        return mId;
    }

    public void setId(Long id)
    {
        mId = id;
    }

    public String getFirstName()
    {
        return mFirstName;
    }

    public void setFirstName(String firstName)
    {
        mFirstName = firstName;
    }

    public String getLastName()
    {
        return mLastName;
    }

    public void setLastName(String lastName)
    {
        mLastName = lastName;
    }

    public Set<Book> getBooks()
    {
        return mBooks;
    }

    public void setBooks(Set<Book> books)
    {
        mBooks = books;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getId(), author.getId());
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(getId());
    }

    @Override
    public String toString()
    {
        return "Author{" +
                "mId=" + mId +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mBooks=" + mBooks +
                '}';
    }
}
