package com.example.dnsapp.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void notifyComplete(FileEventService fileEvent)
    {
        applicationEventPublisher.publishEvent(fileEvent);
    }

    public void notifyError(FileEventService fileEvent)
    {
        applicationEventPublisher.publishEvent(fileEvent);
    }
}
