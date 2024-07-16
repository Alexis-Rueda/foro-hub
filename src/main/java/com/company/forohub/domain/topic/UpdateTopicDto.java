package com.company.forohub.domain.topic;

import jakarta.validation.constraints.NotNull;

public record UpdateTopicDto(@NotNull Long id,
                             String title,
                             String message,
                             Long courseId) {
}
