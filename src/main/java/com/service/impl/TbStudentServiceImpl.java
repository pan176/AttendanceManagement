package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.TbStudentMapper;
import com.domain.TbCombine;
import com.domain.TbStudent;
import com.dto.BaseResult;
import com.dto.PageInfo;
import com.service.TbStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbStudentServiceImpl extends ServiceImpl<TbStudentMapper, TbStudent> implements TbStudentService {
    @Autowired
    private TbStudentMapper mapper;

    @Override
    @Transactional(readOnly = false)
    public BaseResult saveOrInsert(TbStudent student) {
        // 新增用户
        if (student.getId() == null) {
            mapper.insert(student);

            // 编辑用户
        } else {
            update(student);
        }

        return BaseResult.success("保存学生信息成功");
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @Override
    public List<TbStudent> selectAll() {
        QueryWrapper<TbStudent> queryWrapper = new QueryWrapper<>();
        return mapper.selectList(queryWrapper);
    }

    /**
     * 删除用户信息
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }

    /**
     * 根据 ID 获取信息
     *
     * @param id
     * @return
     */
    @Override
    public TbStudent getById(Long id) {
        return mapper.selectById(id);
    }

    /**
     * 更新信息
     *
     * @param entity
     */
    @Override
    public void update(TbStudent entity) {
        mapper.updateById(entity);
    }



    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void deleteMulti(String[] ids) {
        mapper.deleteMulti(ids);
    }

    /**
     * 查询总笔数
     *
     * @return
     */
    @Override
    public int count(TbStudent entity) {
        return mapper.count(entity);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    @Override
    public PageInfo<TbStudent> page(int start, int length, int draw, TbStudent entity) {
        int count = count(entity);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<TbStudent> pageInfo = new PageInfo<TbStudent>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(mapper.page(params));

        return pageInfo;
    }
}
