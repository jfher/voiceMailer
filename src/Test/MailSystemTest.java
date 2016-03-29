package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import mailSystem.MailSystem;

public class MailSystemTest {

	@Test
	public void checkMailboxSucessfullyCreated() {
		MailSystem mailSystem = new MailSystem('1');
		assertEquals(mailSystem.findMailbox("1").checkPasscode("1"),true);
	}
}
