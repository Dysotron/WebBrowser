import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReloadListener implements ActionListener
{
	private WebBrowserPane page;
	
	public ReloadListener(WebBrowserPane page)
	{
		this.page = page;
	}

	public void actionPerformed(ActionEvent e)
	{
		page.reload();
	}

}
