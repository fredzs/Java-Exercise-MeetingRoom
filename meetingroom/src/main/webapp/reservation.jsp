<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>/" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="datepicker/public/css/zebra_datepicker.css" type="text/css">
<script type="text/javascript" src="datepicker/public/javascript/zebra_datepicker.js"></script>
<title>全部预订信息</title>
<link rel="stylesheet" href="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"css/public.css"%>" />
</head>
<body>

	<div id="container">
		<s:include value="/template/_banner.jsp" />
		<div id="inner">
			<div class="content">
				<div class="divline">
					会议室预订列表
				</div>
				<div class="contentline">
					<table class="datatable">
					<tr>
						<td width="40">预订人</td>
						<td width="80">预订人电话</td>
                        <td width="40">教师</td>
						<td width="80">教师电话</td>
						<td width="40">会议室</td>
                        <td width="70">预订日期</td>
                        <td width="70">开始时间</td>
					</tr>
					<s:iterator value="logList" id="list" status="log">
						<tr>
							<td><s:property value="" /></td>
							<td><s:property value="#list.user_phone" /></td>
							<td><s:property value="#list.teacher_name" /></td>
							<td><s:property value="#list.teacher_phone" /></td>
                            <td><s:property value="#list.meeting_room" /></td>
                            <td><s:property value="#list.date" /></td>
							<td><s:property value="#list.start_time" /></td>
						</tr>
					</s:iterator>
					</table>
				</div>
                <a class="button" href="_facebox.jsp" rel="facebox" title="预订会议室">预订会议室</a>
			</div>
		</div>
		<s:include value="/template/_footer.jsp" />
	</div>
     
<script src="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"js/public.js"%>"></script>
</body>

<script>
function remove( id ) 
{
	$.ajax({
		url : 'remove',
		type : 'post',
		data : {
			id : id
		},
		success : function() {
			alert("删除成功！");
			location.reload();
		}
	});
}
</script>

</html>