import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchActionListener implements ActionListener
{
	private JTextField text;
	private WebBrowserPane page;
	public SearchActionListener(JTextField text, WebBrowserPane page)
	{
		this.text = text;
		this.page = page;
	}

	public void actionPerformed(ActionEvent arg0)
	{
		String current = text.getText();
		URL next = null;
		try
		{
			next = new URL(current);
			page.moveWebPageForwards(next);
		} 
		
		catch (MalformedURLException e1)
		{
			JOptionPane.showMessageDialog(null, "That URL is not valid");
		}
	}

}
