package mySpringStudy.core.web;


import lombok.RequiredArgsConstructor;
import mySpringStudy.core.common.MyLogger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;
    public void logic(String testId) {
        myLogger.log("service id = " + testId);
    }
}
