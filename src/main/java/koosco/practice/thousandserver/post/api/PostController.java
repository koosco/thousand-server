package koosco.practice.thousandserver.post.api;

import koosco.practice.thousandserver.post.application.PostService;
import koosco.practice.thousandserver.post.dto.PostCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostCreateRequest request) {
        postService.createPost(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getPosts() {
        return ResponseEntity.ok(postService.fetchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.fetch(id));
    }
}
