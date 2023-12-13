package C.services.PlayListService;

import C.entities.Playlist;
import C.entities.dtoEntitie.PlaylistDto;
import C.entities.transformations.PlaylistMapper.PlayListDtoMapper;
import C.entities.transformations.PlaylistMapper.PlayListMapper;
import C.repositories.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PlayListServiceImpl implements PlayListService{
    private final PlayListDtoMapper playListDtoMapper;
    private final PlayListMapper playListMapper;
    private final PlaylistRepository playlistRepository;

    public PlayListServiceImpl(PlayListDtoMapper playListDtoMapper, PlayListMapper playListMapper, PlaylistRepository playlistRepository) {
        this.playListDtoMapper = playListDtoMapper;
        this.playListMapper = playListMapper;
        this.playlistRepository = playlistRepository;
    }
    @Override
    public void add(PlaylistDto entity) {
        Playlist playlist = new Playlist();
        playlist.setTracks(new ArrayList<>());
        playlist.setName(entity.getName());
        playlistRepository.save(playlist);
    }

    @Override
    public PlaylistDto getById(Long id) {
        Optional<Playlist> customer = playlistRepository.findById(id);
        return customer.map(playListDtoMapper).orElseThrow();
    }

    @Override
    public List<PlaylistDto> getAll() {
        List<Playlist> values = playlistRepository.findAll();
        return values.stream().map(playListDtoMapper).toList();
    }

    @Override
    public PlaylistDto delete(Long id) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);
        optionalPlaylist.ifPresent(playlistRepository::delete);
        return optionalPlaylist.map(playListDtoMapper).orElseThrow();
    }

    @Override
    public void update(PlaylistDto entity) {
        Optional<Playlist> playlist = Stream.of(entity)
                .map(playListMapper)
                .findAny();
        playlist.ifPresent(playlistRepository:: save);
    }
}
