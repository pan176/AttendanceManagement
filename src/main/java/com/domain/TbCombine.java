package com.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TbCombine {
    private Integer id;
    private String name;
    private Integer sex;
    private Integer age;
    private String className;
    private String courseName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date absentDate;
    private String absentClass;
    private String absentType;
}
