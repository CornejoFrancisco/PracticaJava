package C.entities.transformations.TrackMapper;

import C.entities.Track;
import C.entities.dtoEntitie.TrackDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TrackDtoMapper implements Function<Track, TrackDto> {
    @Override
    public TrackDto apply(Track track) {
        return new TrackDto(
                track.getTrackId(),
                track.getName(),
                track.getAlbum().getAlbumId(),
                track.getMediaType().getMediaTypeId(),
                track.getGenre().getGenreId(),
                track.getComposer(),
                track.getMilliseconds(),
                track.getBytes(),
                track.getUnitPrice(),
                track.getInvoiceItems(),
                track.getPlaylists());

    }
}
