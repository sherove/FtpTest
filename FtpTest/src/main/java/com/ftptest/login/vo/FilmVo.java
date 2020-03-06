package com.ftptest.login.vo;

public class FilmVo extends BaseVo {
	private String filmId;
	private String title;
	private String description;
	private String releaseYear;
	private String rating;
	private String actorName;
	
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	private String actorId;
	private String firstName;
	private String lastName;
	private String lastUpdate;

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "FilmVo [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", rating=" + rating + ", actorName=" + actorName + ", actorId=" + actorId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate=" + lastUpdate + "]" 
				+ ", NowIdx=" + super.getNowIdx() 
				+ ", unitCnt=" + super.getUnitCnt()
				+ ", totcnt=" + super.getTotcnt();
	}
	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getFilmId() {
		return filmId;
	}
	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}
	
}
