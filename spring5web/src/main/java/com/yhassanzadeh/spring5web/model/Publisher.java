package com.yhassanzadeh.spring5web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mID;
    private String mName;
    private String mAddress;

    private Set<Book> mBookSet;

    public Publisher(String name, String address)
    {
        mName = name;
        mAddress = address;
        mBookSet = new HashSet<>();
    }

    public Publisher(String name, String address, Set<Book> bookSet)
    {
        mName = name;
        mAddress = address;
        mBookSet = bookSet;
    }

    public Long getID()
    {
        return mID;
    }

    public void setID(Long ID)
    {
        mID = ID;
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String name)
    {
        mName = name;
    }

    public String getAddress()
    {
        return mAddress;
    }

    public void setAddress(String address)
    {
        mAddress = address;
    }

    public Set<Book> getBookSet()
    {
        return mBookSet;
    }

    public void setBookSet(Set<Book> bookSet)
    {
        mBookSet = bookSet;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(getID(), publisher.getID());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getID());
    }

    @Override
    public String toString()
    {
        return "Publisher{" +
                "mID=" + mID +
                ", mName='" + mName + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mBookSet=" + mBookSet +
                '}';
    }
}
