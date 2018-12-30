package com.yhassanzadeh.spring5web.bootstrap;

import com.yhassanzadeh.spring5web.model.Author;
import com.yhassanzadeh.spring5web.model.Book;
import com.yhassanzadeh.spring5web.model.Publisher;
import com.yhassanzadeh.spring5web.repositories.AuthorRepository;
import com.yhassanzadeh.spring5web.repositories.BookRepository;
import com.yhassanzadeh.spring5web.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{

    private AuthorRepository mAuthorRepository;
    private BookRepository mBookRepository;
    private PublisherRepository mPublisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
    {
        mAuthorRepository    = authorRepository;
        mBookRepository      = bookRepository;
        mPublisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        initData();
    }

    private void initData()
    {
        Author yahya = new Author("Yahya", "Hassanzadeh");
        Book GLARAS  = new Book("GLARAS", "1111");
        Publisher FGCS = new Publisher("FGCS", "Netherland");
        GLARAS.getAuthors().add(yahya);
        GLARAS.setPublisher(FGCS);
        yahya.getBooks().add(GLARAS);

        mAuthorRepository.save(yahya);
        mBookRepository.save(GLARAS);
        mPublisherRepository.save(FGCS);

        Author sanaz = new Author("Sanaz", "Taheri");
        Book GUARD = new Book("GUARD", "2222");
        Publisher IFIP = new Publisher("IFIP", "Sweden");
        GUARD.getAuthors().add(sanaz);
        GUARD.setPublisher(IFIP);
        sanaz.getBooks().add(GUARD);



        mAuthorRepository.save(sanaz);
        mBookRepository.save(GUARD);
        mPublisherRepository.save(IFIP);



    }
}
