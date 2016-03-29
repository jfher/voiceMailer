package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import mailSystem.Message;
import mailSystem.MessageQueue;

public class MessageQueueTest {

	@Test
	public void getMessageQueuetest() {
		MessageQueue messageQueue = new MessageQueue();
		assertEquals(messageQueue.size(), 0);
	  
	}
	
	@Test
	public void addOneMessageQueuetest() {
		MessageQueue messageQueue = new MessageQueue();
		Message message = new Message("Hola que tal");
		messageQueue.add(message);
		assertEquals(messageQueue.size(), 1);
	  
	}
	
	@Test
	public void addTwoMessageQueuetest() {
		MessageQueue messageQueue = new MessageQueue();
		Message message = new Message("Hola que tal");
		Message message2 = new Message("Hola que tal 2");
		messageQueue.add(message);
		messageQueue.add(message2);
		assertEquals(messageQueue.size(), 2);
	  
	}
	
	@Test
	public void removeAllMessageQueuetest() {
		MessageQueue messageQueue = new MessageQueue();
		Message message = new Message("Hola que tal");
		messageQueue.add(message);
		messageQueue.remove();
		assertEquals(messageQueue.size(), 0);
	  
	}
	
	@Test
	public void removeOneWithTwoInMessageQueuetest() {
		MessageQueue messageQueue = new MessageQueue();
		Message message = new Message("Hola que tal");
		Message message2 = new Message("Hola que tal 2");
		messageQueue.add(message);
		messageQueue.add(message2);
		messageQueue.remove();
		assertEquals(messageQueue.size(), 1);
	  
	}
	
	@Test
	public void getPeekWithOutMessageQueuetest() {
		MessageQueue messageQueue = new MessageQueue();
		assertEquals(messageQueue.peek(),null);
	  
	}
	
	@Test
	public void getPeekWithOneMessageQueuetest() {
		MessageQueue messageQueue = new MessageQueue();
		Message message = new Message("Hola que tal");
		messageQueue.add(message);
		assertEquals(messageQueue.peek().getText(),"Hola que tal");
	  
	}
	
	@Test
	public void getPeekWithTwoMessageQueuetest() {
		MessageQueue messageQueue = new MessageQueue();
		Message message = new Message("Hola que tal");
		messageQueue.add(message);
		Message message2 = new Message("Hola que tal 2");
		messageQueue.add(message2);
		assertEquals(messageQueue.peek().getText(),"Hola que tal");
	  
	}
	
	@Test
	public void removeFirstMessageWithTwoMessageQueuetest() {
		MessageQueue messageQueue = new MessageQueue();
		Message message = new Message("Hola que tal");
		messageQueue.add(message);
		Message message2 = new Message("Hola que tal 2");
		messageQueue.add(message2);
		messageQueue.remove();
		assertEquals(messageQueue.peek().getText(),"Hola que tal 2");
	  
	} 
	

}
