package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the programs database table.
 * 
 */
@Entity
@Table(name="programs")
public class Program implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	@Column(name="image_1x_path")
	private String image1xPath;

	@Column(name="image_2x_path")
	private String image2xPath;

	@Column(name="image_bg_path")
	private String imageBgPath;

	@Column(name="image_x_path")
	private String imageXPath;

	@Column(name="recipe_rating_image_path")
	private String recipeRatingImagePath;

	private String title;
	
	@Column(name="hub_selected")
	private boolean hubSelected;
	
	private String schedule;
	
	@Column(name="program_type")
	private String type;
	
	@Column(name="on_air")
	private boolean onAir;
	
	//bi-directional many-to-many association to Channel
	@ManyToMany
	@JoinTable(name = "programs_channels", joinColumns = { @JoinColumn(name = "program") }, inverseJoinColumns = {
			@JoinColumn(name = "channel") })
	private List<Channel> channels;

/*
	//bi-directional many-to-many association to ProgramPage
	@ManyToMany
	@JoinTable(name = "programs_site_pages", joinColumns = { @JoinColumn(name = "program") }, inverseJoinColumns = {
			@JoinColumn(name = "page_code") })
	private List<ProgramPage> programPages;
*/
	//bi-directional many-to-one association to ProgramPromo
	
	//bi-directional many-to-one association to ProgramsAdDiv
	@OneToMany(mappedBy="programBean")
	private List<ProgramsAdDiv> programsAdDivs;
	
	//bi-directional many-to-many association to Presenter
	@ManyToMany
	@JoinTable(
		name="programs_presenters"
		, joinColumns={
			@JoinColumn(name="program")
			}
		, inverseJoinColumns={
			@JoinColumn(name="presenter")
			}
		)
	private List<Presenter> presenters;
	
	@Column(name="hide_program")
	private boolean hideProgram;

	public Program() {
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

	public String getImage1xPath() {
		return this.image1xPath;
	}

	public void setImage1xPath(String image1xPath) {
		this.image1xPath = image1xPath;
	}

	public String getImage2xPath() {
		return this.image2xPath;
	}

	public void setImage2xPath(String image2xPath) {
		this.image2xPath = image2xPath;
	}

	public String getImageBgPath() {
		return this.imageBgPath;
	}

	public void setImageBgPath(String imageBgPath) {
		this.imageBgPath = imageBgPath;
	}

	public String getImageXPath() {
		return this.imageXPath;
	}

	public void setImageXPath(String imageXPath) {
		this.imageXPath = imageXPath;
	}

	public String getRecipeRatingImagePath() {
		return this.recipeRatingImagePath;
	}

	public void setRecipeRatingImagePath(String recipeRatingImagePath) {
		this.recipeRatingImagePath = recipeRatingImagePath;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the hubSelected
	 */
	public boolean isHubSelected() {
		return hubSelected;
	}

	/**
	 * @param hubSelected the hubSelected to set
	 */
	public void setHubSelected(boolean hubSelected) {
		this.hubSelected = hubSelected;
	}

	/**
	 * @return the schedule
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * @param schedule the schedule to set
	 */
	public void setSchedule(String schedule) {
		this.schedule = schedule;
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

	/**
	 * @return the onAir
	 */
	public boolean isOnAir() {
		return onAir;
	}

	/**
	 * @param onAir the onAir to set
	 */
	public void setOnAir(boolean onAir) {
		this.onAir = onAir;
	}

	public List<Channel> getChannels() {
		return this.channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

/*
	public List<ProgramPage> getProgramPages() {
		return this.programPages;
	}

	public void setProgramPages(List<ProgramPage> programPages) {
		this.programPages = programPages;
	}
*/

	public List<ProgramsAdDiv> getProgramsAdDivs() {
		return this.programsAdDivs;
	}

	public void setProgramsAdDivs(List<ProgramsAdDiv> programsAdDivs) {
		this.programsAdDivs = programsAdDivs;
	}

	public ProgramsAdDiv addProgramsAdDiv(ProgramsAdDiv programsAdDiv) {
		getProgramsAdDivs().add(programsAdDiv);
		programsAdDiv.setProgramBean(this);

		return programsAdDiv;
	}

	public ProgramsAdDiv removeProgramsAdDiv(ProgramsAdDiv programsAdDiv) {
		getProgramsAdDivs().remove(programsAdDiv);
		programsAdDiv.setProgramBean(null);

		return programsAdDiv;
	}

	public List<Presenter> getPresenters() {
		return this.presenters;
	}

	public void setPresenters(List<Presenter> presenters) {
		this.presenters = presenters;
	}

	/**
	 * @return the hideProgram
	 */
	public boolean isHideProgram() {
		return hideProgram;
	}

	/**
	 * @param hideProgram the hideProgram to set
	 */
	public void setHideProgram(boolean hideProgram) {
		this.hideProgram = hideProgram;
	}

}