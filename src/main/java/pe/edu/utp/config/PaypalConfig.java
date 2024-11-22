package pe.edu.utp.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.base.rest.APIContext;

@Configuration
public class PaypalConfig {
  
    @Value("${paypal.cliente-id}")
    private String clientId;
    @Value("${paypal.cliente-secret}")
    private String clientSecret;
    @Value("${paypal.mode}")
    private String mode;

    @Bean
    public APIContext apiContext(){
        return new  APIContext(clientId,clientSecret,mode);
    } 
}
