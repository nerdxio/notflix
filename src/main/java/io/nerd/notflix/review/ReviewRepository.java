/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 3/21/2023 9:39 PM
 */
package io.nerd.notflix.review;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
