package com.study.specification.model;

import com.study.specification.enums.Department;
import com.study.specification.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @SequenceGenerator(name = "developer_seq",sequenceName = "developer_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "developer_seq")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "address_id",foreignKey = @ForeignKey(name = "FK_address"))
    private Address address;

}
