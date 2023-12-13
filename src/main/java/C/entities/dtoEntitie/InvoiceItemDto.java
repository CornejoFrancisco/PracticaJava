package C.entities.dtoEntitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceItemDto {
    private int InvoiceLineId;
    private long InvoiceId;
    private long TrackId;
    private float UnitPrice;
    private int Quantity;
}
