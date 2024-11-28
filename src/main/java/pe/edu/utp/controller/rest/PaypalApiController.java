package pe.edu.utp.controller.rest;

import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import jakarta.servlet.http.HttpSession;
import pe.edu.utp.service.facade.CitaMedicaFacade;
import pe.edu.utp.service.facade.MedicoFacade;
import pe.edu.utp.service.facade.PacienteFacade;
import pe.edu.utp.service.facade.PaypalFacade;

@RestController
@RequestMapping("/api/v1/paypal")
public class PaypalApiController {
    @Autowired
    private MedicoFacade medicoFacade;
    @Autowired
    private CitaMedicaFacade citaFacade;
    @Autowired
    private PacienteFacade pacienteFacade;

    private final PaypalFacade paypalFacade;

    public PaypalApiController(PaypalFacade paypalFacade) {
        this.paypalFacade = paypalFacade;
    }

    
}


