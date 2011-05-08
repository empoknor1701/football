package dao.impl;

import java.util.List;

import model.Player;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import dao.PlayerDao;
import dao.impl.DeletePlayer;
import dao.impl.InsertPlayer;
import dao.impl.PlayerListQuery;
import dao.impl.PlayerQuery;
import dao.impl.UpdatePlayer;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao{
	private InsertPlayer insertPlayer;
	private PlayerListQuery playerListQuery;
	private PlayerQuery playerQuery;
	private DeletePlayer deletePlayer;
	private UpdatePlayer updatePlayer;
	
	protected void initDao() throws Exception {
		this.insertPlayer = new InsertPlayer(getDataSource());
		this.playerListQuery = new PlayerListQuery(getDataSource());
		this.deletePlayer = new DeletePlayer(getDataSource());
		this.updatePlayer = new UpdatePlayer(getDataSource());
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
	
	@Override
	public void updatePlayer(Player player) throws DataAccessException {
		this.updatePlayer.update(new Object[] { player.getName(), player.getTeam().getId(), player.getId() });
	}
	
	@Override
	public void deletePlayer(Player player) throws DataAccessException {
		this.deletePlayer.update(player.getId());
	}
	
}