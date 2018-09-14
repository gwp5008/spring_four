package com.spring.four.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "subject")
@EntityListeners(AuditingEntityListener.class)
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private Long subjectId;
	
	@Column(name = "subtitle")
	private String subtitle;
	
	@Column(name = "duration_in_hours")
	private int durationInHours;
	
	@Column(name = "active")
	private int active;
	
	@OneToMany(mappedBy = "subject", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Book> books;
	
	public Subject() {
		
	}

	public Subject(String subtitle, int durationInHours, int active) {
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
		this.active = active;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subTitle=" + subtitle + ", durationInHours=" + durationInHours
				+ ", active=" + active + ", books=" + books + "]";
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subTitle) {
		this.subtitle = subTitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<Book> getBooks() {
		return books;
	}
}
