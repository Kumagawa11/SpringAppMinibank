package com.example.minibank.common.eventlistener;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class EventListeners {

	private static final Logger log = LoggerFactory.getLogger(EventListeners.class);
	
	@EventListener
	public void handleBadCredentials(
			AuthenticationFailureBadCredentialsEvent event
			) {
		
		log.info("認証失敗　ユーザーネーム：{}", event.getAuthentication().getName());
		
		
	}
	@EventListener
	public void handleSuccessCredentials(
			AuthenticationSuccessEvent event
			) {
		
		log.info("認証成功　ユーザーネーム：{}", event.getAuthentication().getName());
		
	}
	
	
	
}
