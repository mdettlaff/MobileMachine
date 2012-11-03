package mdettlaff.mobilemachine.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import mdettlaff.mobilemachine.repository.WebpageRepository;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class PageSimplifierServiceTest {

	private static final String URL = "http://tvtropes.org/pmwiki/pmwiki.php/VideoGame/DungeonKeeper";

	private PageSimplifierService service;

	private WebpageRepository repository;
	private HttpService httpService;

	private String webpageContent;

	@Before
	public void setUp() throws IOException {
		repository = mock(WebpageRepository.class);
		httpService = mock(HttpService.class);
		service = new PageSimplifierService(repository, httpService);
		webpageContent = IOUtils.toString(getClass().getResourceAsStream("DungeonKeeper.html"));
	}

	@Test
	public void testSimplify_FirstPage() throws Exception {
		// Mock
		when(httpService.download(URL)).thenReturn(webpageContent);
		// Run
		String result = service.simplify(URL, 0);
		// Verify
		String expected = IOUtils.toString(getClass().getResourceAsStream("expected1.html"));
		assertEquals(expected, result);
	}

	@Test
	public void testSimplify_MiddlePage() throws Exception {
		// Mock
		when(httpService.download(URL)).thenReturn(webpageContent);
		// Run
		String result = service.simplify(URL, 1);
		// Verify
		String expected = IOUtils.toString(getClass().getResourceAsStream("expected2.html"));
		assertEquals(expected, result);
	}

	@Test
	public void testSimplify_LastPage() throws Exception {
		// Mock
		when(httpService.download(URL)).thenReturn(webpageContent);
		// Run
		String result = service.simplify(URL, 2);
		// Verify
		String expected = IOUtils.toString(getClass().getResourceAsStream("expected3.html"));
		assertEquals(expected, result);
	}
}
