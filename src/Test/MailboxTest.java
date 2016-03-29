package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import mailSystem.Mailbox;
import mailSystem.Message;

public class MailboxTest {

	@Test
	public void newMailboxGreetingTest() {
		Mailbox mailbox = new Mailbox("1","hola");
		assertEquals(mailbox.getGreeting(),"hola");
	}
	
	@Test
	public void newMailboxPasscodeTest() {
		Mailbox mailbox = new Mailbox("12","Hola 2");
		assertEquals(mailbox.checkPasscode("12"),true);
	}
	
	@Test
	public void setGreetingTest() {
		Mailbox mailbox = new Mailbox("123","Hola");
		mailbox.setGreeting("hello");
		assertEquals(mailbox.getGreeting(),"hello");
	}
	
	@Test
	public void setPasscodeTest() {
		Mailbox mailbox = new Mailbox("2","Hola");
		mailbox.setPasscode("1234");
		assertEquals(mailbox.checkPasscode("1234"),true);
	}
	
	@Test
	public void addMessageToCurrentMailboxTest() {
		Mailbox mailbox = new Mailbox("3","Bienvenido 3");
		Message message = new Message("Hola que tal");
		mailbox.addMessage(message);
		assertEquals(mailbox.getCurrentMessage().getText(),"Hola que tal");
	}
	
	@Test
	public void deleteMessageFromCurrentMailboxTest() {
		Mailbox mailbox = new Mailbox("4","Bienvenido 4");
		Message message = new Message("Hola que tal borrar");
		mailbox.addMessage(message);
		mailbox.removeCurrentMessage();
		assertEquals(mailbox.getCurrentMessage(),null);
	}
	
	@Test
	public void deleteMessageFromCurrentMailboxWithTwoMessagesTest() {
		Mailbox mailbox = new Mailbox("5","Bienvenido 5");
		Message message = new Message("Hola que tal debo ser borrado");
		Message message2 = new Message("Hola que tal");
		mailbox.addMessage(message);
		mailbox.addMessage(message2);
		mailbox.removeCurrentMessage();
		assertEquals(mailbox.getCurrentMessage().getText(),"Hola que tal");
	}
	
	@Test
	public void saveCurrentMessageMailboxTest() {
		Mailbox mailbox = new Mailbox("6","Bienvenido 6");
		Message message = new Message("Hola que tal");
		mailbox.addMessage(message);
		mailbox.saveCurrentMessage();
		assertEquals(mailbox.getCurrentMessage().getText(),"Hola que tal");
	}
	
	@Test
	public void saveCurrentMessageWithTwoMessagesMailboxTest() {
		Mailbox mailbox = new Mailbox("6","Bienvenido 6");
		Message message = new Message("Hola que tal debo ser guardado");
		Message message2 = new Message("Hola que tal");
		mailbox.addMessage(message);
		mailbox.addMessage(message2);
		mailbox.saveCurrentMessage();
		assertEquals(mailbox.getCurrentMessage().getText(),"Hola que tal");
	}
	
	@Test
	public void removeCurrentKeeptMessageMailboxTest() {
		Mailbox mailbox = new Mailbox("6","Bienvenido 6");
		Message message = new Message("Hola que tal debo ser guardado");
		mailbox.addMessage(message);
		mailbox.saveCurrentMessage();
		mailbox.removeCurrentMessage();
		assertEquals(mailbox.removeCurrentMessage(), null);
	}
	
	@Test
	public void saveEmptyCurrentMessageMailboxTest() {
		Mailbox mailbox = new Mailbox("6","Bienvenido 6");
		mailbox.addMessage(null);
		mailbox.saveCurrentMessage();
		assertEquals(mailbox.removeCurrentMessage(), null);
	}
	
	
	

}
