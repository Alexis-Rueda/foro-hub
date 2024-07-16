package com.company.forohub.domain.topic;

import com.company.forohub.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;

    @CreationTimestamp
    private LocalDateTime creation_date;
    private boolean status;
    private Long course_Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id")
    private User user;

    public Topic(String title, String message, User user, Long courseId) {
        this.title = title;
        this.message = message;
        this.creation_date = LocalDateTime.now();
        this.status = true;
        this.course_Id = courseId;
        this.user = user;
    }

    public void update(UpdateTopicDto dto) {
        if (dto.title() != null) {
            this.title = dto.title();
        }

        if (dto.message() != null) {
            this.message = dto.message();
        }

        if (dto.courseId() != null) {
            this.course_Id = dto.courseId();
        }
    }
}

