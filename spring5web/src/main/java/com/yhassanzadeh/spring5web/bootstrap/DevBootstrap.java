package com.yhassanzadeh.spring5web.bootstrap;

import com.yhassanzadeh.spring5web.model.Author;
import com.yhassanzadeh.spring5web.model.Book;
import com.yhassanzadeh.spring5web.repositories.AuthorRepository;
import com.yhassanzadeh.spring5web.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{

    private AuthorRepository mAuthorRepository;
    private BookRepository mBookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository)
    {
        mAuthorRepository = authorRepository;
        mBookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        initData();
    }

    private void initData()
    {
        Author yahya = new Author("Yahya", "Hassanzadeh");
        Book GLARAS  = new Book("GLARAS", "FGCS", "1111");
        GLARAS.getAuthors().add(yahya);
        yahya.getBooks().add(GLARAS);

        mAuthorRepository.save(yahya);
        mBookRepository.save(GLARAS);

        Author sanaz = new Author("Sanaz", "Taheri");
        Book GUARD = new Book("GUARD", "IFIP", "2222");
        GUARD.getAuthors().add(sanaz);
        sanaz.getBooks().add(GUARD);

        mAuthorRepository.save(sanaz);
        mBookRepository.save(GUARD);



    }
}
