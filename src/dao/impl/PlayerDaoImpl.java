package dao.impl;

import model.Player;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.PlayerDao;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao{
	private InsertPlayer insertPlayer;
	
	protected void initDao() throws Exception {
		this.insertPlayer = new InsertPlayer(getDataSource());
	}
	@Override
	public void insertPlayer(Player player) throws DataAccessException {
		this.insertPlayer.update(new Object[] { player.getName(), player.getTeam().getId() });
	}
}