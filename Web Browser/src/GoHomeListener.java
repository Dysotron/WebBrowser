import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GoHomeListener implements ActionListener
{
	private WebBrowserPane page;;
	
	public GoHomeListener(WebBrowserPane page, JTextField text)
	{
		this.page = page;
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			page.moveWebPageForwards(page.getHome());
		} 
		
		catch (MalformedURLException e1)
		{
			JOptionPane.showMessageDialog(null, "There was a problem going home");
		}
	}

}
