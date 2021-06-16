package com.example.dnsapp.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class FileEventListener {

    @EventListener // 이벤트 관련 내용 상속 받지 않아도 스프링 이벤트에서 받을 수 있음
    public  void onFileEventHandler(FileEventService fileEvent)
    {
        log.info("fileEvent recive type :{} data: {}",fileEvent.getType(),fileEvent.getData());

        // 사용자에게 파일 업로드 완료 메시지를 전송하는 등 추가 작업
    }
}
