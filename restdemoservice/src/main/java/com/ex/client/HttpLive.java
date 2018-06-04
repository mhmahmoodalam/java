package com.ex.client;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyStore;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;	
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class HttpLive {
	  
	public static void runTest() throws MalformedURLException, RestClientException, URISyntaxException {
		HttpClient httpClient = HttpClients.createDefault();
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        
        final RestTemplate restTemplate = new RestTemplate(requestFactory);
        //ResponseEntity<String> response = restTemplate.exchange(urlOverHttps, HttpMethod.GET, null, String.class);
        URL url= new URL("https://requestb.in/1cszecv1");
		String responseMsg=restTemplate.getForObject(url.toURI() ,String.class);
		System.out.println(responseMsg);
	}
	
	public static void testLocal() throws Exception {
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        final FileInputStream trustStore = new FileInputStream(new File("/Users/muhammed_alam/ssl/Test_Cert.keystore"));
        keyStore.load(trustStore, "changeit".toCharArray());
        trustStore.close();
        
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
                new SSLContextBuilder()
                        .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                        .loadKeyMaterial(keyStore, "changeit".toCharArray())
                        .build(),
                NoopHostnameVerifier.INSTANCE);

        HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();

        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        
        final RestTemplate restTemplate = new RestTemplate(requestFactory);
        //ResponseEntity<String> response = restTemplate.exchange(urlOverHttps, HttpMethod.GET, null, String.class);
        URL url= new URL("https://localhost:8443/restdemoservice/customerdatas/mdm/data");
		String responseMsg=restTemplate.getForObject(url.toURI() ,String.class);
		System.out.println(responseMsg);
	}
	public static void main(String[] args) throws Exception {
		runTest();
	}
   
    
}