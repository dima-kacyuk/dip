package game.apeiron.models;

public class Character {
	private String name;
	private String torso;
	private String shoulders;
	private String pants;
	private String hat;
	private String gloves;
	private String boots;
	private String quiver;
	private String belt;
	private String bodyType;

	public Character() {
	}

	public Character(User user) {
		this.name = user.getLogin();
		this.torso = user.getTorso().name();
		this.shoulders = user.getShoulders().name();
		this.pants = user.getPants().name();
		this.hat = user.getHat().name();
		this.gloves = user.getGloves().name();
		this.boots = user.getBoots().name();
		this.quiver = user.getQuiver().name();
		this.belt = user.getBelt().name();
		this.bodyType = user.getBodyType().name();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTorso() {
		return torso;
	}

	public void setTorso(String torso) {
		this.torso = torso;
	}

	public String getShoulders() {
		return shoulders;
	}

	public void setShoulders(String shoulders) {
		this.shoulders = shoulders;
	}

	public String getPants() {
		return pants;
	}

	public void setPants(String pants) {
		this.pants = pants;
	}

	public String getHat() {
		return hat;
	}

	public void setHat(String hat) {
		this.hat = hat;
	}

	public String getGloves() {
		return gloves;
	}

	public void setGloves(String gloves) {
		this.gloves = gloves;
	}

	public String getBoots() {
		return boots;
	}

	public void setBoots(String boots) {
		this.boots = boots;
	}

	public String getQuiver() {
		return quiver;
	}

	public void setQuiver(String quiver) {
		this.quiver = quiver;
	}

	public String getBelt() {
		return belt;
	}

	public void setBelt(String belt) {
		this.belt = belt;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
}