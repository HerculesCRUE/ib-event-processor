package es.um.asio.eventprocessor.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import es.um.asio.abstractions.domain.ManagementBusEvent;
import es.um.asio.eventprocessor.service.MessageService;

/**
 * Input message listener
 */
@Component
public class ManagementListener {
    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(ManagementListener.class);

    @Autowired
    private MessageService messageService;

    /**
     * Method listening input topic name
     * 
     * @param message
     */
    @KafkaListener(topics = "#{'${app.kafka.management-topic-name}'.split(',')}", containerFactory = "managementBusKafkaListenerContainerFactory")
    public void listen(final ManagementBusEvent<Model> message) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Received message: {}", message);
        }

        // this.messageService.process(message);
    }
}
