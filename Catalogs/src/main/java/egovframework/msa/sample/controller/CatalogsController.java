package egovframework.msa.sample.controller;

import egovframework.msa.sample.service.CustomerApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogs/customerinfo")
public class CatalogsController {

    private final CustomerApiService customerApiService;

    public CatalogsController(CustomerApiService customerApiService) {
        this.customerApiService = customerApiService;
    }

    @GetMapping(path = "/{customerId}")
    public String getCustomerInfo(@PathVariable String customerId) {
        String customerInfo = customerApiService.getCustomerDetail(customerId);
        System.out.println("response customerInfo :" + customerInfo);
        return String.format("[Customer id = %s at %s %s]", customerId, System.currentTimeMillis(), customerInfo);
    }
}
