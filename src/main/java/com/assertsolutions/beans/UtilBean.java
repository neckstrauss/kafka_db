package com.assertsolutions.beans;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.assertsolutions.dto.AuditoriaRequest;

@Component("utilBean")
public class UtilBean {
    
   public AuditoriaRequest setCurrentDate(AuditoriaRequest req)
   {
	   	req.setFechaLog(Calendar.getInstance().getTime());
	   	
	   	return req;
   }

}
