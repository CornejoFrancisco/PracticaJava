package C.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "albums", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="albums",
            initialValue=1, allocationSize=1)
    private int AlbumId;
    @ManyToOne
    @JoinColumn(name = "ArtistId")
    private Artist artist;
    private String Title;
    @OneToMany(mappedBy = "album")
    private List<Track> tracks;
}
