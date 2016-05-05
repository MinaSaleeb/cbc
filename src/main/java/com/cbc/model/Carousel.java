package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carousels database table.
 * 
 */
@Entity
@Table(name="carousels")
@NamedQuery(name="Carousel.findAll", query="SELECT c FROM Carousel c")
public class Carousel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	//bi-directional many-to-one association to CarouselImage
	@OneToMany(mappedBy="carouselBean")
	private List<CarouselImage> carouselImages;

	//bi-directional many-to-one association to Channel
	@ManyToOne
	@JoinColumn(name="channel")
	private Channel channelBean;

	public Carousel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CarouselImage> getCarouselImages() {
		return this.carouselImages;
	}

	public void setCarouselImages(List<CarouselImage> carouselImages) {
		this.carouselImages = carouselImages;
	}

	public CarouselImage addCarouselImage(CarouselImage carouselImage) {
		getCarouselImages().add(carouselImage);
		carouselImage.setCarouselBean(this);

		return carouselImage;
	}

	public CarouselImage removeCarouselImage(CarouselImage carouselImage) {
		getCarouselImages().remove(carouselImage);
		carouselImage.setCarouselBean(null);

		return carouselImage;
	}

	public Channel getChannelBean() {
		return this.channelBean;
	}

	public void setChannelBean(Channel channelBean) {
		this.channelBean = channelBean;
	}

}