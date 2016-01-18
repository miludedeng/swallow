package cc.cafetime.module.customer.service;

import cc.cafetime.common.annotation.Transaction;
import cc.cafetime.common.bean.FileParam;
import cc.cafetime.common.helper.DatabaseHelper;
import cc.cafetime.common.helper.UploadHelper;
import cc.cafetime.module.customer.model.Customer;
import cc.cafetime.common.annotation.Service;
import java.util.List;
import java.util.Map;

/**
 * Created by liujing on 16/1/3.
 */
@Service
public class CustomerService {

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    public Customer getCustomer(long id) {
        return DatabaseHelper.findEntity(Customer.class, id);
    }

    /**
     * 创建客户
     */
    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap, FileParam fileParam) {
        boolean result = DatabaseHelper.insertEntity(Customer.class, fieldMap);
        if(result){
            UploadHelper.uploadFile("/tmp/upload", fileParam);
        }
        return result;
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
