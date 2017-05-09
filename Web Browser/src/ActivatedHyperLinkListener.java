import java.io.IOException;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

class ActivatedHyperlinkListener implements HyperlinkListener 
{
	  WebBrowserPane page; // new WebBrowserPane called page

	  public ActivatedHyperlinkListener(WebBrowserPane page) 
	  {
	    this.page = page; // don't need to make page an object above as it is assigned one here
	  }

	  public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent) // method to update web page displayed if a hyperlink is clicked 
	  {
	    HyperlinkEvent.EventType type = hyperlinkEvent.getEventType(); //creates a variable to store how the user interacts with the hyperlink (ACTIVATED == clicked, ENTERED == hovered over etc.)
	    final URL url = hyperlinkEvent.getURL();  //stores the URL of the hyperlink
	    
	    if (type == HyperlinkEvent.EventType.ACTIVATED) //if the hyperlink is clicked
	    {
	        page.moveWebPageForwards(url); // sets the page of the editor pane to equal the URL that was obtained from the hyperlink
	    }
	  }
}
