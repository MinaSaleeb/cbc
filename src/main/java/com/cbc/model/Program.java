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
	

	//bi-directional many-to-one association to Episode
	@OneToMany(mappedBy="programBean")
	private List<Episode> episodes;

	//bi-directional many-to-many association to Channel
	@ManyToMany
	@JoinTable(name = "programs_channels", joinColumns = { @JoinColumn(name = "program") }, inverseJoinColumns = {
			@JoinColumn(name = "channel") })
	private List<Channel> channels;

	//bi-directional many-to-one association to Recipe
	@OneToMany(mappedBy="programBean")
	private List<Recipe> recipes;

	//bi-directional many-to-one association to TimeLine
	@OneToMany(mappedBy="programBean")
	private List<TimeLine> timeLines;

	//bi-directional many-to-one association to ProgramCompitation
	@OneToMany(mappedBy="programBean")
	private List<ProgramCompitation> programCompitations;

	//bi-directional many-to-one association to ProgramNew
	@OneToMany(mappedBy="programBean")
	private List<ProgramNew> programNews;
/*
	//bi-directional many-to-many association to ProgramPage
	@ManyToMany
	@JoinTable(name = "programs_site_pages", joinColumns = { @JoinColumn(name = "program") }, inverseJoinColumns = {
			@JoinColumn(name = "page_code") })
	private List<ProgramPage> programPages;
*/
	//bi-directional many-to-one association to ProgramPromo
	@OneToMany(mappedBy="programBean")
	private List<ProgramPromo> programPromos;

	//bi-directional many-to-one association to ProgramScene
	@OneToMany(mappedBy="programBean")
	private List<ProgramScene> programScenes;

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

	public List<Episode> getEpisodes() {
		return this.episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	public Episode addEpisode(Episode episode) {
		getEpisodes().add(episode);
		episode.setProgramBean(this);

		return episode;
	}

	public Episode removeEpisode(Episode episode) {
		getEpisodes().remove(episode);
		episode.setProgramBean(null);

		return episode;
	}

	public List<Channel> getChannels() {
		return this.channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public Recipe addRecipe(Recipe recipe) {
		getRecipes().add(recipe);
		recipe.setProgramBean(this);

		return recipe;
	}

	public Recipe removeRecipe(Recipe recipe) {
		getRecipes().remove(recipe);
		recipe.setProgramBean(null);

		return recipe;
	}

	public List<TimeLine> getTimeLines() {
		return this.timeLines;
	}

	public void setTimeLines(List<TimeLine> timeLines) {
		this.timeLines = timeLines;
	}

	public TimeLine addTimeLine(TimeLine timeLine) {
		getTimeLines().add(timeLine);
		timeLine.setProgramBean(this);

		return timeLine;
	}

	public TimeLine removeTimeLine(TimeLine timeLine) {
		getTimeLines().remove(timeLine);
		timeLine.setProgramBean(null);

		return timeLine;
	}

	public List<ProgramCompitation> getProgramCompitations() {
		return this.programCompitations;
	}

	public void setProgramCompitations(List<ProgramCompitation> programCompitations) {
		this.programCompitations = programCompitations;
	}

	public ProgramCompitation addProgramCompitation(ProgramCompitation programCompitation) {
		getProgramCompitations().add(programCompitation);
		programCompitation.setProgramBean(this);

		return programCompitation;
	}

	public ProgramCompitation removeProgramCompitation(ProgramCompitation programCompitation) {
		getProgramCompitations().remove(programCompitation);
		programCompitation.setProgramBean(null);

		return programCompitation;
	}

	public List<ProgramNew> getProgramNews() {
		return this.programNews;
	}

	public void setProgramNews(List<ProgramNew> programNews) {
		this.programNews = programNews;
	}

	public ProgramNew addProgramNew(ProgramNew programNew) {
		getProgramNews().add(programNew);
		programNew.setProgramBean(this);

		return programNew;
	}

	public ProgramNew removeProgramNew(ProgramNew programNew) {
		getProgramNews().remove(programNew);
		programNew.setProgramBean(null);

		return programNew;
	}
/*
	public List<ProgramPage> getProgramPages() {
		return this.programPages;
	}

	public void setProgramPages(List<ProgramPage> programPages) {
		this.programPages = programPages;
	}
*/

	public List<ProgramPromo> getProgramPromos() {
		return this.programPromos;
	}

	public void setProgramPromos(List<ProgramPromo> programPromos) {
		this.programPromos = programPromos;
	}

	public ProgramPromo addProgramPromo(ProgramPromo programPromo) {
		getProgramPromos().add(programPromo);
		programPromo.setProgramBean(this);

		return programPromo;
	}

	public ProgramPromo removeProgramPromo(ProgramPromo programPromo) {
		getProgramPromos().remove(programPromo);
		programPromo.setProgramBean(null);

		return programPromo;
	}

	public List<ProgramScene> getProgramScenes() {
		return this.programScenes;
	}

	public void setProgramScenes(List<ProgramScene> programScenes) {
		this.programScenes = programScenes;
	}

	public ProgramScene addProgramScene(ProgramScene programScene) {
		getProgramScenes().add(programScene);
		programScene.setProgramBean(this);

		return programScene;
	}

	public ProgramScene removeProgramScene(ProgramScene programScene) {
		getProgramScenes().remove(programScene);
		programScene.setProgramBean(null);

		return programScene;
	}

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