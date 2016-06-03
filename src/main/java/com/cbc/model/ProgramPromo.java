package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the program_promos database table.
 * 
 */
@Entity
@Table(name="program_promos")
public class ProgramPromo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String description;

	@Column(name="promo_url")
	private String promoUrl;

	private String title;
	
	@Column(name="thumbnail_path")
	private String thumbnailPath;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="program")
	private Program programBean;
	
	@ManyToOne
	@JoinColumn(name="hub_slick")
	private HubSlick hubSlick;

	public ProgramPromo() {
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

	public String getPromoUrl() {
		return this.promoUrl;
	}

	public void setPromoUrl(String promoUrl) {
		this.promoUrl = promoUrl;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the thumbnailPath
	 */
	public String getThumbnailPath() {
		return thumbnailPath;
	}

	/**
	 * @param thumbnailPath the thumbnailPath to set
	 */
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public Program getProgramBean() {
		return this.programBean;
	}

	public void setProgramBean(Program programBean) {
		this.programBean = programBean;
	}

	/**
	 * @return the hubSlick
	 */
	public HubSlick getHubSlick() {
		return hubSlick;
	}

	/**
	 * @param hubSlick the hubSlick to set
	 */
	public void setHubSlick(HubSlick hubSlick) {
		this.hubSlick = hubSlick;
	}

}