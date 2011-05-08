package dao;

import org.springframework.dao.DataAccessException;

import model.Player;

public interface PlayerDao {
	void insertPlayer(Player player) throws DataAccessException;
}
