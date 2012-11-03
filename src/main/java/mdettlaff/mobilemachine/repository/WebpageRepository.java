package mdettlaff.mobilemachine.repository;

import java.util.HashMap;
import java.util.Map;

import mdettlaff.mobilemachine.domain.SimplifiedWebpage;

import org.springframework.stereotype.Component;

@Component
public class WebpageRepository {

	private static Map<String, SimplifiedWebpage> webpages = new HashMap<String, SimplifiedWebpage>();

	public SimplifiedWebpage getByUrl(String url) {
		return webpages.get(url);
	}
}
