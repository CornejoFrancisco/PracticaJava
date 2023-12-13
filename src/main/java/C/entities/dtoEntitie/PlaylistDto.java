package C.entities.dtoEntitie;

import C.entities.Track;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDto {
    private int PlayListId;
    private String Name;
    private List<Track> tracks;
}
