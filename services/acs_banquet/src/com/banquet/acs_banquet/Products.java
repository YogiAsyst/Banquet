/*Copyright (c) 2017-2018 asyst.co.id All Rights Reserved.
 This software is the confidential and proprietary information of asyst.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with asyst.co.id*/
package com.banquet.acs_banquet;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Products generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`products`")
public class Products implements Serializable {

    private Integer id;
    private String pname;
    private String pdescription;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] ppicture;
    private Integer prating;
    private Integer pcatagory;
    private Integer pcode;
    private Category category;
    private List<PackageEntity> packageEntitiesForProduct1;
    private List<PackageEntity> packageEntitiesForProduct2;
    private List<PackageEntity> packageEntitiesForProduct3;
    private List<PackageEntity> packageEntitiesForProduct4;
    private List<PackageEntity> packageEntitiesForProduct5;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "`products_ID_seq`" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`p_name`", nullable = true, length = 255)
    public String getPname() {
        return this.pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Column(name = "`p_description`", nullable = true, length = 255)
    public String getPdescription() {
        return this.pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    @Column(name = "`p_picture`", nullable = true)
    public byte[] getPpicture() {
        return this.ppicture;
    }

    public void setPpicture(byte[] ppicture) {
        this.ppicture = ppicture;
    }

    @Column(name = "`p_rating`", nullable = true, scale = 0, precision = 10)
    public Integer getPrating() {
        return this.prating;
    }

    public void setPrating(Integer prating) {
        this.prating = prating;
    }

    @Column(name = "`p_catagory`", nullable = true, scale = 0, precision = 10)
    public Integer getPcatagory() {
        return this.pcatagory;
    }

    public void setPcatagory(Integer pcatagory) {
        this.pcatagory = pcatagory;
    }

    @Column(name = "`p_code`", nullable = true, scale = 0, precision = 10)
    public Integer getPcode() {
        return this.pcode;
    }

    public void setPcode(Integer pcode) {
        this.pcode = pcode;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`p_catagory`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_category_TO_products_v9b20`"))
    @Fetch(FetchMode.JOIN)
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        if(category != null) {
            this.pcatagory = category.getId();
        }

        this.category = category;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productsByProduct1")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<PackageEntity> getPackageEntitiesForProduct1() {
        return this.packageEntitiesForProduct1;
    }

    public void setPackageEntitiesForProduct1(List<PackageEntity> packageEntitiesForProduct1) {
        this.packageEntitiesForProduct1 = packageEntitiesForProduct1;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productsByProduct2")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<PackageEntity> getPackageEntitiesForProduct2() {
        return this.packageEntitiesForProduct2;
    }

    public void setPackageEntitiesForProduct2(List<PackageEntity> packageEntitiesForProduct2) {
        this.packageEntitiesForProduct2 = packageEntitiesForProduct2;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productsByProduct3")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<PackageEntity> getPackageEntitiesForProduct3() {
        return this.packageEntitiesForProduct3;
    }

    public void setPackageEntitiesForProduct3(List<PackageEntity> packageEntitiesForProduct3) {
        this.packageEntitiesForProduct3 = packageEntitiesForProduct3;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productsByProduct4")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<PackageEntity> getPackageEntitiesForProduct4() {
        return this.packageEntitiesForProduct4;
    }

    public void setPackageEntitiesForProduct4(List<PackageEntity> packageEntitiesForProduct4) {
        this.packageEntitiesForProduct4 = packageEntitiesForProduct4;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productsByProduct5")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<PackageEntity> getPackageEntitiesForProduct5() {
        return this.packageEntitiesForProduct5;
    }

    public void setPackageEntitiesForProduct5(List<PackageEntity> packageEntitiesForProduct5) {
        this.packageEntitiesForProduct5 = packageEntitiesForProduct5;
    }

    @PostPersist
    public void onPostPersist() {
        if(packageEntitiesForProduct1 != null) {
            for(PackageEntity packageEntity : packageEntitiesForProduct1) {
                packageEntity.setProductsByProduct1(this);
            }
        }
        if(packageEntitiesForProduct2 != null) {
            for(PackageEntity packageEntity : packageEntitiesForProduct2) {
                packageEntity.setProductsByProduct2(this);
            }
        }
        if(packageEntitiesForProduct3 != null) {
            for(PackageEntity packageEntity : packageEntitiesForProduct3) {
                packageEntity.setProductsByProduct3(this);
            }
        }
        if(packageEntitiesForProduct4 != null) {
            for(PackageEntity packageEntity : packageEntitiesForProduct4) {
                packageEntity.setProductsByProduct4(this);
            }
        }
        if(packageEntitiesForProduct5 != null) {
            for(PackageEntity packageEntity : packageEntitiesForProduct5) {
                packageEntity.setProductsByProduct5(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;
        final Products products = (Products) o;
        return Objects.equals(getId(), products.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

