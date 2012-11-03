package mdettlaff.mobilemachine.service;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class HttpService {

	public String download(String url) throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		try {
			HttpResponse response = client.execute(new HttpGet(url));
			return EntityUtils.toString(response.getEntity());
		} finally {
			client.getConnectionManager().shutdown();
		}
	}
}
