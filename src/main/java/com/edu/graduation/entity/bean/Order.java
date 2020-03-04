package com.edu.graduation.entity.bean;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * (Order)表实体类
 *
 * @author qiu
 * @version 1.0
 * @since 2020/2/22 12:18
 */
@Data
@Table(name = "order")
public class Order {

    
    @Id
    private String orderId;

    
    private Integer storeId;

    
    private String userId;

    
    private Double total;

    
    private Date date;

    
    private Integer status;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}