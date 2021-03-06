package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the news_contents database table.
 * 
 */
@Entity
@Table(name="news_contents")
public class NewsContent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Lob
	private String content;

	//bi-directional one-to-one association to CbcNew
	@OneToOne
	@JoinColumn(name="id")
	private CbcNew cbcNew;

	public NewsContent() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CbcNew getCbcNew() {
		return this.cbcNew;
	}

	public void setCbcNew(CbcNew cbcNew) {
		this.cbcNew = cbcNew;
	}

}