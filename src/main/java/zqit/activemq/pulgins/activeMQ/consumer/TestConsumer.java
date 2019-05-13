package zqit.activemq.pulgins.activeMQ.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {
	
	private String queueName = "test-queue";
	
	@Autowired 
	private JmsMessagingTemplate jmsTemplate; 

	public String receiveQueue() {
		Message<?> receive = jmsTemplate.receive(queueName);
		String payload = (String) receive.getPayload();
		String r = "(Hand)Consumer收到的报文为:" + payload.toString();
		System.out.println(r);
		return r;
	}

}
