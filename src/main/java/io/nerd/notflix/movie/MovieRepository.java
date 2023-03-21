package io.nerd.notflix.movie;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> findByImdbId(String imdbId);
}
