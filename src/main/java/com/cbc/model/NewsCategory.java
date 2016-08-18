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
	
	@OneToOne
	@JoinColumn(name="featured_news")
	private CbcNew featuredNews;
	
	@Column(name="bg_image")
	private String bgImage;
	
	@OneToMany(mappedBy="newsCategory")
	private List<NewsCategoriesAdDiv> newsCategoryAdDivs;
	
	@ManyToOne
	@JoinColumn(name="parent_category")
	private NewsCategory parentCategory;

	//bi-directional many-to-one association to NewsCategory
	@OneToMany(mappedBy="parentCategory")
	private List<NewsCategory> subCategories;

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

	/**
	 * @return the featuredNews
	 */
	public CbcNew getFeaturedNews() {
		return featuredNews;
	}

	/**
	 * @param featuredNews the featuredNews to set
	 */
	public void setFeaturedNews(CbcNew featuredNews) {
		this.featuredNews = featuredNews;
	}

	/**
	 * @return the bgImage
	 */
	public String getBgImage() {
		return bgImage;
	}

	/**
	 * @param bgImage the bgImage to set
	 */
	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}

	/**
	 * @return the newsCategoryAdDivs
	 */
	public List<NewsCategoriesAdDiv> getNewsCategoryAdDivs() {
		return newsCategoryAdDivs;
	}

	/**
	 * @param newsCategoryAdDivs the newsCategoryAdDivs to set
	 */
	public void setNewsCategoryAdDivs(List<NewsCategoriesAdDiv> newsCategoryAdDivs) {
		this.newsCategoryAdDivs = newsCategoryAdDivs;
	}

	/**
	 * @return the parentCategory
	 */
	public NewsCategory getParentCategory() {
		return parentCategory;
	}

	/**
	 * @param parentCategory the parentCategory to set
	 */
	public void setParentCategory(NewsCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	/**
	 * @return the subCategories
	 */
	public List<NewsCategory> getSubCategories() {
		return subCategories;
	}

	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(List<NewsCategory> subCategories) {
		this.subCategories = subCategories;
	}

}