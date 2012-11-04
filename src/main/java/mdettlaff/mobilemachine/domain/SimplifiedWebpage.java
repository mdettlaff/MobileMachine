package mdettlaff.mobilemachine.domain;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedWebpage {

	private final String title;
	private final List<String> pages;

	public SimplifiedWebpage(String title, List<String> pages) {
		this.title = title;
		this.pages = new ArrayList<String>(pages);
	}

	public String getTitle() {
		return title;
	}

	public String getPage(int pageNumber) {
		return pages.get(pageNumber - 1);
	}

	public int getPageCount() {
		return pages.size();
	}
}
