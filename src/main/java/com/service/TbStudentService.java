package com.service;

import com.domain.TbCombine;
import com.domain.TbStudent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.BaseResult;
import com.dto.PageInfo;

import java.util.List;

public interface TbStudentService extends IService<TbStudent> {

    /**
     * 查询全部
     * @return
     */
    public List<TbStudent> selectAll();

    /**
     * 保存信息
     * @param entity
     * @return
     */
    BaseResult saveOrInsert(TbStudent entity);

    /**
     * 删除用户信息
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 ID 获取信息
     * @param id
     * @return
     */
    TbStudent getById(Long id);

    /**
     * 更新信息
     * @param entity
     */
    void update(TbStudent entity);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    PageInfo<TbStudent> page(int start, int length, int draw, TbStudent entity);

    /**
     * 查询总笔数
     * @return
     */
    int count(TbStudent entity);
}
