/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * OrderItem generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`order_item`")
public class OrderItem implements Serializable {

    private Integer id;
    private Integer orderId;
    private Integer item;
    private String quantity;
    private String itemNotes;
    private PackageEntity packageEntity;
    private Order _order;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`order_item_ID_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`order_id`", nullable = true, scale = 0, precision = 10)
    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Column(name = "`item`", nullable = true, scale = 0, precision = 10)
    public Integer getItem() {
        return this.item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    @Column(name = "`quantity`", nullable = true, length = 255)
    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Column(name = "`item_notes`", nullable = true, length = 255)
    public String getItemNotes() {
        return this.itemNotes;
    }

    public void setItemNotes(String itemNotes) {
        this.itemNotes = itemNotes;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`item`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_package_TO_order_itemN8mxU`"))
    @Fetch(FetchMode.JOIN)
    public PackageEntity getPackageEntity() {
        return this.packageEntity;
    }

    public void setPackageEntity(PackageEntity packageEntity) {
        if(packageEntity != null) {
            this.item = packageEntity.getId();
        }

        this.packageEntity = packageEntity;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`order_id`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_order_item_TO_order_oQt9rl`"))
    @Fetch(FetchMode.JOIN)
    public Order get_order() {
        return this._order;
    }

    public void set_order(Order _order) {
        if(_order != null) {
            this.orderId = _order.getId();
        }

        this._order = _order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        final OrderItem orderItem = (OrderItem) o;
        return Objects.equals(getId(), orderItem.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

