package com.controller;

import com.domain.TbAttendance;
import com.dto.BaseResult;
import com.dto.PageInfo;
import com.service.TbAttendanceService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private TbAttendanceService service;

    @ModelAttribute
    public TbAttendance getTbAttendance(Long id) {
        TbAttendance attendance = null;

        // id 不为空，则从数据库获取
        if (id != null) {
            attendance = service.getById(id);
        } else {
            attendance = new TbAttendance();
        }

        return attendance;
    }

    /**
     * 跳转到用户列表页
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "attendance_list";
    }

    /**
     * 跳转用户表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "attendance_form";
    }

    /**
     * 保存用户信息
     *
     * @param attendance
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbAttendance attendance, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.saveOrInsert(attendance);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/attendance/list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "attendance_form";
        }
    }

    /**
     * 删除用户信息
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除学生成功");
        } else {
            baseResult = BaseResult.fail("删除学生失败");
        }

        return baseResult;
    }


    /**
     * 分页查询
     *
     * @param request
     * @param entity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbAttendance> page(HttpServletRequest request, TbAttendance entity) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 Datatables 需要的结果
        PageInfo<TbAttendance> pageInfo = service.page(start, length, draw, entity);

        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "classInfo", method = RequestMethod.POST)
    public List<String> classInfo() {
        return service.classInfo();
    }

    @ResponseBody
    @RequestMapping(value = "absentNum", method = RequestMethod.POST)
    public List<String> absentNum(@RequestBody String[] params) {
        return service.absentNum(params);
    }

}
