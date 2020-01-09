package com.wqwy.zhnm.seller.controller.advice;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

/**
 * 全局异常处理类,处理系统内所有异常,并给客户端相关的响应.
 */
@ControllerAdvice
public class RestControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(RestControllerAdvice.class);

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public JsonResponse<?> handleBusinessException(BusinessException ex, HttpServletResponse response) {
        logger.error(ex.getMessage(),ex);
        return new JsonResponse<>(ex.getCode(),ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonResponse<?> handleAException(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage(),ex);
        if(ex.getBindingResult() != null
        		&& !ex.getBindingResult().getAllErrors().isEmpty()
        		&& StringUtils.isNotBlank(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage())){
        	 return new JsonResponse<>(ResultUtils.BAD_REQUEST_TO_OBSERVER, ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        }else{
        	return new JsonResponse<>(ResultUtils.BAD_REQUEST_TO_OBSERVER, ResultUtils.BAD_REQUEST_TO_OBSERVER_MSG);
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public JsonResponse<?> handleException(Exception ex) {
        logger.error(ex.getMessage(),ex);
        return new JsonResponse<>(ResultUtils.ERROR_CONNECT_TO_OBSERVER, ResultUtils.ERROR_CONNECT_TO_OBSERVER_MSG);
    }
}
