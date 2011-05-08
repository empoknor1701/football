package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Player;

public interface PlayerDao {
	void insertPlayer(Player player) throws DataAccessException;
	List getPlayerList(Integer teamId);
}
