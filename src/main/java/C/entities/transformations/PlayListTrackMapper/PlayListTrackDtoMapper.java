package C.entities.transformations.PlayListTrackMapper;

import C.entities.dtoEntitie.PlayListTrackDto;
import C.entities.PlaysListTrack;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class PlayListTrackDtoMapper implements Function<PlaysListTrack, PlayListTrackDto> {
    @Override
    public PlayListTrackDto apply(PlaysListTrack playsListTrack) {
        return new PlayListTrackDto(
                playsListTrack.getPlaylistId(),
                playsListTrack.getTrackId()
        );
    }
}
