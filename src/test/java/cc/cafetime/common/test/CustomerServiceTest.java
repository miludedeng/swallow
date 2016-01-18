package cc.cafetime.common.test;

import cc.cafetime.model.Customer;
import cc.cafetime.service.CustomerService;
import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by liujing on 16/1/3.
 */
public class CustomerServiceTest extends Assert {
    private final CustomerService customerService;

    public CustomerServiceTest(){
        customerService = new CustomerService();
    }

    @Before
    public void init(){
        // TODO: 16/1/3 初始化数据库
    }

    @Test
    public void getCustomerListTest() {
        List<Customer> customerList = customerService.getCustomerList();
        assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest(){
        long id=1;
        Customer customer = customerService.getCustomer(id);
        assertNotNull(customer);
    }

    @Test
    public void createCustomerTest(){
        Map<String, Object> fieldMap = Maps.newHashMap();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","John");
        fieldMap.put("telephone","13512345678");
        boolean result = customerService.createCustomer(fieldMap);
        assertTrue(result);
    }

    @Test
    public void updateCustomerTest(){
        long id = 1;
        Map<String, Object> fieldMap = Maps.newHashMap();
        fieldMap.put("contact","Eric");
        boolean result = customerService.updateCustomer(id,fieldMap);
        assertTrue(result);
    }

    @Test
    public void deleteCustomerTest(){
        long id = 1;
        boolean result  = customerService.deleteCustomer(id);
        assertTrue(result);
    }
}
