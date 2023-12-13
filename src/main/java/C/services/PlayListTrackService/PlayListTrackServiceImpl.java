package C.services.PlayListTrackService;

import C.entities.PlaysListTrack;
import C.entities.dtoEntitie.PlayListTrackDto;
import C.entities.dtoEntitie.PlaylistDto;
import C.entities.dtoEntitie.TrackDto;
import C.entities.transformations.PlayListTrackMapper.PlayListTrackDtoMapper;
import C.entities.transformations.PlayListTrackMapper.PlayListTrackMapper;
import C.repositories.PlayListTrackRepository;
import C.services.PlayListService.PlayListService;
import C.services.TrackService.TrackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PlayListTrackServiceImpl implements PlayListTrackService{
    private final PlayListTrackMapper playListTrackMapper;
    private final PlayListTrackDtoMapper playListTrackDtoMapper;
    private final PlayListTrackRepository playListTrackRepository;
    private final TrackService trackService;
    private final PlayListService playListService;

    public PlayListTrackServiceImpl(PlayListTrackService playListTrackService, TrackService trackService, PlayListTrackMapper playListTrackMapper, PlayListTrackDtoMapper playListTrackDtoMapper, PlayListTrackRepository playListTrackRepository, PlayListService playListService) {
        this.playListTrackMapper = playListTrackMapper;
        this.playListTrackDtoMapper = playListTrackDtoMapper;
        this.playListTrackRepository = playListTrackRepository;
        this.trackService = trackService;
        this.playListService = playListService;
    }
    @Override
    public void add(PlayListTrackDto entity) {
        Long trackId = entity.getTrackId();
        TrackDto trackDto = trackService.getById(trackId);
        Long playListId = entity.getPlaylistId();
        PlaylistDto playlistDto = playListService.getById(playListId);
        if(playlistDto == null || trackDto == null){
            return;
        }
        PlaysListTrack playsListTrack = new PlaysListTrack();
        playsListTrack.setTrackId(entity.getTrackId());
        playsListTrack.setPlaylistId(entity.getPlaylistId());
        playListTrackRepository.save(playsListTrack);
    }

    @Override
    public PlayListTrackDto getById(Long id) {
        Optional<PlaysListTrack> playsListTrack = playListTrackRepository.findById(id);
        return playsListTrack.map(playListTrackDtoMapper).orElseThrow();
    }

    @Override
    public List<PlayListTrackDto> getAll() {
        List<PlaysListTrack> values = playListTrackRepository.findAll();
        return values.stream().map(playListTrackDtoMapper).toList();
    }

    @Override
    public PlayListTrackDto delete(Long id) {
        Optional<PlaysListTrack> optionalPlaylist = playListTrackRepository.findById(id);
        optionalPlaylist.ifPresent(playListTrackRepository::delete);
        return optionalPlaylist.map(playListTrackDtoMapper).orElseThrow();
    }

    @Override
    public void update(PlayListTrackDto entity) {
        Long trackId = entity.getTrackId();
        TrackDto trackDto = trackService.getById(trackId);
        Long playListId = entity.getPlaylistId();
        PlaylistDto playlistDto = playListService.getById(playListId);
        if(playlistDto == null || trackDto == null){
            return;
        }
        Optional<PlaysListTrack> playsListTrack = Stream.of(entity)
                .map(playListTrackMapper)
                .findAny();
        playsListTrack.ifPresent(playListTrackRepository:: save);
    }
}
