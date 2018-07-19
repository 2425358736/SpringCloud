package com.liuzhiqiang.saas.react.config.eorr;

import com.liuzhiqiang.saas.react.code.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SCKJ on 2017/12/8.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 系统异常处理，比如：404,500
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        CommonResult r = new CommonResult();
        r.setMessage(e.getMessage());
        logger.info(e.getMessage());
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            r.setCode(404);
            r.setData(e.getMessage());
        } else {
            if (e.getMessage().indexOf("Subject does not have permission")!=-1){
                    r.setCode(403);
                    r.setMessage("权限不足");
                r.setData(e.getMessage());
                } else if (e.getMessage().indexOf("Transaction rolled back because it has been marked as rollback-only")!=-1) {
                    r.setCode(180);
                    r.setMessage("系统异常,事务被回滚");
                } else {
                    r.setCode(500);
                    r.setMessage(e.getMessage());
                }
        }
        return r;
    }
}
