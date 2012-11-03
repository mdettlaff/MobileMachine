package mdettlaff.mobilemachine.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import mdettlaff.mobilemachine.domain.SimplifiedWebpage;
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
		service = new PageSimplifierService(repository, httpService, 18000);
		webpageContent = IOUtils.toString(getClass().getResourceAsStream("DungeonKeeper.html"));
	}

	@Test
	public void testCreateSimplifiedWebpage_FirstPage() throws Exception {
		// Mock
		when(httpService.download(URL)).thenReturn(webpageContent);
		// Run
		SimplifiedWebpage result = service.createSimplifiedWebpage(URL);
		// Verify
		String expected = IOUtils.toString(getClass().getResourceAsStream("expected1.html"));
		assertEquals("Dungeon Keeper - Television Tropes &amp; Idioms  ", result.getTitle());
		assertEquals(expected, result.getPage(0));
	}

	@Test
	public void testCreateSimplifiedWebpage_MiddlePage() throws Exception {
		// Mock
		when(httpService.download(URL)).thenReturn(webpageContent);
		// Run
		SimplifiedWebpage result = service.createSimplifiedWebpage(URL);
		// Verify
		String expected = IOUtils.toString(getClass().getResourceAsStream("expected2.html"));
		assertEquals("Dungeon Keeper - Television Tropes &amp; Idioms  ", result.getTitle());
		assertEquals(expected, result.getPage(1));
	}

	@Test
	public void testCreateSimplifiedWebpage_LastPage() throws Exception {
		// Mock
		when(httpService.download(URL)).thenReturn(webpageContent);
		// Run
		SimplifiedWebpage result = service.createSimplifiedWebpage(URL);
		// Verify
		String expected = IOUtils.toString(getClass().getResourceAsStream("expected3.html"));
		assertEquals("Dungeon Keeper - Television Tropes &amp; Idioms  ", result.getTitle());
		assertEquals(expected, result.getPage(2));
	}
}
