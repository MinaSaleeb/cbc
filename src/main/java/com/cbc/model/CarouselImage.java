package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carousel_images database table.
 * 
 */
@Entity
@Table(name="carousel_images")
@NamedQuery(name="CarouselImage.findAll", query="SELECT c FROM CarouselImage c")
public class CarouselImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Column(name="image_path")
	private String imagePath;

	//bi-directional many-to-one association to Carousel
	@ManyToOne
	@JoinColumn(name="carousel")
	private Carousel carouselBean;

	public CarouselImage() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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

}