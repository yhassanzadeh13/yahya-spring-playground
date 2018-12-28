package com.yhassanzadeh.spring5web.repositories;

import com.yhassanzadeh.spring5web.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>
{
}
