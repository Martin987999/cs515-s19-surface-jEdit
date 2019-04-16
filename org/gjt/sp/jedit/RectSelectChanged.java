package org.gjt.sp.jedit;


import org.gjt.sp.jedit.gui.StatusBar;


public class RectSelectChanged extends Flag {
	public void statusChanged(boolean value, StatusBar status) {
		status.setMessageAndClear(
				jEdit.getProperty("view.status.rect-select-changed", new Integer[] { value ? 1 : 0 }));
	}
}
