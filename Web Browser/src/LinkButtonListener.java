import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

public class LinkButtonListener implements ActionListener
{
	private URL url;
	private WebBrowserPane page;
	
	public LinkButtonListener(URL url, WebBrowserPane page)
	{
		this.page = page;
		this.url = url;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		page.moveWebPageForwards(url);
	}

}
