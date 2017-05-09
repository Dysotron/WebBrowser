import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import ListStack.ListStack;
import ListStack.Stack;

public class WebBrowserPane extends JEditorPane
{	
	private Stack <URL> backStack = new ListStack <URL>();
	private Stack <URL> forwardStack = new ListStack <URL>();
	private List<URL> history = new ArrayList<URL> ();
	private List<URL> bookmarks = new ArrayList<URL> ();
	private URL home = null;
	private JTextField text;
	
	public WebBrowserPane(JTextField text) throws MalformedURLException 
	{
		this.text = text;
		initialiseHome();
		updateWebPage(home);
		addHyperLink();
		setEditable(false);
	}
	
	public void reload()
	{
		try
		{
			URL current = getPage();
			setPage(current);
		} 
		
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "cannot load this webpage");
		}
	}
	
	public void updateWebPage(URL url)
	{
		try
		{
			addToHistory(url);
			setPage(url);
			text.setText(url.toString());
		} 
		
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "cannot load this webpage");
		}
	}
	
	public void moveWebPageForwards(URL url) // whenever a link is clicked or a new address entered in the url bar, the current page needs to be added to the back stack, also clears forward stack as not relevant after going to a new link etc.
	{
		backStack.push(getPage());
		clearForwardStack();
		updateWebPage(url);
	}
	
	private void addHyperLink()
	{
		HyperlinkListener hyperlinkListener = new ActivatedHyperlinkListener(this); // new hyperlink listener object
	    addHyperlinkListener(hyperlinkListener); // add the hyperlink listener to the page, method from JEditor pane
	}
	
	private void addToHistory(URL current)
	{
		history.add(current);
		
		try
		{
			ObjectOutputStream historyOut = new ObjectOutputStream(new FileOutputStream("history.dat"));
			historyOut.writeObject(history);
		} 
		
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "There was a problem saving the history");
		} 
		
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "There was a problem saving the history");
		}
	}
	
	public void addToBookmarks(URL current)
	{
		bookmarks.add(current);
		
		try
		{
			ObjectOutputStream bookmarksOut = new ObjectOutputStream(new FileOutputStream("bookmarks.dat"));
			bookmarksOut.writeObject(bookmarks);
		} 
		
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "There was a problem saving the bookmarks");
		} 
		
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "There was a problem saving the bookmarks");
		}
	}
	
	public void addToBack(URL current)
	{
		backStack.push(current);
	}
	
	public void addToForward(URL current)
	{
		forwardStack.push(current);
	}
	
	public URL popFromBack()
	{
		return backStack.pop();
	}
	
	public URL popFromForward()
	{
		return forwardStack.pop();
	}
	
	public URL getHome() throws MalformedURLException //will read URL from text file and return, not final functionality
	{	
		try
		{
			ObjectInputStream homeIn = new ObjectInputStream(new FileInputStream("home.dat"));
			
			try
			{
				home = (URL) homeIn.readObject();
			} 
			
			catch (ClassNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, "There was a problem retrieving the homepage, a temporary home has been set");
			}
		} 
		
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "There was a problem retrieving the homepage, a temporary home has been set");
			home = new URL("http://google.co.uk");
		} 
		
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "There was a problem retrieving the homepage, a temporary home has been set");
			home = new URL("http://google.co.uk");
		}
		
		return home;
	}
	
	public void setHome(URL url)
	{
		home = url;
		
		try
		{
			ObjectOutputStream homeOut = new ObjectOutputStream(new FileOutputStream("home.dat"));
			homeOut.writeObject(home);
		} 
		
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "There was a problem setting the homepage");
		} 
		
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "There was a problem setting the homepage");
		}
	}
	
	public void initialiseHome() throws MalformedURLException
	{
		URL home = getHome();
		setHome(home);
	}
	
	public Stack<URL> getBackStack()
	{
		return backStack;
	}
	
	public Stack<URL> getForwardStack()
	{
		return forwardStack;
	}
	
	private void clearForwardStack()
	{
		while(forwardStack.empty() == false)
		{
			forwardStack.pop();
		}
	}

	public List<URL> getBookmarks()
	{
		try
		{
			ObjectInputStream bookmarksIn = new ObjectInputStream(new FileInputStream("bookmarks.dat"));
			
			try
			{
				bookmarks = (List<URL>) bookmarksIn.readObject();
			} 
			
			catch (ClassNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, "There was a problem retrieving bookmarks");
			}
		} 
		
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "No bookmarks file exists");
		} 
		
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "The bookmarks file could not be found");
		}
		
		return bookmarks;
	}
	
	public List<URL> getHistory()
	{
		try
		{
			ObjectInputStream historyIn = new ObjectInputStream(new FileInputStream("bookmarks.dat"));
			
			try
			{
				history = (List<URL>) historyIn.readObject();
			} 
			
			catch (ClassNotFoundException e)
			{
				JOptionPane.showMessageDialog(null, "There was a problem retrieving your history");
			}
		} 
		
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "No history file exists");
		} 
		
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "The history file could not be found");
		}
		
		return history;
	}

}
