package C.entities.dtoEntitie;

import C.entities.Invoice_item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvoiceDto {
    private int InvoiceId;
    private Long CustomerId;
    private Date InvoiceDate;
    private String BillingAddress;
    private String BillingCity;
    private String BillingState;
    private String BillingCountry;
    private String BillingPostalCode;
    private float Total;
    private List<Invoice_item> invoiceItems;
}

