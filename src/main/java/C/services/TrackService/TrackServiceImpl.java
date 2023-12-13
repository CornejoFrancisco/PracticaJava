package C.services.TrackService;

import C.entities.Track;
import C.entities.dtoEntitie.AlbumDto;
import C.entities.dtoEntitie.GenreDto;
import C.entities.dtoEntitie.MediaTypeDto;
import C.entities.dtoEntitie.TrackDto;
import C.entities.transformations.TrackMapper.TrackDtoMapper;
import C.entities.transformations.TrackMapper.TrackMapper;
import C.repositories.AlbumRepository;
import C.repositories.GenreRepository;
import C.repositories.MediaTypeRepository;
import C.repositories.TrackRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TrackServiceImpl implements TrackService{
    private final TrackMapper trackMapper;
    private final TrackDtoMapper trackDtoMapper;
    private final TrackRepository trackRepository;

    private final AlbumRepository albumRepository;
    private final GenreRepository genreRepository;
    private final MediaTypeRepository mediaTypeRepository;

    public TrackServiceImpl(TrackMapper trackMapper, TrackDtoMapper trackDtoMapper, TrackRepository trackRepository, AlbumRepository albumRepository, GenreRepository genreRepository, MediaTypeRepository mediaTypeRepository) {
        this.trackMapper = trackMapper;
        this.trackDtoMapper = trackDtoMapper;
        this.trackRepository = trackRepository;

        this.albumRepository = albumRepository;
        this.genreRepository = genreRepository;
        this.mediaTypeRepository = mediaTypeRepository;
    }



    @Override
    public void add(TrackDto entity) {
        Track track = new Track();
        track.setName(entity.getName());
        albumRepository.getReferenceById(entity.getAlbumId());
        mediaTypeRepository.getReferenceById(entity.getMediaTypeId());
        genreRepository.getReferenceById(entity.getGenreId());
        track.setComposer(entity.getComposer());
        track.setMilliseconds(entity.getMilliseconds());
        track.setBytes(entity.getBytes());
        track.setUnitPrice(entity.getUnitPrice());
        track.setInvoiceItems(new ArrayList<>());
        track.setPlaylists(new ArrayList<>());
        trackRepository.save(track);
    }

    @Override
    public TrackDto getById(Long id) {
        Optional<Track> customer = trackRepository.findById(id);
        return customer.map(trackDtoMapper).orElseThrow();
    }

    @Override
    public List<TrackDto> getAll() {
        List<Track> values = trackRepository.findAll();
        return values.stream().map(trackDtoMapper).toList();
    }

    @Override
    public TrackDto delete(Long id) {
        Optional<Track> optionalTrack = trackRepository.findById(id);
        optionalTrack.ifPresent(trackRepository::delete);
        return optionalTrack.map(trackDtoMapper).orElseThrow();
    }

    @Override
    public void update(TrackDto entity) {
        Optional<Track> track = Stream.of(entity)
                .map(trackMapper)
                .findAny();
        track.ifPresent(trackRepository:: save);
    }

    @Override
    public List<TrackDto> getTracksByArtistAndGenre(Long artistId, Long genreId) {
        return null;
    }
}
