package com.company.forohub.domain.topic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterTopicDto(@NotBlank
                               String title,
                               @NotBlank
                               String message,
                               @NotNull @Valid
                               Long courseId,
                               @NotNull @Valid
                               Long userId) {
}
