package com.littlejohnny.domain.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "attribute_values")
public class AttributeValue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attribute_value", unique = true, nullable = false, length = 50)
    private String value;

    @OneToMany(mappedBy = "attributeValue")
    private Set<ProductAttribute> productAttributes;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "attribute_value_attribute_type",
            joinColumns = { @JoinColumn(name = "attribute_value_id") },
            inverseJoinColumns = { @JoinColumn(name = "attribute_type_id") }
    )
    private Set<AttributeType> attributeTypes;

    public AttributeValue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(Set<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }

    public Set<AttributeType> getAttributeTypes() {
        return attributeTypes;
    }

    public void setAttributeTypes(Set<AttributeType> attributeTypes) {
        this.attributeTypes = attributeTypes;
    }
}
