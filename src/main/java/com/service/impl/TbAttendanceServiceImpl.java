package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.domain.TbAttendance;
import com.dto.BaseResult;
import com.dto.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dao.TbAttendanceMapper;
import com.domain.TbAttendance;
import com.service.TbAttendanceService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TbAttendanceServiceImpl extends ServiceImpl<TbAttendanceMapper, TbAttendance> implements TbAttendanceService{
    @Autowired
    private TbAttendanceMapper mapper;
    @Override
    @Transactional(readOnly = false)
    public BaseResult saveOrInsert(TbAttendance attendance) {
        // 新增用户
        if (attendance.getId() == null) {
            mapper.insert(attendance);

            // 编辑用户
        } else {
            update(attendance);
        }

        return BaseResult.success("保存缺课信息成功");
    }

    @Override
    public List<String> classInfo() {
        return mapper.classInfo();
    }

    @Override
    public List<String> absentNum(String[] params) {
        return mapper.absentNum(params);
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @Override
    public List<TbAttendance> selectAll() {
        QueryWrapper<TbAttendance> queryWrapper = new QueryWrapper<>();
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
    public TbAttendance getById(Long id) {
        return mapper.selectById(id);
    }

    /**
     * 更新信息
     *
     * @param entity
     */
    @Override
    public void update(TbAttendance entity) {
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
    public int count(TbAttendance entity) {
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
    public PageInfo<TbAttendance> page(int start, int length, int draw, TbAttendance entity) {
        int count = count(entity);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<TbAttendance> pageInfo = new PageInfo<TbAttendance>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(mapper.page(params));

        return pageInfo;
    }
}
