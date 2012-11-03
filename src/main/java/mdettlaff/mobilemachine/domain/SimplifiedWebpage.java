package mdettlaff.mobilemachine.domain;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedWebpage {

	private final List<String> pages;

	public SimplifiedWebpage(List<String> pages) {
		this.pages = new ArrayList<String>(pages);
	}

	public String getPage(int pageNumber) {
		return pages.get(pageNumber);
	}
}
