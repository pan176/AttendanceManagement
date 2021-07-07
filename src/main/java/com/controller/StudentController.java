package com.controller;

import com.domain.TbStudent;
import com.dto.BaseResult;
import com.dto.PageInfo;
import com.service.TbStudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private TbStudentService service;

    @ModelAttribute
    public TbStudent getTbStudent(Long id) {
        TbStudent tbUser = null;

        // id 不为空，则从数据库获取
        if (id != null) {
            tbUser = service.getById(id);
        } else {
            tbUser = new TbStudent();
        }

        return tbUser;
    }

    /**
     * 跳转到用户列表页
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "student_list";
    }

    /**
     * 跳转用户表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "student_form";
    }

    /**
     * 保存用户信息（新增编辑二合一）
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbStudent student, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.saveOrInsert(student);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/student/list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "student_form";
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
    public PageInfo<TbStudent> page(HttpServletRequest request, TbStudent entity) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 Datatables 需要的结果
        PageInfo<TbStudent> pageInfo = service.page(start, length, draw, entity);

        return pageInfo;
    }
}
