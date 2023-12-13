package C.entities.transformations.InvoiceMapper;

import C.entities.Invoice;
import C.entities.dtoEntitie.InvoiceDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InvoiceDtoMapper implements Function<Invoice, InvoiceDto> {
    @Override
    public InvoiceDto apply(Invoice invoice) {
        return new InvoiceDto(invoice.getInvoiceId(),
                invoice.getCustomer().getCustomerId(),
                invoice.getInvoiceDate(),
                invoice.getBillingAddress(),
                invoice.getBillingCity(),
                invoice.getBillingState(),
                invoice.getBillingCountry(),
                invoice.getBillingPostalCode(),
                invoice.getTotal(),
                invoice.getInvoiceItems());
    }
}
