package com.imooc.order.mapper;

import com.imooc.order.model.OrderMasterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface OrderMasterMapper extends JpaRepository<OrderMasterModel, String> {




}
