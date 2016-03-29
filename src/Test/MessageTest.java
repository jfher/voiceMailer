package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import mailSystem.Message;

public class MessageTest {

	@Test
	public void getMessageText() {
		Message message = new Message("Hola que tal");
		assertEquals(message.getText(),"Hola que tal");
	}

}
