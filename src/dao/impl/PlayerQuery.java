package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import model.Player;
import model.Team;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

public class PlayerQuery extends MappingSqlQuery {

	private static String SQL_PLAYER_LIST_QUERY = "SELECT player_id, player.name AS playerName, "
	                                              + " team.team_id, team.name AS teamName "
	                                              + " FROM player, team "
	                                              + " WHERE player.team_id = team.team_id AND player_id = ?";
	
	public PlayerQuery(DataSource dataSource) {
		super(dataSource, SQL_PLAYER_LIST_QUERY);
		super.declareParameter(new SqlParameter("team_id", Types.INTEGER));
		compile();
	}
	@Override 
	protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Player player = new Player();
		player.setId(rs.getInt("player_id"));
		player.setName(rs.getString("playerName"));
		Team team = new Team();
		team.setId(rs.getInt("team_id"));
		team.setName(rs.getString("teamName"));
		player.setTeam(team);
		
		return player;
	}

}
