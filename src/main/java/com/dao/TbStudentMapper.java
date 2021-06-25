package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.domain.TbCombine;
import com.domain.TbStudent;

import java.util.List;
import java.util.Map;

public interface TbStudentMapper extends BaseMapper<TbStudent> {
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
    List<TbStudent> page(Map<String, Object> params);

    /**
     * 查询总笔数
     *
     * @return
     */
    int count(TbStudent entity);
}
