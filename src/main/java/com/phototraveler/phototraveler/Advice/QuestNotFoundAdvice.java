package com.phototraveler.phototraveler.Advice;

import com.phototraveler.phototraveler.Exception.QuestNotFoundException;
import com.phototraveler.phototraveler.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class QuestNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String QuestNotFoundHandler(QuestNotFoundException ex){ return ex.getMessage();}
}
