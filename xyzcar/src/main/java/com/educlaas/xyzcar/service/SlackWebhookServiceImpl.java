package com.educlaas.xyzcar.service;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.educlaas.xyzcar.pojo.SlackWebhook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SlackWebhookServiceImpl  implements SlackWebhookService{
	private static final String WEBHOOK_URL = "https://hooks.slack.com/services/%s";
	private static final Map<String, String> WEBHOOK_CHANNEL = Collections.singletonMap("WWW", "T06114U2HQB/B061VGJSG72/7T1uytyBMU99caJlfB6LAxnR");

	@Override
	public void sendMessage(String sender, SlackWebhook messages) {
		
		//Declare sender from the current channel 
		String senderName = WEBHOOK_CHANNEL.get(sender);
		
		//Combine two strings (Sender & SlackWebhook URL)
		String slackURL = String.format(WEBHOOK_URL, senderName);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			String body = objectMapper.writeValueAsString(messages);
			
			HttpEntity<String> httpEntity = new HttpEntity<String>(body, httpHeaders);
			
			RestTemplate restTemplate = new RestTemplate();
			
			restTemplate.exchange(slackURL, HttpMethod.POST, httpEntity, String.class);		
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static String getWebhookUrl() {
		return WEBHOOK_URL;
	}

	public static Map<String, String> getWebhookChannel() {
		return WEBHOOK_CHANNEL;
	}
}
