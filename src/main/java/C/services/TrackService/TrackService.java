package C.services.TrackService;

import C.entities.dtoEntitie.TrackDto;
import C.services.Service;

import java.util.List;

public interface TrackService extends Service<TrackDto, Long> {
    List<TrackDto> getTracksByArtistAndGenre(Long artistId, Long genreId);
}
