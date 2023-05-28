package com.techacademy.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
@Where(clause = "delete_flag = 0")
public class Employee {

    /** 主キー。自動生成 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy="employee")
    private Authentication authentication;

    @Column(length = 20, nullable = false)
    /** 名前。20桁。null不許可 */
    private String name;

    /** 削除フラグ */
    private int deleteFlag;
    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /** 年齢 */
    private Integer age;

    /** 登録日時 */
    private LocalDateTime createdAt;

    /** 更新日時 */
    private LocalDateTime updatedAt;

}