package com.cognizant.loan;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @GetMapping("/loans/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number){
        Map<String,Object> response=new HashMap<>();
        response.put("number",number);
        response.put("type","loan");
        response.put("loan",500000);
        response.put("EMI",3258);
        response.put("Tenure",18); 
        return response;   }
}
    
        

