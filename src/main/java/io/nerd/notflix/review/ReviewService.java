/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 3/21/2023 9:39 PM
 */
package io.nerd.notflix.review;

import io.nerd.notflix.movie.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    private final MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        var review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }

}
