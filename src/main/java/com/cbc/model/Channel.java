package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the channels database table.
 * 
 */
@Entity
@Table(name="channels")
public class Channel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="channel_bg_image")
	private String channelBgImage;

	@Column(name="channel_image")
	private String channelImage;

	@Column(name="channel_name")
	private String channelName;

	@Column(name="live_streaming_url")
	private String liveStreamingUrl;

	//bi-directional many-to-one association to Carousel
	@OneToMany(mappedBy="channelBean")
	private List<Carousel> carousels;

	//bi-directional many-to-one association to NewsCategory
	@OneToMany(mappedBy="channelBean")
	private List<NewsCategory> newsCategories;

	//bi-directional many-to-one association to Program
	@OneToMany(mappedBy="channelBean")
	private List<Program> programs;

	//bi-directional many-to-one association to TimeLine
	@OneToMany(mappedBy="channelBean")
	private List<TimeLine> timeLines;

	//bi-directional many-to-one association to ChannelsAdDiv
	@OneToMany(mappedBy="channelBean")
	private List<ChannelsAdDiv> channelsAdDivs;

	public Channel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannelBgImage() {
		return this.channelBgImage;
	}

	public void setChannelBgImage(String channelBgImage) {
		this.channelBgImage = channelBgImage;
	}

	public String getChannelImage() {
		return this.channelImage;
	}

	public void setChannelImage(String channelImage) {
		this.channelImage = channelImage;
	}

	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getLiveStreamingUrl() {
		return this.liveStreamingUrl;
	}

	public void setLiveStreamingUrl(String liveStreamingUrl) {
		this.liveStreamingUrl = liveStreamingUrl;
	}

	public List<Carousel> getCarousels() {
		return this.carousels;
	}

	public void setCarousels(List<Carousel> carousels) {
		this.carousels = carousels;
	}

	public Carousel addCarousel(Carousel carousel) {
		getCarousels().add(carousel);
		carousel.setChannelBean(this);

		return carousel;
	}

	public Carousel removeCarousel(Carousel carousel) {
		getCarousels().remove(carousel);
		carousel.setChannelBean(null);

		return carousel;
	}

	public List<NewsCategory> getNewsCategories() {
		return this.newsCategories;
	}

	public void setNewsCategories(List<NewsCategory> newsCategories) {
		this.newsCategories = newsCategories;
	}

	public NewsCategory addNewsCategory(NewsCategory newsCategory) {
		getNewsCategories().add(newsCategory);
		newsCategory.setChannelBean(this);

		return newsCategory;
	}

	public NewsCategory removeNewsCategory(NewsCategory newsCategory) {
		getNewsCategories().remove(newsCategory);
		newsCategory.setChannelBean(null);

		return newsCategory;
	}

	public List<Program> getPrograms() {
		return this.programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	public Program addProgram(Program program) {
		getPrograms().add(program);
		program.setChannelBean(this);

		return program;
	}

	public Program removeProgram(Program program) {
		getPrograms().remove(program);
		program.setChannelBean(null);

		return program;
	}

	public List<TimeLine> getTimeLines() {
		return this.timeLines;
	}

	public void setTimeLines(List<TimeLine> timeLines) {
		this.timeLines = timeLines;
	}

	public TimeLine addTimeLine(TimeLine timeLine) {
		getTimeLines().add(timeLine);
		timeLine.setChannelBean(this);

		return timeLine;
	}

	public TimeLine removeTimeLine(TimeLine timeLine) {
		getTimeLines().remove(timeLine);
		timeLine.setChannelBean(null);

		return timeLine;
	}

	public List<ChannelsAdDiv> getChannelsAdDivs() {
		return this.channelsAdDivs;
	}

	public void setChannelsAdDivs(List<ChannelsAdDiv> channelsAdDivs) {
		this.channelsAdDivs = channelsAdDivs;
	}

	public ChannelsAdDiv addChannelsAdDiv(ChannelsAdDiv channelsAdDiv) {
		getChannelsAdDivs().add(channelsAdDiv);
		channelsAdDiv.setChannelBean(this);

		return channelsAdDiv;
	}

	public ChannelsAdDiv removeChannelsAdDiv(ChannelsAdDiv channelsAdDiv) {
		getChannelsAdDivs().remove(channelsAdDiv);
		channelsAdDiv.setChannelBean(null);

		return channelsAdDiv;
	}

}