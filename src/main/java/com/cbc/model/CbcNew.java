package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cbc_news database table.
 * 
 */
@Entity
@Table(name="cbc_news")
public class CbcNew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String description;

	@Column(name="photo_path")
	private String photoPath;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="posting_date")
	private Date postingDate;

	private String title;

	//bi-directional many-to-one association to NewsCategory
	@ManyToOne
	@JoinColumn(name="category")
	private NewsCategory newsCategory;

	//bi-directional one-to-one association to NewsContent
	@OneToOne(mappedBy="cbcNew")
	private NewsContent newsContent;

	//bi-directional many-to-one association to ProgramNew
	@OneToMany(mappedBy="cbcNew")
	private List<ProgramNew> programNews;
	
	@Column(name="video_url")
	private String videoUrl;
	
	private String type;
	
	public CbcNew() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Date getPostingDate() {
		return this.postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public NewsCategory getNewsCategory() {
		return this.newsCategory;
	}

	public void setNewsCategory(NewsCategory newsCategory) {
		this.newsCategory = newsCategory;
	}

	public NewsContent getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(NewsContent newsContent) {
		this.newsContent = newsContent;
	}

	public List<ProgramNew> getProgramNews() {
		return this.programNews;
	}

	public void setProgramNews(List<ProgramNew> programNews) {
		this.programNews = programNews;
	}

	public ProgramNew addProgramNew(ProgramNew programNew) {
		getProgramNews().add(programNew);
		programNew.setCbcNew(this);

		return programNew;
	}

	public ProgramNew removeProgramNew(ProgramNew programNew) {
		getProgramNews().remove(programNew);
		programNew.setCbcNew(null);

		return programNew;
	}

	/**
	 * @return the videoUrl
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * @param videoUrl the videoUrl to set
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}