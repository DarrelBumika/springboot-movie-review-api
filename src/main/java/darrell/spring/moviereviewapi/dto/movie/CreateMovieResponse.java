package darrell.spring.moviereviewapi.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieResponse {

    private UUID id;
    private String title;
    private String director;

}
