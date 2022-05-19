package com.ntt.testntt.core.application.services;

import com.ntt.testntt.core.application.repositories.CustomerRepository;
import com.ntt.testntt.core.entity.Customer;
import com.ntt.testntt.core.events.ResponseEvent;
import com.ntt.testntt.core.firmsServices.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceHandler implements CustomerService {

    public final CustomerRepository customerRepository;

    public CustomerServiceHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEvent<Customer> getCustomer(Long numeroDocumento, char tipoDocumento) {
        log.debug("method: getCustommer({}-{})", numeroDocumento, tipoDocumento);
        //se podrian traer los tipos de la base de datos / se podria validar en el controlador o modelo
        if (tipoDocumento != 'C' && tipoDocumento != 'P') {
            return new ResponseEvent<Customer>().badRequest("Tipo de documento invalido ");
        }
        try {
            var customer = customerRepository.findByCustomerIdAndTipoDocumento(numeroDocumento, tipoDocumento);
            if (!customer.isPresent()) {
                return new ResponseEvent<Customer>().badRequest("El cliente " + numeroDocumento + " no existe ");
            }
            return new ResponseEvent<Customer>().ok("Cliente : ", customer.get());

        } catch (Exception e) {
            return new ResponseEvent<Customer>().badRequest("Error al obtener el cliente ");
        }

    }
}
