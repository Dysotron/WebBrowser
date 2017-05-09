import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import ListStack.ListStack;
import ListStack.Stack;

public class Layout
{
	public static void main(String[] args) throws MalformedURLException
	{
		new Layout();
	}
	
	public Layout() throws MalformedURLException
	{
		
		
		JButton back = new JButton("<");
		JButton forward = new JButton(">");
		JButton reload = new JButton("Reload");
		JButton search = new JButton("Search");
		JButton home = new JButton("Home");
		JButton setAsHome = new JButton("Set As Home");
		JButton bookmarks = new JButton("Bookmarks");
		JButton addToBookmarks = new JButton("Add Bookmark");
		JButton history = new JButton("History");
		
		JTextField urlBar = new JTextField(75);
		WebBrowserPane page = new WebBrowserPane(urlBar);
		
		JPanel toolbar = new JPanel(new FlowLayout());
		toolbar.add(back);
		toolbar.add(forward);
		toolbar.add(reload);
		toolbar.add(urlBar);
		toolbar.add(search);
		toolbar.add(home);
		toolbar.add(setAsHome);
		toolbar.add(bookmarks);
		toolbar.add(addToBookmarks);
		toolbar.add(history);
		
		JPanel webPanel = new JPanel(new BorderLayout());
		webPanel.add(toolbar, BorderLayout.PAGE_START);
		webPanel.add(page);
		
		JPanel historyPanel = new JPanel();
		historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.Y_AXIS));
		
		JPanel bookmarkPanel = new JPanel();
		bookmarkPanel.setLayout(new BoxLayout(bookmarkPanel, BoxLayout.Y_AXIS));
		
		JScrollPane webScroll = new JScrollPane(webPanel);
		JScrollPane historyScroll = new JScrollPane(historyPanel);
		JScrollPane bookmarkScroll = new JScrollPane(bookmarkPanel);
		
		JFrame webFrame = new JFrame("Web");
	    webFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    webFrame.getContentPane().add(webScroll);
	    webFrame.setSize(1800, 1000);
	    webFrame.setVisible(true);
	    
	    JFrame historyFrame = new JFrame("History");
	    historyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    historyFrame.getContentPane().add(historyScroll);
	    historyFrame.setSize(400, 1000);
	    
	    JFrame bookmarkFrame = new JFrame("Bookmark");
	    bookmarkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    bookmarkFrame.getContentPane().add(bookmarkScroll);
	    bookmarkFrame.setSize(400, 1000);
		
		ActionListener forwardListener = new ForwardButtonListener(page, urlBar);
		forward.addActionListener(forwardListener);
		
		ActionListener backListener = new BackButtonListener(page, urlBar);
		back.addActionListener(backListener);

		ActionListener reloadListener = new ReloadListener(page);
		reload.addActionListener(reloadListener);
		
		ActionListener searchListener = new SearchActionListener(urlBar, page);
		search.addActionListener(searchListener);
		
		ActionListener goHomeListener = new GoHomeListener(page, urlBar);
		home.addActionListener(goHomeListener);
		
		ActionListener setAsHomeListener = new SetAsHomeListener(page);
		setAsHome.addActionListener(setAsHomeListener);
		
		ActionListener bookmarksButtonListener = new CreateMenuButtonListener(bookmarkPanel, page.getBookmarks(), page, bookmarkFrame);
		bookmarks.addActionListener(bookmarksButtonListener);
		
		ActionListener addToBookmarksListener = new AddToBookmarksListener(page);
		addToBookmarks.addActionListener(addToBookmarksListener);
		
		ActionListener historyButtonListener = new CreateMenuButtonListener(historyPanel, page.getHistory(), page, historyFrame);
		history.addActionListener(historyButtonListener); 
	}
}
