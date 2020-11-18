package es.um.asio.eventprocessor.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import es.um.asio.abstractions.domain.ManagementBusEvent;
import es.um.asio.eventprocessor.service.MessageService;

/**
 * The Class MessageConsumer.
 */
@Component
public class MessageConsumer {

	private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	
	  @Autowired
	    private MessageService messageService;

    /**
     * Listener.
     *
     * @param message the message
     */
    @JmsListener(destination = "${app.activemq.queue-name:default-queue-name}")
    public void listener(final ManagementBusEvent message){
        
    	// remove it. It's only for debugging
    	logger.info("Message received {} ", message);
        
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Received message: {}", message);
        }

        this.messageService.process(message);
    }
}