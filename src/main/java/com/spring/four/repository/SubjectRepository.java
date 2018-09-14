package com.spring.four.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.four.model.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{
	
	@Modifying
	@Query("update Subject s set s.active = ?1 where s.id = ?2")
	void deleteSubject(int activeId, Long subjectId);
	
	@Query(value = "select * from Subject s where s.subtitle = ?1", nativeQuery = true)
	Subject checkMatchingSubject(String subjectName);
	
	@Query(value = "select * from Subject s where s.subject_id = ?1", nativeQuery = true)
	Subject find(Long subjectId);
}

