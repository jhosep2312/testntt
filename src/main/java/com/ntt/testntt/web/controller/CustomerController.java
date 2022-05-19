package com.ntt.testntt.web.controller;

import com.ntt.testntt.core.entity.Customer;
import com.ntt.testntt.core.events.ResponseEvent;
import com.ntt.testntt.core.firmsServices.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ntt.testntt.web.controller.APIController.buildHttpResponse;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("get-custommer/{numeroDocumento}/{tipoDocumento}")
    public ResponseEntity<ResponseEvent<Customer>> getCustomer(
            @PathVariable("numeroDocumento") Long numeroDocumento,
            @PathVariable("tipoDocumento") char tipoDocumento ) {

        ResponseEvent<Customer> responseEvent = customerService.getCustomer(numeroDocumento,tipoDocumento);

        return buildHttpResponse(responseEvent);
    }

}
