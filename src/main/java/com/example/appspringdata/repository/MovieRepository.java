package com.example.appspringdata.repository;

import com.example.appspringdata.domain.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends Neo4jRepository<Movie, String> {

    @Query("MATCH (m:movie {movieId:$movieId}) SET imdbVotes = coalesce(imdbVotes+1,1) RETURN m")
    Movie updateMovieVotes(@Param("movieId") String movieId);

    Movie findByTitle(String title);
}
