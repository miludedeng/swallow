package cc.cafetime.module.customer.controller;

import cc.cafetime.common.annotation.Action;
import cc.cafetime.common.annotation.Controller;
import cc.cafetime.common.annotation.Inject;
import cc.cafetime.common.bean.Data;
import cc.cafetime.common.bean.FileParam;
import cc.cafetime.common.bean.Param;
import cc.cafetime.common.bean.View;
import cc.cafetime.module.customer.model.Customer;
import cc.cafetime.module.customer.service.CustomerService;

import java.util.List;
import java.util.Map;

/**
 * Created by liujing on 16/1/9.
 */
@Controller
public class CustomerController {

    @Inject
    CustomerService customerService;
    /**
     * 进入客户列表界面
     */
    @Action("get:/customer")
    public View index(){
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList",customerList);
    }

    /**
     * 处理 创建客户 请求
     */
    @Action("post:/customer_create")
    public Data createSubmit(Param param){
        Map<String, Object> fieldMap = param.getFieldMap();
        FileParam fileParam = param.getFile("photo");
        boolean result = customerService.createCustomer(fieldMap,fileParam);
        return new Data(result);
    }
}
