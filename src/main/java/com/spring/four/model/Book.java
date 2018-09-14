package com.spring.four.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "book")
@EntityListeners(AuditingEntityListener.class)
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long bookId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "volume")
	private int volume;
	
	@Column(name = "publish_date")
	private String publishDate;
	
	@Column(name = "active")
	private int active;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	public Book() {
		
	}
	
//	public Book(String title, Double price, int volume, String publishDate, int active) {
//		this.title = title;
//		this.price = price;
//		this.volume = volume;
//		this.publishDate = publishDate;
//		this.active = active;
//	}
//	public Book(String title, Double price, int volume, String publishDate, int active, Subject subject) {
//		this.title = title;
//		this.price = price;
//		this.volume = volume;
//		this.publishDate = publishDate;
//		this.active = active;
//		this.subject = subject;
//	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + ", active=" + active + ", subject=" + subject + "]";
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
