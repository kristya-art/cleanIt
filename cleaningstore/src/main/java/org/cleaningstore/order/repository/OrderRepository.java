package org.cleaningstore.order.repository;

import org.cleaningstore.order.model.Order;
import org.cleaningstore.order.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<OrderInfo> findByCustomerIdAndDateBetween(long customerId, Date startDate, Date endDate);
    List<OrderInfo> findByCustomerId(long customerId);
}
