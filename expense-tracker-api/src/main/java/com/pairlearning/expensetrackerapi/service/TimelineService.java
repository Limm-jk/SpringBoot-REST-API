package com.pairlearning.expensetrackerapi.service;

import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import com.pairlearning.expensetrackerapi.model.Timeline;
import com.pairlearning.expensetrackerapi.repository.TimelineRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;


@Component
public class TimelineService {

    private TimelineRepository timelineRepository;

    public TimelineService(TimelineRepository timelineRepository) {
        this.timelineRepository = timelineRepository;
    }

    public List<Timeline> getTimelineList() {
        List<Timeline> timelineList = StreamSupport.stream(timelineRepository.findAll().spliterator(), false).collect(Collectors.toList());

        return timelineList;
    }

    public void saveTimeline(Timeline timeline) {
        timelineRepository.save(timeline);
    }
}
