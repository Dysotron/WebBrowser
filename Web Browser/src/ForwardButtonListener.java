import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JTextField;

public class ForwardButtonListener implements ActionListener
{
	private WebBrowserPane page;
	
	public ForwardButtonListener(WebBrowserPane page, JTextField text)
	{
		this.page = page;
	}

	public void actionPerformed(ActionEvent e)
	{
		if(page.getForwardStack().empty() == false)
		{
			page.addToBack(page.getPage());
			page.updateWebPage(page.popFromForward());
		}
	}

}
