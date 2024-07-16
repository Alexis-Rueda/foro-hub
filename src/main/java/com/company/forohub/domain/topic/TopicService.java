package com.company.forohub.domain.topic;

import com.company.forohub.domain.user.User;
import com.company.forohub.domain.user.UserRepository;
import com.company.forohub.infra.errors.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private UserRepository userRepository;

    public Topic registerTopic(RegisterTopicDto dto){
        if(userRepository.findById(dto.userId()).isEmpty()){
            throw new IntegrityValidation("Usuario no encontrado");
        }

        User user = userRepository.getReferenceById(dto.userId());
        Topic topic = new Topic(
                dto.title(),
                dto.message(),
                user,
                dto.courseId()
        );
        topicRepository.save(topic);
        return topic;
    }

    public Page<TopicDto> getAllTopics(Pageable pageable) {
        return topicRepository.findAll(pageable).map(TopicDto::new);
    }

    public Topic getTopicById(Long id) {
        return topicRepository.getReferenceById(id);
    }

    public Topic updateTopic(UpdateTopicDto dto) {
        Topic topic = getTopicById(dto.id());
        topic.update(dto);
        return topic;
    }

    public ResponseEntity<Object> deleteTopic(Topic topic) {
        Topic topico = topicRepository.findById(topic.getId()).orElse(null);
        if (topico == null) {
            return ResponseEntity.notFound().build();
        }
        topicRepository.delete(topico);
        return ResponseEntity.noContent().build();

    }
}
