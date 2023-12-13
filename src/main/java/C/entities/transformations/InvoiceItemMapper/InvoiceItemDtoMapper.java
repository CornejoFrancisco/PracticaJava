package C.entities.transformations.InvoiceItemMapper;

import C.entities.Invoice_item;
import C.entities.dtoEntitie.InvoiceItemDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InvoiceItemDtoMapper implements Function<Invoice_item, InvoiceItemDto> {
    @Override
    public InvoiceItemDto apply(Invoice_item invoiceItems) {
        return new InvoiceItemDto(invoiceItems.getInvoiceLineId(),
                invoiceItems.getInvoice().getInvoiceId(),
                invoiceItems.getTrack().getTrackId(),
                invoiceItems.getUnitPrice(),
                invoiceItems.getQuantity());
    }
}
