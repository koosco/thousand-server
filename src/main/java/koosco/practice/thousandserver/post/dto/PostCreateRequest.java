package koosco.practice.thousandserver.post.dto;

import koosco.practice.thousandserver.post.persistence.entity.Feeling;

public record PostCreateRequest(String title, String content, Feeling feeling) {
}
