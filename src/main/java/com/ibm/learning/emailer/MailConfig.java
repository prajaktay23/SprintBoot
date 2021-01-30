package com.ibm.learning.emailer;

	import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
	

	/*This class MailConfig will be use to configure the beans of
	 * DummyEmailSender and SmtpEmailsender as we may dont have source of these
	 * classes but we want to use them as a spring bean.
	 */

	@Configuration
	public class MailConfig {

//		@Bean
//		@Profile("dev")
//		public IEmailerService dummyEmailSender(){
//			return new  DummyEmailSender();	
//		}
		
		@Bean
		//@Primary
		@Profile("zomato")
		public IEmailerService smtpEmailSender(JavaMailSender javaMailSender){
			return new SmtpEmailSender(javaMailSender);	
		}
		
		@Bean
		@ConditionalOnProperty(name="smtp.mail.host",havingValue="foo",matchIfMissing=true)
		public IEmailerService dummyEmailSender() {
			return new DummyEmailSender();
		}

		@Bean
		@ConditionalOnProperty("smtp.mail.host")
		public IEmailerService SmtpEmailSender(JavaMailSender javaMailSender) {
			return new SmtpEmailSender(javaMailSender);
		}

	}
	




