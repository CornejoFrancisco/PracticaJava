package C.entities.transformations.CustomerMapper;

import C.entities.Customer;
import C.entities.dtoEntitie.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class CustomerDtoMapper implements Function<Customer, CustomerDto> {
    @Override
    public CustomerDto apply(Customer customer) {
        return new CustomerDto(customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getCompany(),
                customer.getAddress(),
                customer.getCity(),
                customer.getState(),
                customer.getCountry(),
                customer.getPostalCode(),
                customer.getPhone(),
                customer.getFax(),
                customer.getEmail(),
                customer.getEmployee().getEmployeeId(),
                customer.getInvoices());

    }
}