package C.entities.dtoEntitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TracksArtisGenDto {
    private int TrackId;
    private String TrackName;
    private String AlbumName;
    private String ArtistName;
    private Double MiliSeconds;
}
