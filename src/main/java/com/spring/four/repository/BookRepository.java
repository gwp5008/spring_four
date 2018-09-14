package com.spring.four.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.four.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	@Modifying
	@Query("update Book b set b.active = ?1 where b.id = ?2")
	void deleteBook(int activeId, long bookId);
	
	@Query(value = "select * from Book b where b.book_id = ?1", nativeQuery = true)
	Book find(long bookId);
	
//	@Modifying
//	@Query("update Subject s set s.active = ?1 where s.id = ?2")
//	void deleteSubject(int activeId, Long subjectId);
}
