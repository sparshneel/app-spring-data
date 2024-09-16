interface MovieRepository extends Neo4jRepository<Movie, String> {

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(p:Person)" +
            "RETURN m, collect(r), collect(p) LIMIT 50;")
    Iterable<Movie> findMoviesSubset();

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(p:Person {name: $name})" +
            "RETURN m, collect(r), collect(p);")
    Iterable<Movie> findMoviesByPerson(String name);

    @Query("MERGE (m:Movie {movieId: $movie.__id__})" +
            "SET m += $movie.__properties__, m.lastUpdated = datetime()" +
            "RETURN m;")
    Movie saveWithAudit(Movie movie);
}

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final com.example.appspringdata.MovieRepository movieRepo;

    public MovieController(com.example.appspringdata.MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @GetMapping()
    Iterable<Movie> findAllMovies() {
        return movieRepo.findMoviesSubset();
    }

    @GetMapping("/{movieId}")
    Optional<Movie> findMovieById(@PathVariable String movieId) {
        return movieRepo.findById(movieId);
    }

    @PostMapping("/save")
    Movie save(@RequestBody Movie movie) {
        return movieRepo.save(movie);
    }

    @GetMapping("/person")
    Iterable<Movie> findMoviesByPerson(@RequestParam String name) {
        return movieRepo.findMoviesByPerson(name);
    }

    @PostMapping("/saveaudit")
    Movie saveWithAudit(@RequestBody Movie movie) {
        return movieRepo.saveWithAudit(movie);
    }
}