package C.entities.transformations.TracksArtisGenMapper;

import C.entities.TracksArtisGen;
import C.entities.dtoEntitie.TracksArtisGenDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TrackArtisGenMapper implements Function<TracksArtisGenDto, TracksArtisGen> {
    @Override
    public TracksArtisGen apply(TracksArtisGenDto tracksArtisGenDto) {
        return new TracksArtisGen(
                tracksArtisGenDto.getTrackId(),
                tracksArtisGenDto.getTrackName(),
                tracksArtisGenDto.getAlbumName(),
                tracksArtisGenDto.getArtistName(),
                tracksArtisGenDto.getMiliSeconds()
        );
    }
}
