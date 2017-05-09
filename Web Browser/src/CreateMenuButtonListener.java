import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreateMenuButtonListener implements ActionListener
{
	private List<URL> list = null;
	private JButton[] buttons = null;
	private JPanel panel;
	private WebBrowserPane page;
	private JFrame frame;

	public CreateMenuButtonListener(JPanel panel, List list, WebBrowserPane page, JFrame frame)
	{
		this.frame = frame;
		this.panel = panel;
		this.page = page;
		this.list = list;
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		panel.removeAll();
		buttons = new JButton[list.size()];
		
		for(int i = 0; i < list.size(); i++)
		{
			buttons[i] = new JButton(list.get(i).toString());
			panel.add(buttons[i]);
			//add button listener
			ActionListener listener = new LinkButtonListener(list.get(i), page);
			buttons[i].addActionListener(listener);
		}
		frame.setVisible(true);
	}
}
