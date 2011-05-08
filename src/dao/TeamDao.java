package dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

public interface TeamDao {
	List getTeamList() throws DataAccessException;
}
