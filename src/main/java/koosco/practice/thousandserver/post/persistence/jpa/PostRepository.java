package koosco.practice.thousandserver.post.persistence.jpa;

import koosco.practice.thousandserver.post.persistence.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
