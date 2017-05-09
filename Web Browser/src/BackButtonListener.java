import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JTextField;

public class BackButtonListener implements ActionListener
{
	private WebBrowserPane page;
	public BackButtonListener(WebBrowserPane page, JTextField text)
	{
		this.page = page;
	}

	public void actionPerformed(ActionEvent e)
	{
		if(page.getBackStack().empty() == false)
		{
			page.addToForward(page.getPage());
			page.updateWebPage(page.popFromBack());
		}	
	}

}
