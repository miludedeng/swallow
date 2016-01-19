package cc.cafetime.module.sys.controller;

import cc.cafetime.common.annotation.Action;
import cc.cafetime.common.annotation.Controller;
import cc.cafetime.common.annotation.Module;
import cc.cafetime.common.bean.View;

/**
 * Created by steven on 16/1/19.
 */
@Controller
@Module("sys")
public class ApplicationController {

    @Action("get:/")
    public View index(){
        return new View("application.jsp");
    }
}
