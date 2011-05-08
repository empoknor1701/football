package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class InsertPlayer extends SqlUpdate{

	public InsertPlayer(DataSource dataSource) {
		super(dataSource, "INSERT INTO player(name, team_id) VALUES(?, ?)");
		super.declareParameter(new SqlParameter("name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("team_id", Types.INTEGER));
		compile();
	}
}
