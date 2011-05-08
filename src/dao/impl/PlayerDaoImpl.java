package dao.impl;

import java.util.List;

import model.Player;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import dao.PlayerDao;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao{
	private InsertPlayer insertPlayer;
	private PlayerListQuery playerListQuery;
	private PlayerQuery playerQuery;
	
	protected void initDao() throws Exception {
		this.insertPlayer = new InsertPlayer(getDataSource());
		this.playerListQuery = new PlayerListQuery(getDataSource());
	}
	@Override
	public void insertPlayer(Player player) throws DataAccessException {
		this.insertPlayer.update(new Object[] { player.getName(), player.getTeam().getId() });
	}
	@Override
	public List getPlayerList(Integer teamId) throws DataAccessException {
		return this.playerListQuery.execute(teamId);
	}
	@Override
	public Player getPlayer(Integer id) throws DataAccessException {
		return (Player) this.playerQuery.findObject(id);
	}
	
	
}