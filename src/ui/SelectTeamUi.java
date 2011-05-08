package ui;

import java.util.Iterator;
import java.util.List;
import dao.TeamDao;
import model.Team;

public class SelectTeamUi extends AbstractUi {
	private TeamDao teamDao;

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void show() {
		this.showTeamList(this.teamDao.getTeamList());
		System.out.println("Enterを押してください");
		this.getInputedString();
	}

	protected void showTeamList(List teamList) {
		System.out.println("--------------------------");
		System.out.println("選手名鑑メニュー");
		System.out.println("ID		名前");
		for (Iterator iter = teamList.iterator(); iter.hasNext();) {
			Team team = (Team)iter.next();
			System.out.println(team.getId() + " " + team.getName());
		}
	}
}

