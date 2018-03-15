/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
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
 * PackageEntity generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`package`")
public class PackageEntity implements Serializable {

    private Integer id;
    private Integer staffId;
    @WMValueInject( type = VariableType.SERVER, name = "DATE", scopes = { Scope.INSERT, Scope.UPDATE })
    private Date createdDate;
    private Integer product1;
    private Integer product2;
    private Integer product3;
    private Integer product4;
    private Integer product5;
    private Integer rating;
    private String price;
    private String packCode;
    private String packName;
    private String packDescription;
    private User user;
    private Products productsByProduct1;
    private Products productsByProduct2;
    private Products productsByProduct3;
    private Products productsByProduct4;
    private Products productsByProduct5;
    private List<OrderItem> orderItems;
    private List<PreOrder> preOrders;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`package_ID_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`staff_id`", nullable = true, scale = 0, precision = 10)
    public Integer getStaffId() {
        return this.staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Column(name = "`created_date`", nullable = true)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "`product_1`", nullable = true, scale = 0, precision = 10)
    public Integer getProduct1() {
        return this.product1;
    }

    public void setProduct1(Integer product1) {
        this.product1 = product1;
    }

    @Column(name = "`product_2`", nullable = true, scale = 0, precision = 10)
    public Integer getProduct2() {
        return this.product2;
    }

    public void setProduct2(Integer product2) {
        this.product2 = product2;
    }

    @Column(name = "`product_3`", nullable = true, scale = 0, precision = 10)
    public Integer getProduct3() {
        return this.product3;
    }

    public void setProduct3(Integer product3) {
        this.product3 = product3;
    }

    @Column(name = "`product_4`", nullable = true, scale = 0, precision = 10)
    public Integer getProduct4() {
        return this.product4;
    }

    public void setProduct4(Integer product4) {
        this.product4 = product4;
    }

    @Column(name = "`product_5`", nullable = true, scale = 0, precision = 10)
    public Integer getProduct5() {
        return this.product5;
    }

    public void setProduct5(Integer product5) {
        this.product5 = product5;
    }

    @Column(name = "`rating`", nullable = true, scale = 0, precision = 10)
    public Integer getRating() {
        return this.rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Column(name = "`price`", nullable = true, length = 255)
    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Column(name = "`pack_code`", nullable = false, length = 255)
    public String getPackCode() {
        return this.packCode;
    }

    public void setPackCode(String packCode) {
        this.packCode = packCode;
    }

    @Column(name = "`pack_name`", nullable = false, length = 255)
    public String getPackName() {
        return this.packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    @Column(name = "`pack_description`", nullable = true, length = 255)
    public String getPackDescription() {
        return this.packDescription;
    }

    public void setPackDescription(String packDescription) {
        this.packDescription = packDescription;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`staff_id`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_user_TO_package_ID_stxRVpR`"))
    @Fetch(FetchMode.JOIN)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        if(user != null) {
            this.staffId = user.getId();
        }

        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`product_1`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_products_TO_package_I8gsnp`"))
    @Fetch(FetchMode.JOIN)
    public Products getProductsByProduct1() {
        return this.productsByProduct1;
    }

    public void setProductsByProduct1(Products productsByProduct1) {
        if(productsByProduct1 != null) {
            this.product1 = productsByProduct1.getId();
        }

        this.productsByProduct1 = productsByProduct1;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`product_2`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_products_TO_package_IrOAWL`"))
    @Fetch(FetchMode.JOIN)
    public Products getProductsByProduct2() {
        return this.productsByProduct2;
    }

    public void setProductsByProduct2(Products productsByProduct2) {
        if(productsByProduct2 != null) {
            this.product2 = productsByProduct2.getId();
        }

        this.productsByProduct2 = productsByProduct2;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`product_3`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_products_TO_package_IUFcYq`"))
    @Fetch(FetchMode.JOIN)
    public Products getProductsByProduct3() {
        return this.productsByProduct3;
    }

    public void setProductsByProduct3(Products productsByProduct3) {
        if(productsByProduct3 != null) {
            this.product3 = productsByProduct3.getId();
        }

        this.productsByProduct3 = productsByProduct3;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`product_4`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_products_TO_package_IvsbFL`"))
    @Fetch(FetchMode.JOIN)
    public Products getProductsByProduct4() {
        return this.productsByProduct4;
    }

    public void setProductsByProduct4(Products productsByProduct4) {
        if(productsByProduct4 != null) {
            this.product4 = productsByProduct4.getId();
        }

        this.productsByProduct4 = productsByProduct4;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`product_5`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_products_TO_package_IecQzK`"))
    @Fetch(FetchMode.JOIN)
    public Products getProductsByProduct5() {
        return this.productsByProduct5;
    }

    public void setProductsByProduct5(Products productsByProduct5) {
        if(productsByProduct5 != null) {
            this.product5 = productsByProduct5.getId();
        }

        this.productsByProduct5 = productsByProduct5;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "packageEntity")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "packageEntity")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<PreOrder> getPreOrders() {
        return this.preOrders;
    }

    public void setPreOrders(List<PreOrder> preOrders) {
        this.preOrders = preOrders;
    }

    @PostPersist
    public void onPostPersist() {
        if(orderItems != null) {
            for(OrderItem orderItem : orderItems) {
                orderItem.setPackageEntity(this);
            }
        }
        if(preOrders != null) {
            for(PreOrder preOrder : preOrders) {
                preOrder.setPackageEntity(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackageEntity)) return false;
        final PackageEntity packageEntity = (PackageEntity) o;
        return Objects.equals(getId(), packageEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

