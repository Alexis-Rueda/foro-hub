package com.company.forohub.domain.topic;

import java.time.LocalDateTime;

public record TopicDto(
        Long id,
        String title,
        String message,
        LocalDateTime creation_date,
        Long courseId,
        String userName,
        String userEmail
) {
    public TopicDto(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreation_date(),
                topic.getCourse_Id(), topic.getUser().getName(), topic.getUser().getEmail());
    }
}
