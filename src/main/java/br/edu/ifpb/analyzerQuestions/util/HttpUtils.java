package br.edu.ifpb.analyzerQuestions.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 
 * classe utilitária para acesso a conteudo de paginas
 * 
 * @author franck
 *
 */
public class HttpUtils {
	private static String inputLine;
	private static URL sUrl;

	/**
	 * obtém todo conteudo html de uma pagina
	 * 
	 * @param url
	 * @return
	 */
	public static String getPageContent(String url) {
		try {
			sUrl = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(sUrl.openStream()));

			while (in.readLine() != null) {
				inputLine += in.readLine();
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String s0 = StringUtil.removerTagsHtml(inputLine);
		return s0;
	}

	/**
	 * 
	 * @param url
	 *            link request
	 * @param tag
	 *            tag html [code, body, tr, header...]
	 * 
	 * @return conteudo da tag em formato de String
	 */
	public static String getContentPageByTag(String url, String tag) {
		String content = "Alguma exceção lançada no met. getPageByTag";

		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		ResponseHandler<String> handler = new BasicResponseHandler();

		try {
			content = client.execute(httpGet, handler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Document doc = Jsoup.parse(content);
		Elements elements = doc.getElementsByTag(tag);

		return elements.toString();
	}
}
