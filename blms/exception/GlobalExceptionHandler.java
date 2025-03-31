package com.ysj.blms.exception;

import com.ysj.blms.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody//返回json格式的数据
    public ResultVo error(Exception e){
        e.printStackTrace();
        return ResultVo.error(e.getMessage());
    }
}
//统一异常处理
//全局异常处理