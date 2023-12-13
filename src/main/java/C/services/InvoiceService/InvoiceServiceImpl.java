package C.services.InvoiceService;


import C.entities.Invoice;
import C.entities.dtoEntitie.CustomerDto;
import C.entities.dtoEntitie.InvoiceDto;
import C.entities.transformations.InvoiceMapper.InvoiceDtoMapper;
import C.entities.transformations.InvoiceMapper.InvoiceMapper;
import C.repositories.CustomerRepository;
import C.repositories.InvoiceRepository;
import C.services.CustomerService.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final InvoiceDtoMapper invoiceDtoMapper;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public InvoiceServiceImpl(CustomerRepository customerRepository, CustomerService customerService, InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, InvoiceDtoMapper invoiceDtoMapper) {
        this.customerRepository = customerRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.invoiceDtoMapper = invoiceDtoMapper;
        this.customerService = customerService;
    }

    @Override
    public void add(InvoiceDto entity) {

        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(entity.getInvoiceDate());
        invoice.setBillingAddress(entity.getBillingAddress());
        invoice.setBillingCity(entity.getBillingCity());
        invoice.setBillingState(entity.getBillingState());
        invoice.setBillingCountry(entity.getBillingCountry());
        invoice.setBillingPostalCode(entity.getBillingPostalCode());
        invoice.setTotal(entity.getTotal());
        invoice.setCustomer(customerRepository.getReferenceById(entity.getCustomerId()));
        invoice.setInvoiceItems(new ArrayList<>());
        invoiceRepository.save(invoice);
        invoiceRepository.save(invoice);
    }
    @Override
    public InvoiceDto getById(Long id) {
        Optional<Invoice> customer = invoiceRepository.findById(id);
        return customer.map(invoiceDtoMapper).orElseThrow();
    }

    @Override
    public List<InvoiceDto> getAll() {
        List<Invoice> values = invoiceRepository.findAll();
        return values.stream().map(invoiceDtoMapper).toList();
    }

    @Override
    public InvoiceDto delete(Long id) {
        Optional<Invoice> optionalCustomer = invoiceRepository.findById(id);
        optionalCustomer.ifPresent(invoiceRepository::delete);
        return optionalCustomer.map(invoiceDtoMapper).orElseThrow();
    }

    @Override
    public void update(InvoiceDto entity) {
        Optional<Invoice> customer = Stream.of(entity)
                .map(invoiceMapper)
                .findAny();
        customer.ifPresent(invoiceRepository:: save);
    }
}

