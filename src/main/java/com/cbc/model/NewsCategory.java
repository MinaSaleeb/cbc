package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the news_categories database table.
 * 
 */
@Entity
@Table(name="news_categories")
public class NewsCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="category_name")
	private String categoryName;

	//bi-directional many-to-one association to Channel
	@ManyToOne
	@JoinColumn(name="channel")
	private Channel channelBean;

	//bi-directional many-to-one association to CbcNew
	@OneToMany(mappedBy="newsCategory")
	private List<CbcNew> cbcNews;

	public NewsCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Channel getChannelBean() {
		return this.channelBean;
	}

	public void setChannelBean(Channel channelBean) {
		this.channelBean = channelBean;
	}

	public List<CbcNew> getCbcNews() {
		return this.cbcNews;
	}

	public void setCbcNews(List<CbcNew> cbcNews) {
		this.cbcNews = cbcNews;
	}

	public CbcNew addCbcNew(CbcNew cbcNew) {
		getCbcNews().add(cbcNew);
		cbcNew.setNewsCategory(this);

		return cbcNew;
	}

	public CbcNew removeCbcNew(CbcNew cbcNew) {
		getCbcNews().remove(cbcNew);
		cbcNew.setNewsCategory(null);

		return cbcNew;
	}

}