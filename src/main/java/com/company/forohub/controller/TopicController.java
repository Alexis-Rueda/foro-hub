package com.company.forohub.controller;

import com.company.forohub.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDto> registerTopic(@RequestBody @Valid RegisterTopicDto dto,
                                                  UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicService.registerTopic(dto);
        var uri = uriComponentsBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }

    @GetMapping
    public ResponseEntity<Page<TopicDto>> getAllTopics(@PageableDefault(size = 5) Pageable pageable) {
        var topics = topicService.getAllTopics(pageable);
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDto> getTopicById(@PathVariable Long id) {
        Topic topic = topicService.getTopicById(id);
        return ResponseEntity.ok(new TopicDto(topic));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TopicDto> updateTopic(@RequestBody @Valid UpdateTopicDto dto) {
        Topic topic = topicService.updateTopic(dto);
        return ResponseEntity.ok(new TopicDto(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        Topic topic = topicService.getTopicById(id);
        return topicService.deleteTopic(topic);
    }

}
