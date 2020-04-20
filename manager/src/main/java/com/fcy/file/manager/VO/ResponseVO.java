package com.fcy.file.manager.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.logging.Logger;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {
    public static final int SUCCESS=200;
    public static final int ERROR=400;
    public static final int WARNING=300;
    private int code;
    private String msg;
    private Object data;
    public ResponseVO(int code){
        this.code=code;
    }
    public ResponseVO(String msg){
        this.msg=msg;
    }
    public ResponseVO(Object data){
        this.data=data;
    }
    public ResponseVO msg(String msg){
        this.msg=msg;
        return this;
    }
    public ResponseVO data(Object data){
        this.data=data;
        return this;
    }
    public ResponseVO code(int code){
        this.code=code;
        return this;
    }
    public static ResponseVO success(){
        return new ResponseVO(SUCCESS);
    }
    public static ResponseVO error(){
        return new ResponseVO(ERROR);
    }
    public static ResponseVO warning(){
        return new ResponseVO(WARNING);
    }
}
