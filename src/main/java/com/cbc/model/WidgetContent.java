package com.cbc.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Mina Saleeb
 *
 */
@Entity
@Table(name="widget_contents")
public class WidgetContent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Lob
	@Column(name="html_content")
	private String htmlContent;
	
	@Column(name="content_url")
	private String contentUrl;
	
	@Column(name="content_url_type")
	private String contentUrlType;	
	
	@ManyToOne
	@JoinColumn(name="widget_id")
	private Widget widgetBean;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the htmlContent
	 */
	public String getHtmlContent() {
		return htmlContent;
	}

	/**
	 * @param htmlContent the htmlContent to set
	 */
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	/**
	 * @return the contentUrl
	 */
	public String getContentUrl() {
		return contentUrl;
	}

	/**
	 * @param contentUrl the contentUrl to set
	 */
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	/**
	 * @return the contentUrlType
	 */
	public String getContentUrlType() {
		return contentUrlType;
	}

	/**
	 * @param contentUrlType the contentUrlType to set
	 */
	public void setContentUrlType(String contentUrlType) {
		this.contentUrlType = contentUrlType;
	}

	/**
	 * @return the widgetBean
	 */
	public Widget getWidgetBean() {
		return widgetBean;
	}

	/**
	 * @param widgetBean the widgetBean to set
	 */
	public void setWidgetBean(Widget widgetBean) {
		this.widgetBean = widgetBean;
	}

}
