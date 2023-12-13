package C.entities.transformations.PlaylistMapper;

import C.entities.Playlist;
import C.entities.dtoEntitie.PlaylistDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PlayListMapper implements Function<PlaylistDto, Playlist> {
    @Override
    public Playlist apply(PlaylistDto playlistDto) {
        return new Playlist(playlistDto.getPlayListId(),
                playlistDto.getName(),
                playlistDto.getTracks());
    }
}
