package zqit.activemq.pulgins.activeMQ.producer;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestProducer {
	
	private String queueName = "test-queue";

	@Autowired 
	private JmsMessagingTemplate jmsTemplate; 
	
	public void testMessageSend(String payload){
		Destination destination = new ActiveMQQueue(queueName); 
		jmsTemplate.convertAndSend(destination, payload);
	}
}
