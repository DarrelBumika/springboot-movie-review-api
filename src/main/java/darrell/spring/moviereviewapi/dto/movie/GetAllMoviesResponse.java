package darrell.spring.moviereviewapi.dto.movie;

import darrell.spring.moviereviewapi.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMoviesResponse {

    private int total;
    private List<Movie> movies;

}
