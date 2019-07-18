package game.apeiron.models;

import java.util.Collection;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	protected long id;
	private String login;
	private String email;
	private String password;
	private Integer age;
	private String country;
	private String gender;
	private int gamesCount;
	private Integer winsCount;
	private Integer rating;

	@ElementCollection(targetClass = Role.class)
	@Enumerated(EnumType.ORDINAL)
	@CollectionTable(name = "user_role")
	@Column(name = "role")
	private Collection<Role> roles;

	@Enumerated(EnumType.ORDINAL)
	private Torso torso = Torso.ROBE;
	@Enumerated(EnumType.ORDINAL)
	private Shoulders shoulders = Shoulders.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private Pants pants = Pants.SKIRT;
	@Enumerated(EnumType.ORDINAL)
	private Hat hat = Hat.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private Gloves gloves = Gloves.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private Boots boots = Boots.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private Quiver quiver = Quiver.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private Belt belt = Belt.MISSING;
	@Enumerated(EnumType.ORDINAL)
	private BodyType bodyType = BodyType.SKELETON;

	public void setGamesCount(int gamesCount) {
		this.gamesCount = gamesCount;
	}

	public long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Integer getWinsCount() {
		return winsCount;
	}

	public void setWinsCount(Integer winsCount) {
		this.winsCount = winsCount;
	}

	public Integer getGamesCount() {
		return gamesCount;
	}

	public void setGamesCount(Integer gamesCount) {
		this.gamesCount = gamesCount;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Torso getTorso() {
		return torso;
	}

	public void setTorso(Torso torso) {
		this.torso = torso;
	}

	public Shoulders getShoulders() {
		return shoulders;
	}

	public void setShoulders(Shoulders shoulders) {
		this.shoulders = shoulders;
	}

	public Pants getPants() {
		return pants;
	}

	public void setPants(Pants pants) {
		this.pants = pants;
	}

	public Hat getHat() {
		return hat;
	}

	public void setHat(Hat hat) {
		this.hat = hat;
	}

	public Gloves getGloves() {
		return gloves;
	}

	public void setGloves(Gloves gloves) {
		this.gloves = gloves;
	}

	public Boots getBoots() {
		return boots;
	}

	public void setBoots(Boots boots) {
		this.boots = boots;
	}

	public Quiver getQuiver() {
		return quiver;
	}

	public void setQuiver(Quiver quiver) {
		this.quiver = quiver;
	}

	public Belt getBelt() {
		return belt;
	}

	public void setBelt(Belt belt) {
		this.belt = belt;
	}

	public BodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}
}

enum Torso {
	ROBE, LEATHER, ARMORED, SHIRT, MAIL
}

enum Shoulders {
	MISSING, ARMORED, LEATHER
}

enum Pants {
	SKIRT, GREEN, ARMORED
}

enum Hat {
	MISSING, USUAL, MAIL, BLONDHAIR, HAT, ARMORED, HOOD
}

enum Gloves {
	MISSING, ARMORED
}

enum Boots {
	MISSING, ARMORED, LEATHER
}

enum Quiver {
	MISSING, USUAL
}

enum Belt {
	LEATHER, ROPE, MISSING
}

enum BodyType {
	SKELETON, HUMAN
}