package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the news_contents database table.
 * 
 */
@Entity
@Table(name="news_contents")
@NamedQuery(name="NewsContent.findAll", query="SELECT n FROM NewsContent n")
public class NewsContent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Lob
	private String content;

	//bi-directional one-to-one association to CbcNew
	@OneToOne
	@JoinColumn(name="id")
	private CbcNew cbcNew;

	public NewsContent() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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