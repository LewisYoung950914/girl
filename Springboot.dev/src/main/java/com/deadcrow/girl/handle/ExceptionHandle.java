package com.deadcrow.girl.handle;


import com.deadcrow.girl.domain.Result;
import com.deadcrow.girl.enums.ResultEnum;
import com.deadcrow.girl.exception.GirlException;
import com.deadcrow.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.fail(girlException.getCode(), girlException.getMessage());
        }
        else {
            logger.info("[系统异常]{}", e);
            return ResultUtil.fail(ResultEnum.UNKNOW_ERROR.getCode(), ResultEnum.UNKNOW_ERROR.getMsg());
        }

    }

}
