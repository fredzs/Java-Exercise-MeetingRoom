<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>/" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>全部会议室信息</title>
<link rel="stylesheet" href="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"css/public.css"%>" />
<style type="text/css">
	.bigfont{ background: #ff80c0;}
</style>
</head>
<body>
	 <div id="container">
		<s:include value="/template/_banner.jsp" />
		<div id="inner">
			<div class="content">
				<div class="divline">
					会议室信息
				</div>
				<div class="contentline">
					<table class="datatable">
					<tr>
						<td>编号</td>
						<td>名字</td>
						<td>位置</td>
						<td>容量</td>
						<td>开放时间</td>
						<td>投影仪</td>
						<td>今天是否开放</td>
						<td></td>	
					</tr>	
					<tr>
						<td><s:property value="MeetingRoomInfoList[0].id" /></td>
						<td><s:property value="MeetingRoomInfoList[0].name" /></td>
						<td><s:property value="MeetingRoomInfoList[0].location" /></td>
						<td><s:property value="MeetingRoomInfoList[0].capacity" /></td>
						<td><s:property value="MeetingRoomInfoList[0].open_time" />---<s:property value="MeetingRoomInfoList[0].close_time" /></td>
						<s:if test="MeetingRoomInfoList[0].projector == 1">
							<td>有</td>
						</s:if>
						<s:else>
							<td>无</td>
						</s:else>
						<s:if test="MeetingRoomInfoList[0].available == 1">
							<td>否</td>
						</s:if>
						<s:else>
							<td>是</td>
						</s:else>
						<td> <a class="orangebutton" href="weekview?MeetingRoom=1">预订</a></td>
					</tr>
					<tr>
						<td><s:property value="MeetingRoomInfoList[1].id" /></td>
						<td><s:property value="MeetingRoomInfoList[1].name" /></td>
						<td><s:property value="MeetingRoomInfoList[1].location" /></td>
						<td><s:property value="MeetingRoomInfoList[1].capacity" /></td>
						<td><s:property value="MeetingRoomInfoList[1].open_time" />---<s:property value="MeetingRoomInfoList[1].close_time" /></td>
						<s:if test="MeetingRoomInfoList[1].projector == 1">
							<td>有</td>
						</s:if>
						<s:else>
							<td>无</td>
						</s:else>
						<s:if test="MeetingRoomInfoList[1].available == 1">
							<td>否</td>
						</s:if>
						<s:else>
							<td>是</td>
						</s:else>
						<td> <a class="orangebutton" href="weekview?MeetingRoom=2">预订</a></td>
					</tr>
					<tr>
						<td><s:property value="MeetingRoomInfoList[2].id" /></td>
						<td><s:property value="MeetingRoomInfoList[2].name" /></td>
						<td><s:property value="MeetingRoomInfoList[2].location" /></td>
						<td><s:property value="MeetingRoomInfoList[2].capacity" /></td>
						<td><s:property value="MeetingRoomInfoList[2].open_time" />---<s:property value="MeetingRoomInfoList[2].close_time" /></td>
						<s:if test="MeetingRoomInfoList[2].projector == 1">
							<td>有</td>
						</s:if>
						<s:else>
							<td>无</td>
						</s:else>
						<s:if test="MeetingRoomInfoList[2].available == 1">
							<td>否</td>
						</s:if>
						<s:else>
							<td>是</td>
						</s:else>
						<td> <a class="orangebutton" href="weekview?MeetingRoom=3">预订</a></td>
					</tr>
			
					</table>
					<input type="button" class="orangebutton hidden" value="查看空闲会议室" />
				</div>
			</div>
			
		</div>
		<s:include value="/template/_footer.jsp" />
	</div>

   

<script src="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"js/public.js"%>"></script>
</body>
</html>