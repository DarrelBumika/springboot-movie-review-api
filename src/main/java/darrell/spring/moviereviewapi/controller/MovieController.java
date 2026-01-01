package darrell.spring.moviereviewapi.controller;

import darrell.spring.moviereviewapi.dto.movie.CreateMovieRequest;
import darrell.spring.moviereviewapi.dto.movie.CreateMovieResponse;
import darrell.spring.moviereviewapi.dto.movie.GetAllMoviesResponse;
import darrell.spring.moviereviewapi.entity.Movie;
import darrell.spring.moviereviewapi.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<GetAllMoviesResponse> getMovies() {
        final List<Movie> movieList = movieService.getAllMovies();

        return ResponseEntity.ok(new GetAllMoviesResponse(
                movieList.size(),
                movieList
        ));
    }

    @PostMapping("/create")
    public ResponseEntity<CreateMovieResponse> createMovie(@RequestBody CreateMovieRequest request) {
        final Movie newMovie = movieService.createMovie(new Movie(
                null,
                request.getTitle(),
                request.getReleaseYear(),
                request.getSynopsis(),
                request.getDirector()
        ));

        return ResponseEntity.ok(new CreateMovieResponse(
                newMovie.getId(),
                newMovie.getTitle(),
                newMovie.getDirector()
        ));
    }

    @DeleteMapping("/delete")
    public String deleteMovie() {
        return "Hello, Movie Review API!";
    }

    @PutMapping("/update")
    public String updateMovie() {
        return "Hello, Movie Review API!";
    }

}
