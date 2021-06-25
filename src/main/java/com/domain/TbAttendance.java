package com.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@TableName(value = "tb_attendance")
public class TbAttendance implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "class_name")
    private String className;

    @TableField(value = "absent_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date absentDate;

    @TableField(value = "absent_class")
    private String absentClass;

    @TableField(value = "absent_type")
    private String absentType;

    @TableField(value = "student_name")
    private String studentName;

    @TableField(value = "student_id")
    private Integer studentId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CLASS_NAME = "class_name";

    public static final String COL_ABSENT_DATE = "absent_date";

    public static final String COL_ABSENT_CLASS = "absent_class";

    public static final String COL_ABSENT_TYPE = "absent_type";

    public static final String COL_STUDENT_NAME = "student_name";

    public static final String COL_STUDENT_ID = "student_id";
}
