package zqit.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zqit.activemq.pulgins.activeMQ.consumer.TestConsumer;
import zqit.activemq.pulgins.activeMQ.producer.TestProducer;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestProducer testProducer;
	@Autowired
	TestConsumer testConsumer;
	
	/**
	 * 队列消息生产者
	 * @param mess
	 * @return
	 */
	@GetMapping("/produceMessage")
	public String produceMessage(@RequestParam("mess") String mess){
		testProducer.testMessageSend(mess);
		System.out.println("消息生产+1 message("+mess+")");
		return mess;
	}
	
	/**
	 * 队列消息消费者 - 手动
	 * @return
	 */
	@GetMapping("/consumerMessage1")
	public String consumerMessage(){
		String r = testConsumer.receiveQueue();
		return r;
	}
	
	/**
	 * 队列消息消费者 - 自动
	 * @return
	 */
	@JmsListener(destination = "test-queue")
	public void receiveQueue(String text) {
		System.out.println("(Auto)Consumer收到的报文为:" + text);
	}
	
}
