package com.simonwinther.Refresh.dto;

import lombok.Builder;

@Builder
public record ShortUrlDTO(String slug, String redirectUrl) {
}
