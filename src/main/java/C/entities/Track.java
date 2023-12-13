package C.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Entity
@Table(name = "tracks")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "tracks", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="tracks",
            initialValue=1, allocationSize=1)
    private int TrackId;
    private String Name;
    @ManyToOne
    @JoinColumn(name = "AlbumId")
    @JsonIgnore
    private Album album;
    @ManyToOne
    @JoinColumn(name = "MediaTypeId")
    @JsonIgnore
    private MediaType mediaType;
    @ManyToOne
    @JoinColumn(name = "GenreId")
    @JsonIgnore
    private Genre genre;
    private String Composer;
    private int Milliseconds;
    private int Bytes;
    private float UnitPrice;
    @OneToMany(mappedBy = "track")
    List<Invoice_item> invoiceItems;
    @ManyToMany(mappedBy = "tracks")
    @JsonIgnore
    private List<Playlist> playlists;
}
