package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.domain.TbAttendance;
import com.domain.TbAttendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbAttendanceMapper extends BaseMapper<TbAttendance> {
    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     *
     * @param params，需要两个参数，start/记录开始的位置 length/每页记录数
     * @return
     */
    List<TbAttendance> page(Map<String, Object> params);

    /**
     * 查询总笔数
     *
     * @return
     */
    int count(TbAttendance entity);

    List<String> classInfo();
    List<String> absentNum(@Param("array") String[] strings);
}
