package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import mailSystem.Connection;
import mailSystem.MailSystem;
import mailSystem.MessageQueue;
import mailSystem.Telephone;
import org.junit.After;
import org.junit.Before;
import static org.mockito.Mockito.*;

public class TelephoneTest {

	@Test
	public void getNewPhone() {
		Telephone phone = new Telephone(null);
	}
	
	@Test
	public void getSpeakOutput() {
		Telephone phone = new Telephone(null);
	 phone.speak("hola");
	}
	
	@Test
	public void runPhoneSystem() {
		MailSystem mailSystem= mock(MailSystem.class);
		Telephone telephone = mock(Telephone.class);
		Connection connection= new Connection(mailSystem, telephone);
		telephone.run(connection);
	}

}
