package com.ibm.learning.controller;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.learning.emailer.IEmailerService;


@RestController
public class EmailServiceController {

	//IEmailService emailService = new DummyEmailSender();
	//Don't create any object  with specific type , let Spring create it 
	@Autowired
    IEmailerService emailService;

	/*@Autowired  //at setter method
	public void setEmailService(IEmailerService emailService) {
		this.emailService = emailService;
	}
	*/
	//Auto wired using constructor
	 @Autowired // using constructor
		public EmailServiceController (IEmailerService abc) {
			this.emailService = abc;
		}
	 
	 
	public IEmailerService getEmailService() {
		return emailService;
	}
	
    // http://localhost:8080/sendemail
    @RequestMapping("/sendemail")
    public String email() throws MessagingException {
        //call sendEMail method
        emailService.sendEmail("stevejobs@apple.com", "Launching of new Apple Model", "Body of the email");

        return "Email Sent";
    }

}



	
	
