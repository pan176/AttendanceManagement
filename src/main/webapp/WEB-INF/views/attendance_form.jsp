<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>学生考勤 | 缺课管理</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                缺课管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">缺课管理</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbStudent.id == null ? "新增" : "编辑"}缺课</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="inputForm" cssClass="form-horizontal" action="/attendance/save" method="post"
                                   modelAttribute="tbAttendance">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="studentId" class="col-sm-2 control-label">学生学号</label>
                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" id="studentId" name="studentId"
                                                    path="studentId" placeholder="请输入学生的学号"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="studentName" class="col-sm-2 control-label">学生姓名</label>
                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" id="studentName" name="studentName"
                                                    path="studentName" placeholder="请输入学生的姓名"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="studentName" class="col-sm-2 control-label">第几节课</label>
                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" id="absentClass" name="absentClass"
                                                    path="absentClass" placeholder="请输入第几节课"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="studentName" class="col-sm-2 control-label">课程名称</label>
                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" id="className" name="className"
                                                    path="className" placeholder="请输入课程名称"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="absentDate" class="col-sm-2 control-label">缺课日期</label>
                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" id="absentDate" name="absentDate"
                                                    path="absentDate" placeholder="请输入缺课日期（yyyy-MM-dd）"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="absentType" class="col-sm-2 control-label">班级</label>
                                    <div class="col-sm-10">
                                        <select class="form-control" path="absentType" id="absentType"
                                                name="absentType">
                                            <option value="迟到">迟到</option>
                                            <option value="早退">早退</option>
                                            <option value="请假">请假</option>
                                            <option value="旷课">旷课</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp"/>
</div>

<jsp:include page="../includes/footer.jsp"/>
</body>
</html>
