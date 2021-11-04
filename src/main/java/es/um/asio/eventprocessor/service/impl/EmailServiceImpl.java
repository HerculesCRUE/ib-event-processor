package es.um.asio.eventprocessor.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import es.um.asio.eventprocessor.service.EmailService;

public class EmailServiceImpl implements EmailService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Value("${app.microservices.email-service.messages-endpoint}")
	private String emailEndpoint;

	/**
	 * Rest Template
	 */
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void email(String type) {
		if (this.logger.isDebugEnabled()) {
			this.logger.debug("New email type: {}", type);
		}

		restTemplate.postForObject(emailEndpoint, type, Void.class);

		if (this.logger.isDebugEnabled()) {
			this.logger.debug("Message sent to backend: {}", type);
		}

	}

}
