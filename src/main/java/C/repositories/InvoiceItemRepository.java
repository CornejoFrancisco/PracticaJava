package C.repositories;

import C.entities.Invoice_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository
    extends JpaRepository<Invoice_item, Long> {
}
