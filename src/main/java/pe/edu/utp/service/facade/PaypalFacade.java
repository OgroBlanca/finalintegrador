package pe.edu.utp.service.facade;

import org.springframework.stereotype.Service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import pe.edu.utp.service.PaypalService;

@Service
public class PaypalFacade {
 
    private final PaypalService paypalService; 


    public PaypalFacade(PaypalService paypalService) {
        this.paypalService = paypalService;
    }

    public Payment createPayment(
        Double total,
        String currency,
        String method,
        String intent,
        String description,
        String cancelUrl,
        String successUrl
    ) throws PayPalRESTException{
      return paypalService.createPayment(total, currency, method, intent, description, cancelUrl, successUrl);
    }

    public Payment executePayment(
        String paymentId,
        String payerId
    ) throws PayPalRESTException{
        return paypalService.executePayment(paymentId, payerId);
    }


}
