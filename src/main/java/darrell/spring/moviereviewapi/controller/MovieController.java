package darrell.spring.moviereviewapi.controller;

import darrell.spring.moviereviewapi.dto.movie.*;
import darrell.spring.moviereviewapi.entity.Movie;
import darrell.spring.moviereviewapi.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<DeleteMovieResponse> deleteMovie(@RequestParam UUID id) {
        final UUID deletedId = movieService.deleteMovie(id);

        return ResponseEntity.ok(new DeleteMovieResponse(
                deletedId
        ));
    }

    @PutMapping("/update")
    public String updateMovie() {
        return "Hello, Movie Review API!";
    }

}
