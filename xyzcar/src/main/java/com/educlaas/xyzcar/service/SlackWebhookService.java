package com.educlaas.xyzcar.service;

import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.pojo.SlackWebhook;

@Service
public interface SlackWebhookService {
	public void sendMessage(String sender, SlackWebhook messages);
}
