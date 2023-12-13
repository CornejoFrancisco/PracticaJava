package C.entities.dtoEntitie;

import C.entities.Invoice_item;
import C.entities.Playlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDto {
    private int TrackId;
    private String Name;
    private long AlbumId;
    private long MediaTypeId;
    private long GenreId;
    private String Composer;
    private int Milliseconds;
    private int Bytes;
    private float UnitPrice;
    List<Invoice_item> invoiceItems;
    private List<Playlist> playlists;

}
