package org.project.FastFood.Util;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	   public final Random RANDOM = new SecureRandom();
	    public final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	   
	    public String generateStringId(int length) {
	        StringBuilder returnValue = new StringBuilder(length);

	        for (int i = 0; i < length; i++) {
	            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
	        }

	        return new String(returnValue);
	    }
	    
	    
	    public Date getLocalDateTime() {
	    	 LocalDateTime localDate = LocalDateTime.now();
	 		ZoneId defaultZoneId = ZoneId.systemDefault();
	 		Date date = Date.from(localDate.atZone(defaultZoneId).toInstant());
	 	    
	    	
	    	return date;
	    }
	    
	   

}
	    
