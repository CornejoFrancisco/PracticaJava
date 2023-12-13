package C.entities.transformations.CustomerMapper;

import C.repositories.EmployeeRepository;
import C.entities.Customer;
import C.entities.dtoEntitie.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CustomerMapper implements Function<CustomerDto, Customer> {
    private final EmployeeRepository employeeRepository;

    public CustomerMapper(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Customer apply(CustomerDto customerDto) {
        return new Customer(customerDto.getCustomerId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getCompany(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getState(),
                customerDto.getCountry(),
                customerDto.getPostalCode(),
                customerDto.getPhone(),
                customerDto.getFax(),
                customerDto.getEmail(),
                employeeRepository.getReferenceById(customerDto.getSupportRepId()),
                customerDto.getInvoices());
    }
}
