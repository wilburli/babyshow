package com.windblue.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author: wilburli
 * @Description:
 * @Date: Created by sh on 2018-07-27.
 */
@Data
public class BaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // 不自动生成id
    @Getter
    @Setter
    private Integer id;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;

}
