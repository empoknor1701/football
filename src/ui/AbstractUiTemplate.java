package ui;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi {
	public void show() {
		this.showMenu();
		String inputedString = this.getInputedString();
		if (this.isValidNumber(inputedString)) {
			this.execute(NumberUtils.toInt(inputedString));
		}
	}

	abstract protected void showMenu();
	abstract protected int getMaxMenuNumber();
	abstract protected int getMinMenuNumber();
	abstract protected void execute(int number);

	protected boolean isValidNumber(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		} else if (!StringUtils.isNumeric(str)) {
			return false;
		}
		int number = NumberUtils.toInt(str);
		if (this.getMinMenuNumber() <= number && number <= this.getMaxMenuNumber()) {
			return true;
		}
		return false;
	}
}

