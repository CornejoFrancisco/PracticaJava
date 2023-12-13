package C.entities.transformations.InvoiceMapper;

import C.repositories.CustomerRepository;
import C.entities.Invoice;
import C.entities.dtoEntitie.InvoiceDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InvoiceMapper implements Function<InvoiceDto, Invoice> {
    private final CustomerRepository customerRepository;

    public InvoiceMapper(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Invoice apply(InvoiceDto invoiceDto) {
        return new Invoice(invoiceDto.getInvoiceId(),
                customerRepository.getReferenceById(invoiceDto.getCustomerId()),
                invoiceDto.getInvoiceDate(),
                invoiceDto.getBillingAddress(),
                invoiceDto.getBillingCity(),
                invoiceDto.getBillingState(),
                invoiceDto.getBillingCountry(),
                invoiceDto.getBillingPostalCode(),
                invoiceDto.getTotal(),
                invoiceDto.getInvoiceItems());
    }
}
