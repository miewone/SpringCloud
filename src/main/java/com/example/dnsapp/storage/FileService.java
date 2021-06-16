package com.example.dnsapp.storage;

import com.example.dnsapp.event.FileEventPublisher;
import com.example.dnsapp.event.FileEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

    private final FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String,Object> data)
    {
        try {
            log.info("파일 복사 완료");
            log.info("db 파일 메타 정보 저장 완료");
            FileEventService completeEvent = FileEventService.toCompleteEvent(data);
            fileEventPublisher.notifyComplete(completeEvent);
        }catch (Exception e)
        {
            log.error("file upload fail ",e);
            FileEventService errorEvent = FileEventService.toErrorEvent(data);
            fileEventPublisher.notifyError(errorEvent);
        }
    }
}
