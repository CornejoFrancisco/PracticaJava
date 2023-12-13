package C.entities.transformations.TracksArtisGenMapper;

import C.entities.dtoEntitie.TracksArtisGenDto;
import C.entities.TracksArtisGen;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TrackArtisGenDtoMapper implements Function<TracksArtisGen, TracksArtisGenDto> {
    @Override
    public TracksArtisGenDto apply(TracksArtisGen tracksArtisGen){
        return new TracksArtisGenDto(
                tracksArtisGen.getTrackId(),
                tracksArtisGen.getTrackName(),
                tracksArtisGen.getAlbumName(),
                tracksArtisGen.getArtistName(),
                tracksArtisGen.getMiliSeconds()
        );
    }
}
