//------------------------------------------------------------------------------//
//  CategoryEntity structure for category model
//
//  By                          DATE                TICKET              DETAILS/CHANGES
//  Daniel-Zemanate             2022-09-16          OT295-19            creation of base model
//------------------------------------------------------------------------------//

package com.alkemy.ong.domain;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@SQLDelete(sql = "UPDATE categories SET softDelete = true WHERE id_character = ?")
@Where(clause = "softDelete = false")
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @SequenceGenerator(name = "seq_categories", sequenceName = "seq_categories", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categories")
    @Column(name = "id_categories", nullable = false)
    private Long idCategories;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @CreatedDate
    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "soft_delete")
    private Boolean softDelete = Boolean.FALSE;
}