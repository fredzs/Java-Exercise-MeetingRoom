<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" href="http://front.free4lab.com/css/public.css" type="text/css" media="screen, projection" />
<!--  
<base
	href="<%=request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath()%>/" />
//-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会议室预订系统--周视图</title>
</head>

<body>
	<div id="container">
		
		<s:include value="/template/_banner.jsp?index=index" />
		
		<div id="inner" class="content dottedline">
	
			<div class="sidebar"> 
         <a class="orangebutton hidden" href="reservation" target="_blank" >查看所有预定记录</a> 
         <a class="orangebutton" href="new?MeetingRoom=<s:property value="MeetingRoom"/>" rel="facebox" title="预订会议室">预订会议室</a>
		 <a class="orangebutton" href="main" >会议室列表</a>
                <div id="chooseday">
                <span class="strong midsize">
                <s:property value="StartYear"/>年<s:property value="month"/>月<s:property value="day"/>日预订详情:</span><br />
                </div>
                
				<div class="dottedline"></div>
				
				<div id="view_table" class="xxlheight grey1border">
                </div>		
			</div>   
	
			<div class="main leftmargin_0">  
				<div class="leftalign greybox topmargin_10 bottommargin_10">		
			    <div class="bigsize  strong  centeralign" ><s:property value="MeetingRoom"/>号会议室</br>
			    <s:property value="StartYear"/>年 <s:property value="StartMonth"/>月<s:property value="StartOfWeek"/>日     ---- <s:property value="EndYear"/>年 <s:property value="EndMonth"/>月<s:property value="EndOfWeek"/>日  
			    </div>
			    
				<div class="leftclear"></div>						
			  </div>	
			  
				<div>                
                <table class="itemtable" >
                <tr><td width="70"><s:property value="StartMonth"/>月<s:property value="StartOfWeek"/>日</br>星期一</td>
                <td width="65"><s:property value="StartMonth"/>月<s:property value="StartOfWeek+1"/>日</br>星期二</td>
                <td width="65"><s:property value="StartMonth"/>月<s:property value="StartOfWeek+2"/>日</br>星期三</td>
                <td width="65"><s:property value="StartMonth"/>月<s:property value="StartOfWeek+3"/>日</br>星期四</td>
                <td width="65"><s:property value="StartMonth"/>月<s:property value="StartOfWeek+4"/>日</br>星期五</td>
                <td width="65"><s:property value="StartMonth"/>月<s:property value="StartOfWeek+5"/>日</br>星期六</td>
                <td width="65"><s:property value="StartMonth"/>月<s:property value="StartOfWeek+6"/>日</br>星期日</td></tr>
                <tr height="350" class="topveralign">    
                <td id="monday" onclick="view('monday')"><s:iterator value="Monday" id="Mon">
                <s:property value="#Mon.start_time"/>:00-<s:property value="#Mon.end_time" />:00</br>
                <span class="leftfloat"><s:property value="#Mon.user_name" /></span></br></br></s:iterator> </td>
                
                <td id="tuesday" onclick="view('tuesday')"><s:iterator value="Tuesday" id="Tue">
                <s:property value="#Tue.start_time"/>:00-<s:property value="#Tue.end_time" />:00</br>
                <span class="leftfloat"><s:property value="#Tue.user_name" /></span></br></br></s:iterator> </td>
                
                <td id="wednesday" onclick="view('wednesday')"><s:iterator value="Wednesday" id="Wed">
                <s:property value="#Wed.start_time"/>:00-<s:property value="#Wed.end_time" />:00</br>
                <span class="leftfloat"><s:property value="#Wed.user_name" /></span></br></br></s:iterator> </td>
                
                <td id="thursday" onclick="view('thursday')"><s:iterator value="Thursday" id="Thu">
                <s:property value="#Thu.start_time"/>:00-<s:property value="#Thu.end_time" />:00</br>
                <span class="leftfloat"><s:property value="#Thu.user_name" /></span></br></br></s:iterator> </td>
                
                <td id="friday" onclick="view('friday')"><s:iterator value="Friday" id="Fri">
                <s:property value="#Fri.start_time"/>:00-<s:property value="#Fri.end_time" />:00</br>
                <span class="leftfloat"><s:property value="#Fri.user_name" /></span></br></br></s:iterator> </td>
                
                <td id="saturday" onclick="view('saturday')"><s:iterator value="Saturday" id="Sat">
                <s:property value="#Sat.start_time"/>:00-<s:property value="#Sat.end_time" />:00</br>
                <span class="leftfloat"><s:property value="#Sat.user_name" /></span></br></br></s:iterator> </td>
                
                <td id="sunday" onclick="view('sunday')"><s:iterator value="Sunday" id="Sun">
                <s:property value="#Sun.start_time"/>:00-<s:property value="#Sun.end_time" />:00</br>
                <span class="leftfloat"><s:property value="#Sun.user_name" /></span></br></br></s:iterator> </td>          
                </tr></table>
                </div>		              
			</div> 
			
			<script>
		    var today = new Date();
			var my_array = new Array("sunday","monday","tuesday","wednesday","thursday","friday","saturday");
			document.getElementById(my_array[today.getDay()]).setAttribute("class", "yellowbox");
	       </script>
			
		 	<div class="clear"></div>	
						
		</div> 	
		<s:include value="/template/_footer.jsp" />
	</div>  <!-- container块 -->
	<script src="http://front.free4lab.com/js/public.js" ></script>
</body>

<script>
function view(day_of_week) 
{
	$("#view_table").html('');
	$("#chooseday").html('');
	switch(day_of_week){
	   case "monday":
		   $("#chooseday").append("<span class=\"strong midsize\">"+
				   "<s:property value="StartYear"/>年<s:property value="StartMonth"/>月<s:property value="StartOfWeek"/>日预订详情:</span><br/>");
	   		<s:iterator value="Monday" id="Mon">
			   $("#view_table").append("<table class=\"bottommargin_5\">"+
			   		   "<tr><td class=\"rightalign blueletter\">预订时间：</td><td><s:property value="#Mon.start_time"/>:00-<s:property value="#Mon.end_time" />:00</td></tr>"+
			   		   "<tr><td class=\"rightalign blueletter\">预订人：</td><td><s:property value="#Mon.user_name"/></td></tr>"+
                       "<tr><td class=\"rightalign blueletter\">预订人电话：</td><td><s:property value="#Mon.user_phone"/></td></tr>"+
                       "<tr><td class=\"rightalign blueletter\">主题：</td><td><s:property value="#Mon.topic"/></td></tr>"+
                       "</table>");
			    var userId = <s:property value="#Mon.user_id"/>;
	   			var sessionUid = <s:property value="#session.userId"/>;
              if(userId == sessionUid){
              		$("#view_table").append("<table><tr ><td colspan=2 class=\"rightalign\" ><a href=\"getold?id=<s:property value="#Mon.id"/>&meeting_room=<s:property value="MeetingRoom"/>\" rel=\"facebox\" class=\"lightgreyletter rightmargin_5\">修改</a>"+
              		"<a class=\"lightgreyletter\" onclick=\"remove(\'<s:property value="#Mon.id"/>\')\">删除</a></td></tr></table>");
              }
              $("#view_table").append("<div class=\"dottedline\"></div>");
		   </s:iterator>
		   break;   
	   case "tuesday":
		   $("#chooseday").append("<span class=\"strong midsize\">"+
				   "<s:property value="StartYear"/>年<s:property value="StartMonth"/>月<s:property value="StartOfWeek+1"/>日预订详情:</span><br />");
		   <s:iterator value="Tuesday" id="Tue">
		   $("#view_table").append("<table class=\"bottommargin_5\">"+
		   		   "<tr><td class=\"rightalign blueletter\">预订时间：</td><td><s:property value="#Tue.start_time"/>:00-<s:property value="#Tue.end_time" />:00</td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人：</td><td><s:property value="#Tue.user_name"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人电话：</td><td><s:property value="#Tue.user_phone"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">主题：</td><td><s:property value="#Tue.topic"/></td></tr>"+
                   "</table>");
		   var userId = <s:property value="#Tue.user_id"/>;
  			var sessionUid = <s:property value="#session.userId"/>;
          if(userId == sessionUid){
          		$("#view_table").append("<table><tr ><td colspan=2 class=\"rightalign\" ><a href=\"getold?id=<s:property value="#Tue.id"/>&meeting_room=<s:property value="MeetingRoom"/>\" rel=\"facebox\" class=\"lightgreyletter rightmargin_5\">修改</a>"+
          		"<a class=\"lightgreyletter\" onclick=\"remove(\'<s:property value="#Tue.id"/>\')\">删除</a></td></tr></table>");
          }
          $("#view_table").append("<div class=\"dottedline\"></div>");
	   </s:iterator>
		   break;
	   case "wednesday":
		   $("#chooseday").append("<span class=\"strong midsize\">"+
				   "<s:property value="StartYear"/>年<s:property value="StartMonth"/>月<s:property value="StartOfWeek+2"/>日预订详情:</span><br />");
		   <s:iterator value="Wednesday" id="Wed">
		   $("#view_table").append("<table class=\"bottommargin_5\">"+
		   		   "<tr><td class=\"rightalign blueletter\">预订时间：</td><td><s:property value="#Wed.start_time"/>:00-<s:property value="#Wed.end_time" />:00</td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人：</td><td><s:property value="#Wed.user_name"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人电话：</td><td><s:property value="#Wed.user_phone"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">主题：</td><td><s:property value="#Wed.topic"/></td></tr>"+
                   "</table>");
		    var userId = <s:property value="#Wed.user_id"/>;
  			var sessionUid = <s:property value="#session.userId"/>;
           if(userId == sessionUid){
          		$("#view_table").append("<table><tr ><td colspan=2 class=\"rightalign\" ><a href=\"getold?id=<s:property value="#Wed.id"/>&meeting_room=<s:property value="MeetingRoom"/>\" rel=\"facebox\" class=\"lightgreyletter rightmargin_5\">修改</a>"+
          		"<a class=\"lightgreyletter\" onclick=\"remove(\'<s:property value="#Wed.id"/>\')\">删除</a></td></tr></table>");
          }
           $("#view_table").append("<div class=\"dottedline\"></div>");
	   </s:iterator>
		   break;
	   case "thursday":
		   $("#chooseday").append("<span class=\"strong midsize\">"+
				   "<s:property value="StartYear"/>年<s:property value="StartMonth"/>月<s:property value="StartOfWeek+3"/>日预订详情:</span><br />");
		   <s:iterator value="Thursday" id="Thu">
		   $("#view_table").append("<table class=\"bottommargin_5\">"+
		   		   "<tr><td class=\"rightalign blueletter\">预订时间：</td><td><s:property value="#Thu.start_time"/>:00-<s:property value="#Thu.end_time" />:00</td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人：</td><td><s:property value="#Thu.user_name"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人电话：</td><td><s:property value="#Thu.user_phone"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">主题：</td><td><s:property value="#Thu.topic"/></td></tr>"+
                   "</table>");
		   var userId = <s:property value="#Thu.user_id"/>;
  			var sessionUid = <s:property value="#session.userId"/>;
          if(userId == sessionUid){
          		$("#view_table").append("<table><tr ><td colspan=2 class=\"rightalign\" ><a href=\"getold?id=<s:property value="#Thu.id"/>&meeting_room=<s:property value="MeetingRoom"/>\" rel=\"facebox\" class=\"lightgreyletter rightmargin_5\">修改</a>"+
          		"<a class=\"lightgreyletter\" onclick=\"remove(\'<s:property value="#Thu.id"/>\')\">删除</a></td></tr></table>");
          }
          $("#view_table").append("<div class=\"dottedline\"></div>");
	   </s:iterator>
		   break;
	   case "friday":
		   $("#chooseday").append("<span class=\"strong midsize\">"+
				   "<s:property value="StartYear"/>年<s:property value="StartMonth"/>月<s:property value="StartOfWeek+4"/>日预订详情:</span><br />");
		   <s:iterator value="Friday" id="Fri">
		   $("#view_table").append("<table class=\"bottommargin_5\">"+
		   		   "<tr><td class=\"rightalign blueletter\">预订时间：</td><td><s:property value="#Fri.start_time"/>:00-<s:property value="#Fri.end_time" />:00</td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人：</td><td><s:property value="#Fri.user_name"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人电话：</td><td><s:property value="#Fri.user_phone"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">主题：</td><td><s:property value="#Fri.topic"/></td></tr>"+
                   "</table>");
		   var userId = <s:property value="#Fri.user_id"/>;
  			var sessionUid = <s:property value="#session.userId"/>;
          if(userId == sessionUid){
          		$("#view_table").append("<table><tr ><td colspan=2 class=\"rightalign\" ><a href=\"getold?id=<s:property value="#Fri.id"/>&meeting_room=<s:property value="MeetingRoom"/>\" rel=\"facebox\" class=\"lightgreyletter rightmargin_5\">修改</a>"+
          		"<a class=\"lightgreyletter\" onclick=\"remove(\'<s:property value="#Fri.id"/>\')\">删除</a></td></tr></table>");
          }
          $("#view_table").append("<div class=\"dottedline\"></div>");
	   </s:iterator>
		   break;
	   case "saturday":
		   $("#chooseday").append("<span class=\"strong midsize\">"+
				   "<s:property value="StartYear"/>年<s:property value="StartMonth"/>月<s:property value="StartOfWeek+5"/>日预订详情:</span><br />");
		   <s:iterator value="Saturday" id="Sat">
		   $("#view_table").append("<table class=\"bottommargin_5\">"+
		   		   "<tr><td class=\"rightalign blueletter\">预订时间：</td><td><s:property value="#Sat.start_time"/>:00-<s:property value="#Sat.end_time" />:00</td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人：</td><td><s:property value="#Sat.user_name"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人电话：</td><td><s:property value="#Sat.user_phone"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">主题：</td><td><s:property value="#Sat.topic"/></td></tr>"+
                   "</table>");
		       var userId = <s:property value="#Sat.user_id"/>;
  			var sessionUid = <s:property value="#session.userId"/>;
          if(userId == sessionUid){
          		$("#view_table").append("<table><tr ><td colspan=2 class=\"rightalign\" ><a href=\"getold?id=<s:property value="#Sat.id"/>&meeting_room=<s:property value="MeetingRoom"/>\" rel=\"facebox\" class=\"lightgreyletter rightmargin_5\">修改</a>"+
          		"<a class=\"lightgreyletter\" onclick=\"remove(\'<s:property value="#Sat.id"/>\')\">删除</a></td></tr></table>");
          }
          $("#view_table").append("<div class=\"dottedline\"></div>");
	   </s:iterator>
		   break;
	   case "sunday":
		   $("#chooseday").append("<span class=\"strong midsize\">"+
				   "<s:property value="StartYear"/>年<s:property value="StartMonth"/>月<s:property value="StartOfWeek+6"/>日预订详情:</span><br />");
		   <s:iterator value="Sunday" id="Sun">
		   $("#view_table").append("<table class=\"bottommargin_5\">"+
		   		   "<tr><td class=\"rightalign blueletter\">预订时间：</td><td><s:property value="#Sun.start_time"/>:00-<s:property value="#Sun.end_time" />:00</td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人：</td><td><s:property value="#Sun.user_name"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">预订人电话：</td><td><s:property value="#Sun.user_phone"/></td></tr>"+
                   "<tr><td class=\"rightalign blueletter\">主题：</td><td><s:property value="#Sun.topic"/></td></tr>"+
                   "</table>");
		   			var userId = <s:property value="#Sun.user_id"/>;
		   			var sessionUid = <s:property value="#session.userId"/>;
                   if(userId == sessionUid){
                   		$("#view_table").append("<table><tr ><td colspan=2 class=\"rightalign\" ><a href=\"getold?id=<s:property value="#Sun.id"/>&meeting_room=<s:property value="MeetingRoom"/>\" rel=\"facebox\" class=\"lightgreyletter rightmargin_5\">修改</a>"+
                   		"<a class=\"lightgreyletter\" onclick=\"remove(\'<s:property value="#Sun.id"/>\')\">删除</a></td></tr></table>");
                   }
                   $("#view_table").append("<div class=\"dottedline\"></div>");
	   </s:iterator>
		   break;
	   default:break;
	}
	$('a[rel*=facebox]').facebox();
	$('a[rel*=facebox]').attr('rel','faceboxready');
}
	function remove( id ) 
	{
		if(confirm("确实要删除吗?"))
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
	}
	$("#"+my_array[today.getDay()]).click();
</script>
</html>