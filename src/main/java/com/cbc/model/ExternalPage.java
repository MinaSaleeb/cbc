package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the external_pages database table.
 * 
 */
@Entity
@Table(name="external_pages")
@NamedQuery(name="ExternalPage.findAll", query="SELECT e FROM ExternalPage e")
public class ExternalPage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	@Column(name="ad_script_1")
	private String adScript1;

	@Lob
	@Column(name="ad_script_2")
	private String adScript2;

	@Lob
	@Column(name="ad_script_3")
	private String adScript3;

	@Column(name="answer_1")
	private String answer1;

	@Column(name="answer_2")
	private String answer2;

	@Column(name="answer_3")
	private String answer3;

	@Column(name="answer_4")
	private String answer4;

	@Column(name="bg_image")
	private String bgImage;

	@Column(name="company_name")
	private String companyName;

	@Column(name="hint_text")
	private String hintText;

	private String question;

	public ExternalPage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdScript1() {
		return this.adScript1;
	}

	public void setAdScript1(String adScript1) {
		this.adScript1 = adScript1;
	}

	public String getAdScript2() {
		return this.adScript2;
	}

	public void setAdScript2(String adScript2) {
		this.adScript2 = adScript2;
	}

	public String getAdScript3() {
		return this.adScript3;
	}

	public void setAdScript3(String adScript3) {
		this.adScript3 = adScript3;
	}

	public String getAnswer1() {
		return this.answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return this.answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return this.answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return this.answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getBgImage() {
		return this.bgImage;
	}

	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getHintText() {
		return this.hintText;
	}

	public void setHintText(String hintText) {
		this.hintText = hintText;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}