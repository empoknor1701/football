package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Team;
import dao.TeamDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {
	public List getTeamList() throws DataAccessException {
		RowMapper rowMapper = new TeamRowMapper();
		return getJdbcTemplate().query("SELECT team_id, name FROM team", rowMapper);
	}

	protected class TeamRowMapper implements RowMapper {
		private List teamList = new ArrayList();

		public List getResults() {
			return teamList;
		}

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Team team = new Team();
			team.setId(rs.getInt("team_id"));
			team.setName(rs.getString("name"));
			return team;
		}
	}

}
