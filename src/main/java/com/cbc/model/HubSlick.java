package com.cbc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the hub_slicks database table.
 * 
 */
@Entity
@Table(name="hub_slicks")
public class HubSlick implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String title;
	
	@OneToMany(mappedBy = "hubSlick")
	private List<Episode> episodes;
	
	@OneToMany(mappedBy = "hubSlick")
	private List<ProgramScene> programScenes;
	
	@OneToMany(mappedBy = "hubSlick")
	private List<Program> programs;
	
	@OneToMany(mappedBy = "hubSlick")
	private List<ProgramPromo> promos;

	public HubSlick() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the episodes
	 */
	public List<Episode> getEpisodes() {
		return episodes;
	}

	/**
	 * @param episodes the episodes to set
	 */
	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	/**
	 * @return the programScenes
	 */
	public List<ProgramScene> getProgramScenes() {
		return programScenes;
	}

	/**
	 * @param programScenes the programScenes to set
	 */
	public void setProgramScenes(List<ProgramScene> programScenes) {
		this.programScenes = programScenes;
	}

	/**
	 * @return the programs
	 */
	public List<Program> getPrograms() {
		return programs;
	}

	/**
	 * @param programs the programs to set
	 */
	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	/**
	 * @return the promos
	 */
	public List<ProgramPromo> getPromos() {
		return promos;
	}

	/**
	 * @param promos the promos to set
	 */
	public void setPromos(List<ProgramPromo> promos) {
		this.promos = promos;
	}

}