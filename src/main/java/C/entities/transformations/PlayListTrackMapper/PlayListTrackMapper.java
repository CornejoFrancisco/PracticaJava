package C.entities.transformations.PlayListTrackMapper;

import C.entities.dtoEntitie.PlayListTrackDto;
import C.entities.PlaysListTrack;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class PlayListTrackMapper implements Function<PlayListTrackDto, PlaysListTrack> {
    @Override
    public PlaysListTrack apply(PlayListTrackDto playListTrackDto) {
        return new PlaysListTrack(
                playListTrackDto.getPlaylistId(),
                playListTrackDto.getTrackId()
        );
    }
}
