package darrell.spring.moviereviewapi.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMovieResponse {

    private UUID id;
    private String title;
    private int releaseYear;
    private String synopsis;
    private String director;

}
