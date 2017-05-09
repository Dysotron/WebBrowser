import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SetAsHomeListener implements ActionListener
{
	private WebBrowserPane page;
	
	public SetAsHomeListener(WebBrowserPane page)
	{
		this.page = page;
	}

	public void actionPerformed(ActionEvent e)
	{
		page.setHome(page.getPage());
	}
}
