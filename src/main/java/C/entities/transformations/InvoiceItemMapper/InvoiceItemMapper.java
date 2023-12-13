package C.entities.transformations.InvoiceItemMapper;


import C.repositories.InvoiceRepository;
import C.repositories.TrackRepository;
import C.entities.Invoice_item;
import C.entities.dtoEntitie.InvoiceItemDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InvoiceItemMapper implements Function<InvoiceItemDto, Invoice_item> {
    private final InvoiceRepository invoiceRepository;

    public InvoiceItemMapper(InvoiceRepository invoiceRepository, TrackRepository trackRepository) {
        this.invoiceRepository = invoiceRepository;
        this.trackRepository = trackRepository;
    }

    private final TrackRepository trackRepository;



    @Override
    public Invoice_item apply(InvoiceItemDto invoiceItemsDto) {
        return new Invoice_item(invoiceItemsDto.getInvoiceLineId(),
                invoiceRepository.getReferenceById(invoiceItemsDto.getInvoiceId()),
                trackRepository.getReferenceById(invoiceItemsDto.getTrackId()),
                invoiceItemsDto.getUnitPrice(),
                invoiceItemsDto.getQuantity());
    }
}
