package org.project.FastFood.Util;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	    public Date getDatefrom() throws ParseException {
	    	LocalDate date = LocalDate.now();
	    	 DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	 	    Date todayWithZeroTime = formatter.parse(formatter.format(date));
	 	    return todayWithZeroTime;
	    }
	   

}
	    
