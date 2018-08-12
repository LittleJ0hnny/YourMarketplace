package com.littlejohnny.domain.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attribute_types")
public class AttributeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", unique = true, nullable = false, length = 50)
    private String typeName;

    @OneToMany(mappedBy = "attributeType")
    private Set<ProductAttribute> productAttribute;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "attribute_type_product_type",
            joinColumns = { @JoinColumn(name = "attribute_type_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_type_id") }
    )
    private Set<ProductType> productTypes;

    public AttributeType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<ProductAttribute> getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(Set<ProductAttribute> productAttribute) {
        this.productAttribute = productAttribute;
    }

    public Set<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(Set<ProductType> productTypes) {
        this.productTypes = productTypes;
    }
}
