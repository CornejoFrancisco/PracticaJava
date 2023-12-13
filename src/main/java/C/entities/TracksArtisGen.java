package C.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TracksArtisGen {
    private Integer TrackId;
    private String TrackName;
    private String AlbumName;
    private String ArtistName;
    private Double MiliSeconds;
}
