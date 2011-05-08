package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UpdatePlayer extends SqlUpdate{
	private static String SQL_UPDATE_PLAYER = "UPDATE player SET name = ?, team_id = ? WHERE player_id = ?";
	
	public UpdatePlayer(DataSource dataSource) {
		super(dataSource, SQL_UPDATE_PLAYER);
		super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
		compile();
	}
}
