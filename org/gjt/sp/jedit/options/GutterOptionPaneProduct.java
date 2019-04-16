package org.gjt.sp.jedit.options;


import javax.swing.JComboBox;
import org.gjt.sp.jedit.ServiceManager;
import org.gjt.sp.jedit.textarea.JEditTextArea;
import org.gjt.sp.jedit.jEdit;
import javax.swing.JLabel;
import java.io.Serializable;

public class GutterOptionPaneProduct implements Serializable {
	private JComboBox<String> foldPainter;
	private String[] painters;

	public JComboBox<String> getFoldPainter() {
		return foldPainter;
	}

	public String[] getPainters() {
		return painters;
	}

	public void addFoldStyleChooser(GutterOptionPane gutterOptionPane) {
		painters = ServiceManager.getServiceNames(JEditTextArea.FOLD_PAINTER_SERVICE);
		foldPainter = new JComboBox<String>();
		String current = JEditTextArea.getFoldPainterName();
		int selected = 0;
		for (int i = 0; i < painters.length; i++) {
			String painter = painters[i];
			foldPainter.addItem(jEdit.getProperty("options.gutter.foldStyleNames." + painter, painter));
			if (painter.equals(current))
				selected = i;
		}
		foldPainter.setSelectedIndex(selected);
		gutterOptionPane.addComponent(new JLabel(jEdit.getProperty("options.gutter.foldStyle.label")), foldPainter);
	}
}