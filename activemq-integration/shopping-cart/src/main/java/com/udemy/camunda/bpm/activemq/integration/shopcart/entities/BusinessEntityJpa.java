package com.udemy.camunda.bpm.activemq.integration.shopcart.entities;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BusinessEntity")
public class BusinessEntityJpa {

  @Id
  private String id;
  @Column(nullable = false)
  private String entityType;

  @Column(nullable = false)
  private String entitySpecification;

  private String name;
  private String status;

  @JoinTable(name = "entityRelation", joinColumns = {
          @JoinColumn(name = "referencingEntity", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
          @JoinColumn(name = "referencedEntity", referencedColumnName = "id", nullable = false)})
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<BusinessEntityJpa> relatedEntities = new ArrayList<>();

}
