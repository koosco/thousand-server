package koosco.practice.thousandserver.post.dto;

import koosco.practice.thousandserver.post.persistence.entity.Feeling;

public record PostResponse(Long id, String title, String content, Feeling feeling) {

    public static PostResponse from(Long id, String title, String content, Feeling feeling) {
        return new PostResponse(id, title, content, feeling);
    }
}
