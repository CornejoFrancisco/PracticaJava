
package C.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "playlist_track")
public class PlaysListTrack {

    @Column(name = "PlaylistId")
    private long playlistId;
    @Column(name = "TrackId")
    private long trackId;


}
