package com.example.dnsapp.event;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
@Builder
public class FileEventService {
    private String eventId;
    private String type;
    private Map<String,Object> data;

    public static FileEventService toCompleteEvent(Map data)
    {
        return FileEventService.builder()
                .eventId(UUID.randomUUID().toString())
                .type(EventType.COMPLETE.name())
                .data(data)
                .build();
    }

    public static FileEventService toErrorEvent(Map data)
    {
        return FileEventService.builder()
                .eventId(UUID.randomUUID().toString())
                .type(EventType.ERROR.name())
                .data(data)
                .build();
    }
}
