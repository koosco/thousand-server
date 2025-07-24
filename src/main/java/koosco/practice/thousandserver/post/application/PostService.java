package koosco.practice.thousandserver.post.application;

import koosco.practice.thousandserver.post.dto.PostCreateRequest;
import koosco.practice.thousandserver.post.dto.PostResponse;
import koosco.practice.thousandserver.post.persistence.entity.Post;
import koosco.practice.thousandserver.post.persistence.jpa.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void createPost(PostCreateRequest request) {
        Post post = Post.create(request.title(), request.content(), request.feeling());
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> fetchAll() {
        return postRepository.findAll().stream()
                .map(post -> PostResponse.from(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getFeeling()
                ))
                .toList();
    }

    @Transactional(readOnly = true)
    public PostResponse fetch(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + id));
        return PostResponse.from(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getFeeling()
        );
    }
}
