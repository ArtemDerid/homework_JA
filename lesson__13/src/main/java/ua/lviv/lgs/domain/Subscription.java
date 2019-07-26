package ua.lviv.lgs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subscription")
public class Subscription {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="magazine_catalog_id", referencedColumnName="id")
	private Magazine magazine;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	public Subscription() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((magazine == null) ? 0 : magazine.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		if (id != other.id)
			return false;
		if (magazine == null) {
			if (other.magazine != null)
				return false;
		} else if (!magazine.equals(other.magazine))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", user=" + user + ", magazine=" + magazine + ", releaseDate=" + releaseDate
				+ "]";
	}

}
