<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>学生考勤 | 学生管理</title>
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
                图表
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">图表</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">图表统计</h3>
                        </div>
                        <div class="box-body">
                            <a href="#" type="button" class="btn btn-lg btn-default"><i
                                    class="glyphicon glyphicon-th-list"></i> 课程名</a>&nbsp;
                            <a href="#" type="button" class="btn btn-lg btn-default"><i
                                    class="glyphicon glyphicon-user"></i> 学生名</a>&nbsp;
                        </div>
                        <div class="box-body">
                            <div id="main" style="height: 650px;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/footer.jsp"/>
<script src="/static/js/echarts.min.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    $(function () {
        $.ajax({
            type: "POST",
            url: "/attendance/classInfo",
            datatype: "json",
            success: function (xData) {
                $.ajax({
                    type: "POST",
                    url: "/attendance/absentNum",
                    data: JSON.stringify(xData),
                    datatype: "json",
                    contentType: "application/json",
                    success: function (yData) {
                        // 指定图表的配置项和数据
                        var option = {
                            title: {
                                text: '统计图'
                            },
                            xAxis: {
                                type: 'category',
                                data: xData
                            },
                            legend: {
                                data: ['柱状图', '折线图'],
                                left: '10%'
                            },
                            tooltip: {
                                trigger: 'axis'
                            },
                            yAxis: {
                                name: '逃课人数',
                                type: 'value',
                                min: 0,
                                max: 20,
                                axisLabel: {
                                    formatter: '{value} 人'
                                }
                            },
                            series: [
                                {
                                    data: yData,
                                    type: 'line',
                                    name: '折线图',
                                    lineStyle:{
                                        normal:{
                                            width: 3,
                                            color: "#ee6666"  //连线颜色
                                        }
                                    },
                                    smooth: true
                                },
                                {
                                    data: yData,
                                    type: 'bar',
                                    name: '柱状图',
                                    itemStyle: {
                                        normal: {
                                            color: '#5470c6'
                                        }
                                    },
                                    barWidth : 50
                                }
                            ]
                        };

                        // 使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option);
                        setTimeout(function () {
                            window.onresize = function () {
                                myChart.resize();
                            }
                        }, 200)
                    }
                })
            }
        });
    });
</script>
</body>
</html>
