package C.entities.dtoEntitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private Long albumId;
    private String title;
    private Long artistId;
}
