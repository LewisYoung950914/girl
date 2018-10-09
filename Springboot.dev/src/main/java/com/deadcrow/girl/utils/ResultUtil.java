package com.deadcrow.girl.utils;

import com.deadcrow.girl.domain.Result;

public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(100001);
        result.setMsg("成功");
        result.setData(object);

        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result fail(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}
