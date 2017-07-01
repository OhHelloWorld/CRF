package app.controller;

import app.Exception.RepeatAccountException;
import app.Exception.RepeatNameException;
import app.dto.ErrorDTO;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 52400 on 2017/6/20.
 */
@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(RepeatAccountException.class)
    @ResponseStatus
    @ResponseBody
    public ErrorDTO repeatAccountException(Exception e) {
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setErrorMessage(e.getMessage());
        return errorDto;
    }

    @ExceptionHandler(LockedAccountException.class)
    @ResponseStatus
    @ResponseBody
    public ErrorDTO lockedAccountException(Exception e) {
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setErrorMessage(e.getMessage());
        return errorDto;
    }

    @ExceptionHandler(UnknownAccountException.class)
    @ResponseStatus
    @ResponseBody
    public ErrorDTO unknownAccountException(Exception e) {
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setErrorMessage(e.getMessage());
        return errorDto;
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    @ResponseStatus
    @ResponseBody
    public ErrorDTO incorrectCredentialsException(Exception e) {
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setErrorMessage(e.getMessage());
        return errorDto;
    }

    @ExceptionHandler(RepeatNameException.class)
    @ResponseStatus
    @ResponseBody
    public ErrorDTO repeatNameException(Exception e) {
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setErrorMessage(e.getMessage());
        return errorDto;
    }
}
