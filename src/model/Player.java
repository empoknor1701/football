package model;

public class Player {
	private Integer id;
	private String name;
	private Team team;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
