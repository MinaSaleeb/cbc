package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carousel_images database table.
 * 
 */
@Entity
@Table(name="carousel_images")
public class CarouselImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="image_path")
	private String imagePath;

	//bi-directional many-to-one association to Carousel
	@ManyToOne
	@JoinColumn(name="carousel")
	private Carousel carouselBean;
	
	@OneToOne
	@JoinColumn(name="program")
	private Program programBean;

	public CarouselImage() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Carousel getCarouselBean() {
		return this.carouselBean;
	}

	public void setCarouselBean(Carousel carouselBean) {
		this.carouselBean = carouselBean;
	}

	/**
	 * @return the programBean
	 */
	public Program getProgramBean() {
		return programBean;
	}

	/**
	 * @param programBean the programBean to set
	 */
	public void setProgramBean(Program programBean) {
		this.programBean = programBean;
	}

}