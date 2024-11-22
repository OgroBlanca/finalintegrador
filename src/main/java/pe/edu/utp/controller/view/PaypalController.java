package pe.edu.utp.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import pe.edu.utp.service.facade.PaypalFacade;

@Controller
@RequestMapping("/paypal")
public class PaypalController {
    
    private final PaypalFacade paypalFacade;

    public PaypalController(PaypalFacade paypalFacade) {
        this.paypalFacade = paypalFacade;
    }

    @PostMapping("/payment/create")
    public RedirectView createPayment(){
        try{
            String cancelUrl = "http://localhost:8085/paypal/payment/cancel";
            String successUrl = "http://localhost:8085/paypal/payment/success";
            Payment payment = paypalFacade.createPayment(
                10.0, 
                "USD", 
                "paypal",
                "sale", 
                "Payment Description", 
                cancelUrl, 
                successUrl);

                for (Links links : payment.getLinks()) {
                    if(links.getRel().equals("approval_url")){
                        return new RedirectView(links.getHref());
                    }
                }
        } catch (PayPalRESTException e){
          System.err.println("error ocurred: " + e);
        }
        return new RedirectView("/payment/error");
    }

    @GetMapping("/payment/success")
    public String paymentSucces(@RequestParam("paymentId") String paymentId,
        @RequestParam("payerID") String payerId){
        try{
            Payment payment = paypalFacade.executePayment(paymentId, payerId);
            if(payment.getState().equals("approved")){
                return "paciente-perfil";
            }
        } catch (PayPalRESTException e) {
            System.err.println("Error :" + e);
        }

        return "paciente-perfil";
    }

    @GetMapping("/payment/cancel")
    public String paymentCancel(){
        return "paciente-reservar";
    }

    @GetMapping("/payment/error")
    public String paymentError(){
        return "error";
    }

    

    
}
