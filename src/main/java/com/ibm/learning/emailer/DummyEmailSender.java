package com.ibm.learning.emailer;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//when application gets started , Spring checks @component annotation and if found 
//then it create the instance of the class and store it in ApplicationContext
//@Component("dummybean")
//@Primary
public class DummyEmailSender implements IEmailerService {

	private static Log log=LogFactory.getLog(DummyEmailSender.class);
	@Override
	public void sendEmail(String emailID, String subject, String mailContent) {
		// TODO Auto-generated method stub
		
		log.info("Dummy mail receiver ID:"+emailID);
        log.info("Dummy mail subject:"+subject);
        log.info("Dummy mail body:"+mailContent);
        log.warn("This is just a Dummy email sender");
		}
}