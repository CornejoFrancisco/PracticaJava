package C.services.InvoiceItemService;

import C.entities.Invoice_item;
import C.entities.dtoEntitie.InvoiceDto;
import C.entities.dtoEntitie.InvoiceItemDto;
import C.entities.transformations.InvoiceItemMapper.InvoiceItemDtoMapper;
import C.entities.transformations.InvoiceItemMapper.InvoiceItemMapper;
import C.repositories.InvoiceItemRepository;
import C.repositories.InvoiceRepository;
import C.repositories.TrackRepository;
import C.services.InvoiceService.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService{
    private final InvoiceItemDtoMapper invoiceItemDtoMapper;
    private final InvoiceItemMapper invoiceItemMapper;
    private final InvoiceItemRepository invoiceItemRepository;
    private final InvoiceService invoiceService;
    private final InvoiceRepository invoiceRepository;
    private final TrackRepository trackRepository;


    public InvoiceItemServiceImpl(InvoiceItemDtoMapper invoiceItemDtoMapper, InvoiceItemMapper invoiceItemMapper, InvoiceItemRepository invoiceItemRepository, InvoiceService invoiceService, InvoiceRepository invoiceRepository, TrackRepository trackRepository) {
        this.invoiceItemDtoMapper = invoiceItemDtoMapper;
        this.invoiceItemMapper = invoiceItemMapper;
        this.invoiceItemRepository = invoiceItemRepository;
        this.invoiceService = invoiceService;
        this.invoiceRepository = invoiceRepository;
        this.trackRepository = trackRepository;
    }




    @Override
    public void add(InvoiceItemDto entity) {
        Invoice_item invoiceItem = new Invoice_item();
        invoiceItem.setInvoice(invoiceRepository.getReferenceById(entity.getInvoiceId()));
        invoiceItem.setInvoiceLineId(entity.getInvoiceLineId());
        invoiceItem.setTrack(trackRepository.getReferenceById(entity.getTrackId()));
        invoiceItem.setUnitPrice(entity.getUnitPrice());
        invoiceItem.setQuantity(entity.getQuantity());
        invoiceItemRepository.save(invoiceItem);
    }

    @Override
    public InvoiceItemDto getById(Long id) {
        Optional<Invoice_item> customer = invoiceItemRepository.findById(id);
        return customer.map(invoiceItemDtoMapper).orElseThrow();
    }

    @Override
    public List<InvoiceItemDto> getAll() {
        List<Invoice_item> values = invoiceItemRepository.findAll();
        return values.stream().map(invoiceItemDtoMapper).toList();
    }

    @Override
    public InvoiceItemDto delete(Long id) {
        Optional<Invoice_item> optionalInvoiceItem = invoiceItemRepository.findById(id);
        optionalInvoiceItem.ifPresent(invoiceItemRepository::delete);
        return optionalInvoiceItem.map(invoiceItemDtoMapper).orElseThrow();
    }

    @Override
    public void update(InvoiceItemDto entity) {
        Optional<Invoice_item> invoiceItem = Stream.of(entity)
                .map(invoiceItemMapper)
                .findAny();
        invoiceItem.ifPresent(invoiceItemRepository:: save);
    }
}
