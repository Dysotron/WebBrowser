import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class AddToBookmarksListener implements ActionListener
{
	private WebBrowserPane page;
	
	public AddToBookmarksListener(WebBrowserPane page)
	{
		this.page = page;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		page.addToBookmarks(page.getPage());
	}

}
