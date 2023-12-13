package C.entities.dtoEntitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayListTrackDto {
    private long playlistId;
    private long trackId;
}
