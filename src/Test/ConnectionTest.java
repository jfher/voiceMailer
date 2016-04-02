package Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import mailSystem.Connection;
import mailSystem.MailSystem;
import mailSystem.Mailbox;
import mailSystem.Message;
import mailSystem.Telephone;

public class ConnectionTest {
	
	 MailSystem mailSystem;
	 Telephone telephone;
	 Connection connection;
	 Mailbox mockedMailbox;
	 
	 @Before 
	 public void setup() {
		mailSystem= mock(MailSystem.class);
		telephone = mock(Telephone.class);
		connection= new Connection(mailSystem, telephone);
		mockedMailbox = mock(Mailbox.class);
	 }
	 
	 public void mailboxSelected(){
		 connection.dial("1");
	     connection.dial("#");
	 }
	 
	 public void mailboxSelectedAndLoginWithPassCode(){
		 mailboxSelected();
	     connection.dial("1");
	     connection.dial("#");
	 }

	@Test
	public void newConnectionTest() {
		verify(telephone).speak("Enter mailbox number followed by #");
		assertTrue(connection.isConnected());
	
	}
	
	@Test
	
	public void findMailboxWhenDial(){
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.getGreeting()).thenReturn("Hola mailbox");
		mailboxSelected();
		verify(telephone).speak("Hola mailbox");
		assertTrue(connection.isRecording());
	}
	
	@Test
	public void whenDialInAConnectedAndNoMailboxFoundShouldShowAnErrorMessage(){
	
		when(mailSystem.findMailbox("1")).thenReturn(null);
		mailboxSelected();
		verify(telephone).speak("Incorrect mailbox number. Try again!");
	}
	
	@Test
	public void whenDialIsOnRecordingStateLogin(){
		
		String menu = "Enter 1 to listen to your messages\n"
		         + "Enter 2 to change your passcode\n"
		         + "Enter 3 to change your greeting";
	
		
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		mailboxSelectedAndLoginWithPassCode();
		assertTrue(connection.isMailboxMenu());
		verify(telephone).speak(menu);
		
	}
	
	@Test
	public void getIntoChangePasscodeOption(){
	
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		
		mailboxSelectedAndLoginWithPassCode();
		connection.dial("2");
		verify(telephone).speak("Enter new passcode followed by the # key");
	}
	
	@Test
	public void ChangePasscodeToCurrentMailbox(){
		
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		when(mockedMailbox.checkPasscode("2")).thenReturn(true);
		mailboxSelectedAndLoginWithPassCode();
		connection.dial("2");
		connection.dial("2");
		connection.dial("#");
		assertTrue(mockedMailbox.checkPasscode("2"));
	}
	
	@Test
	public void whenTryToLoginAndPasscodeForCurrentMailboxIsIncorrect(){
		
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		
		mailboxSelected();
		connection.dial("2");
		connection.dial("#");
		verify(telephone).speak("Incorrect passcode. Try again!");
	}
	
	@Test
	public void getIntoChangeGreetingOption(){
		
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		
		mailboxSelectedAndLoginWithPassCode();
		connection.dial("3");
		verify(telephone).speak("Record your greeting, then press the # key");
	}
	
	@Test
	public void ChangeGreetingMessageToCurrentMailbox(){
		
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		
		mailboxSelectedAndLoginWithPassCode();
		connection.dial("3");
		connection.dial("hola");
		connection.dial("#");
		
		assertTrue(connection.isMailboxMenu());
	}
	
	@Test
	public void getIntoMessageMenuOption(){
	
		String messageMenu =  "Enter 1 to listen to the current message\n"
		         + "Enter 2 to save the current message\n"
		         + "Enter 3 to delete the current message\n"
		         + "Enter 4 to return to the main menu";;
	
		
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		
		mailboxSelectedAndLoginWithPassCode();
		connection.dial("1");
		
		verify(telephone).speak(messageMenu);
		assertTrue(connection.isMessageMenu());

	}
	
	@Test
	public void listenCurrentMessageFromCurrentMailbox(){
		Message message = mock(Message.class);
	  
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		when(mockedMailbox.getCurrentMessage()).thenReturn(message);
		mailboxSelectedAndLoginWithPassCode();
		connection.dial("1");
		connection.dial("1");
		assertTrue(connection.isMessageMenu());
		assertEquals(message.getText(),null);
	}
	
	@Test
	public void listenCurrentMessageFromAnEmptyCurrentMailbox(){
	
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		when(mockedMailbox.getCurrentMessage()).thenReturn(null);
		mailboxSelectedAndLoginWithPassCode();
		connection.dial("1");
		connection.dial("1");
		assertTrue(connection.isMessageMenu());
	}
	
	@Test
	public void saveCurrentMessageFromCurrentMailbox(){
	  
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		when(mockedMailbox.getCurrentMessage()).thenReturn(null);
		mailboxSelectedAndLoginWithPassCode();;
		connection.dial("1");
		connection.dial("2");
		assertTrue(connection.isMessageMenu());
	}
	
	@Test
	public void deleteCurrentMessageFromCurrentMailbox(){
	  
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		when(mockedMailbox.getCurrentMessage()).thenReturn(null);
		mailboxSelectedAndLoginWithPassCode();
		connection.dial("1");
		connection.dial("3");
		assertTrue(connection.isMessageMenu());
	}
	
	@Test
	public void returnToMainMenuFromMessageMenu(){
	  
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		mailboxSelectedAndLoginWithPassCode();
		connection.dial("1");
		connection.dial("4");
		
		assertTrue(connection.isMailboxMenu());	
	}
	
	@Test
	public void getCurrentRecording(){
		assertEquals(connection.getCurrentRecording(),"");
	}
	
	@Test
	public void getAcumulatedKeys(){
		assertEquals(connection.getAccumulatedKeys(),"");
	}
	
	@Test
	public void getConnectionState(){
		assertEquals(connection.getState(),1);
	}
	
	@Test
	public void recordMessageIntoCurrentMailbox(){
		when(mailSystem.findMailbox("1")).thenReturn(mockedMailbox);
		when(mockedMailbox.checkPasscode("1")).thenReturn(true);
		mailboxSelected();
		connection.record("hola");
		connection.hangup();;
		verify(telephone,times(2)).speak("Enter mailbox number followed by #");
	}


}
