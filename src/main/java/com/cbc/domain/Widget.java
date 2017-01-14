/**
 * 
 */
package com.cbc.domain;

import java.util.List;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina
 *
 */
public class Widget {

	private int id;
	
	private String name;
	
	private String type;
	
	private String image;
	
	private List<WidgetContent> widgetContents;
	
	public Widget(com.cbc.model.Widget w) 
	{
		super();
		ModelToDomainMapper.mapWidget(w, this);
	}

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
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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
