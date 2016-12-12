package com.cbc.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Mina Saleeb
 *
 */
@Entity
@Table(name="widgets")
public class Widget implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy="widgetBean")
	private List<WidgetContent> widgetContents;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the widgetContents
	 */
	public List<WidgetContent> getWidgetContents() {
		return widgetContents;
	}

	/**
	 * @param widgetContents the widgetContents to set
	 */
	public void setWidgetContents(List<WidgetContent> widgetContents) {
		this.widgetContents = widgetContents;
	}
	
}
