package C.services.CustomerService;

import C.entities.dtoEntitie.EmployeeDto;
import C.repositories.EmployeeRepository;
import C.entities.Customer;
import C.entities.dtoEntitie.CustomerDto;
import C.entities.transformations.CustomerMapper.CustomerDtoMapper;
import C.entities.transformations.CustomerMapper.CustomerMapper;
import C.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerDtoMapper customerDtoMapper;
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    private final EmployeeRepository employeeRepository;

    public CustomerServiceImpl(CustomerDtoMapper customerDtoMapper, CustomerMapper customerMapper, CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.customerDtoMapper = customerDtoMapper;
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void add(CustomerDto entity) {

        Customer customer  = new Customer();
        customer.setFirstName(entity.getFirstName());
        customer.setLastName(entity.getLastName());
        customer.setCity(entity.getCity());
        customer.setState(entity.getState());
        customer.setCountry(entity.getCountry());
        customer.setPostalCode(entity.getPostalCode());
        customer.setPhone(entity.getPhone());
        customer.setFax(entity.getFax());
        customer.setEmail(entity.getEmail());
        customer.setEmployee(employeeRepository.getReferenceById(entity.getSupportRepId()));
        customer.setInvoices(new ArrayList<>());
        customerRepository.save(customer);
    }
    @Override
    public void update(CustomerDto entity) {
        Optional<Customer> customer = Stream.of(entity)
                .map(customerMapper)
                .findAny();
        customer.ifPresent(customerRepository:: save);
    }

    @Override
    public CustomerDto getById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(customerDtoMapper).orElseThrow();
    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> values = customerRepository.findAll();
        return values.stream().map(customerDtoMapper).toList();
    }

    @Override
    public CustomerDto delete(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        optionalCustomer.ifPresent(customerRepository::delete);
        return optionalCustomer.map(customerDtoMapper).orElseThrow();
    }

}