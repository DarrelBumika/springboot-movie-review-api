package darrell.spring.moviereviewapi.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieRequest {

    private String title;
    private int releaseYear;
    private String synopsis;
    private String director;

}
