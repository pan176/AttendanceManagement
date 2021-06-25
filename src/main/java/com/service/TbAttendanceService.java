package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.domain.TbAttendance;
import com.dto.BaseResult;
import com.dto.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAttendanceService extends IService<TbAttendance> {
    public List<String> classInfo();
    public List<String> absentNum(String[] params);
    /**
     * 查询全部
     *
     * @return
     */
    public List<TbAttendance> selectAll();

    /**
     * 保存信息
     *
     * @param entity
     * @return
     */
    BaseResult saveOrInsert(TbAttendance entity);

    /**
     * 删除用户信息
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 ID 获取信息
     *
     * @param id
     * @return
     */
    TbAttendance getById(Long id);

    /**
     * 更新信息
     *
     * @param entity
     */
    void update(TbAttendance entity);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @return
     */
    PageInfo<TbAttendance> page(int start, int length, int draw, TbAttendance entity);

    /**
     * 查询总笔数
     *
     * @return
     */
    int count(TbAttendance entity);
}
