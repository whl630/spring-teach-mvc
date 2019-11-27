package com.advice;

import com.vo.ResponseVO;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author cj
 * @date 2019/11/18
 */

//@RestControllerAdvice
public class SystemControllerAdvice2 {


    @ExceptionHandler(RuntimeException.class)
    public ResponseVO handleRuntimeException(RuntimeException re){
        ResponseVO responseVO = ResponseVO.fail(re.getMessage(), null);
        return responseVO;
    }
}
