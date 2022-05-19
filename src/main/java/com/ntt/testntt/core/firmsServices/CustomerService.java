package com.ntt.testntt.core.firmsServices;

import com.ntt.testntt.core.entity.Customer;
import com.ntt.testntt.core.events.RequestEvent;
import com.ntt.testntt.core.events.ResponseEvent;

public interface CustomerService {

    ResponseEvent<Customer> getCustomer(Long numeroDocumento, char tipoDocumento);
}
