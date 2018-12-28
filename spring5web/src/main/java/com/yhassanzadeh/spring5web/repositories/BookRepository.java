package com.yhassanzadeh.spring5web.repositories;

import com.yhassanzadeh.spring5web.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>
{

}
