/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wavemaker.runtime.data.annotations.WMValueInject;
import com.wavemaker.runtime.data.replacers.Scope;
import com.wavemaker.runtime.data.replacers.providers.VariableType;

/**
 * Order generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`order`")
public class Order implements Serializable {

    private Integer id;
    private String orderNumber;
    private Integer salesId;
    private Integer customerId;
    private String orderNotes;
    private Boolean approval1;
    private Boolean approval2;
    @WMValueInject( type = VariableType.SERVER, name = "DATE", scopes = { Scope.INSERT, Scope.UPDATE })
    private Date orderCreateDate;
    private Date orderDueDate;
    private Time orderTime;
    private Customer customer;
    private User user;
    private List<OrderItem> orderItems;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`order_ID_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`order_number`", nullable = true, length = 255)
    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Column(name = "`sales_id`", nullable = true, scale = 0, precision = 10)
    public Integer getSalesId() {
        return this.salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    @Column(name = "`customer_id`", nullable = true, scale = 0, precision = 10)
    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name = "`order_notes`", nullable = true, length = 255)
    public String getOrderNotes() {
        return this.orderNotes;
    }

    public void setOrderNotes(String orderNotes) {
        this.orderNotes = orderNotes;
    }

    @Column(name = "`approval_1`", nullable = true)
    public Boolean getApproval1() {
        return this.approval1;
    }

    public void setApproval1(Boolean approval1) {
        this.approval1 = approval1;
    }

    @Column(name = "`approval_2`", nullable = true)
    public Boolean getApproval2() {
        return this.approval2;
    }

    public void setApproval2(Boolean approval2) {
        this.approval2 = approval2;
    }

    @Column(name = "`order_create_date`", nullable = true)
    public Date getOrderCreateDate() {
        return this.orderCreateDate;
    }

    public void setOrderCreateDate(Date orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    @Column(name = "`order_due_date`", nullable = true)
    public Date getOrderDueDate() {
        return this.orderDueDate;
    }

    public void setOrderDueDate(Date orderDueDate) {
        this.orderDueDate = orderDueDate;
    }

    @Column(name = "`order_time`", nullable = true)
    public Time getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`customer_id`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_customer_TO_order_ID_0190k`"))
    @Fetch(FetchMode.JOIN)
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        if(customer != null) {
            this.customerId = customer.getId();
        }

        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`sales_id`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_user_TO_order_ID_sales_id`"))
    @Fetch(FetchMode.JOIN)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        if(user != null) {
            this.salesId = user.getId();
        }

        this.user = user;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "_order")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @PostPersist
    public void onPostPersist() {
        if(orderItems != null) {
            for(OrderItem orderItem : orderItems) {
                orderItem.set_order(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        final Order _order = (Order) o;
        return Objects.equals(getId(), _order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

