package C.entities.transformations.PlaylistMapper;

import C.entities.Playlist;
import C.entities.dtoEntitie.PlaylistDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PlayListDtoMapper implements Function<Playlist, PlaylistDto> {
    @Override
    public PlaylistDto apply(Playlist playlist) {
        return new PlaylistDto(
                playlist.getPlaylistId(),
                playlist.getName(),
                playlist.getTracks()
        );
    }
}
