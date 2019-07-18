package game.apeiron.models;

public enum Role {
	USER, TESTER, ADMIN, BANNED;

	@Override
	public String toString() {
		return name();
	}
}