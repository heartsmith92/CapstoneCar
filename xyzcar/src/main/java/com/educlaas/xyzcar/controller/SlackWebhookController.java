package com.educlaas.xyzcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.pojo.SlackWebhook;
import com.educlaas.xyzcar.service.SlackWebhookService;

@RestController
@RequestMapping(value = "/webhook")
@CrossOrigin("http://localhost:3000")
public class SlackWebhookController {
	@Autowired
	private SlackWebhookService webhookService;
	
	@PostMapping(value = "/message/{sender}")
	public void sendMessage(@PathVariable String sender, @RequestBody SlackWebhook webhook) {
		webhookService.sendMessage(sender, webhook);
	}
}
