package ui;


import model.Player;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;

public class DeletePlayerUi extends AbstractUi {

	private PlayerDao playerDao;
	
	@Override
	public void show() {
		this.showMenu();
		String id = this.getInputedString();
		if (StringUtils.isEmpty(id)) {
			return;
		} else if (UiUtils.isNumeric(id, "選手ID")) {
			Player player = this.playerDao.getPlayer(Integer.parseInt(id));
			if (player == null) {
				System.out.println("入力された選手ID「" + id + "」の選手は存在しません。");
				this.show();
			} else {
				this.playerDao.deletePlayer(player);
				System.out.println("選手ID「" + id + "」の選手を削除しました。");
			}
		} else {
			this.show();
		}
		
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	private void showMenu() {
		System.out.println("=========================");
		System.out.println("選手名鑑: 選手削除");
		System.out.println("");
		System.out.println("選手IDを入力し、ENTERを押してください。");
		System.out.println("ENTERの空打ちでメニューに戻ります。");
	}

}
