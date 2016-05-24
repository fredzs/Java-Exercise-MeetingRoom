<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="datepicker/public/css/zebra_datepicker.css" type="text/css">
<title>预订会议室</title>
<link rel="stylesheet" href="<%=com.free4lab.freemonitor.common.Constants.CSS_JS_SERVER+"css/public.css"%>" />
<script type="text/javascript" src="datepicker/public/javascript/zebra_datepicker.js"></script>
<script src="http://front.free4lab.com/js/public.js"></script>

</head>
<body>
     <table >
         <tr>
            <td width="58"><div align="left">预订人<span class="redletter">*</span></div></td>
            <td width="241"><input id="user_name" type="text" value="<s:property value="#session.userName"/>" class="editline" readonly /></td>
         </tr>
         <tr>
            <td><div align="left">联系方式<span class="redletter">*</span></div></td>
            <td><input id="user_phone" type="text" value="" class="editline" /></td>
         </tr>
         <tr>
            <td><div align="left">教  师<span class="redletter">*</span></div></td>
            <td><input id="teacher_name" type="text" value="" class="editline" /></td>
         </tr>

         <tr>
            <td><div align="left">联系方式<span class="redletter">*</span></div></td>
            <td><input id="teacher_phone" type="text" value="" class="editline" /></td>
         </tr>
         <tr>
            <td width="58"><div align="left">会议室<span class="redletter">*</span></div></td>
            <td width="241"><input id="meeting_room" type="text" value="<s:property value="MeetingRoom"/>" class="editline" readonly /></td>
         </tr>
         <tr>
            <td><div align="left">预定日期<span class="redletter">*</span></div></td>
            <td>
            	<input id="date" type="text" readonly>
            </td>
         </tr>
         <tr>
            <td><div align="left">开始时间<span class="redletter">*</span></div></td>
            <td><select id="start_time">
				  <option value =8>8</option>
				  <option value =9>9</option>
				  <option value=10>10</option>
				  <option value=11>11</option>
				  <option value =12>12</option>
				  <option value =13>13</option>
				  <option value=14>14</option>
				  <option value=15>15</option>
				  <option value =16>16</option>
				  <option value =17>17</option>
				  <option value=18>18</option>
				  <option value=19>19</option>
				  <option value =20>20</option>
				</select>
			</td>
         </tr>
         <tr>
            <td><div align="left">结束时间<span class="redletter">*</span></div></td>
            <td><select id="end_time">
				  <option value =8>8</option>
				  <option value =9>9</option>
				  <option value=10>10</option>
				  <option value=11>11</option>
				  <option value =12>12</option>
				  <option value =13>13</option>
				  <option value=14>14</option>
				  <option value=15>15</option>
				  <option value =16>16</option>
				  <option value =17>17</option>
				  <option value=18>18</option>
				  <option value=19>19</option>
				  <option value =20>20</option>
				</select>
			</td>
         </tr>
         <tr>
            <td><div align="left">会议主题</div></td>
            <td><input id="topic" type="text" value="" class="editline" /></td>
         </tr>
         <tr>
            <td><div align="left">与会者</div></td>
            <td><textarea id="participant" cols="30" rows="5" class="editbox"></textarea></td>
         </tr>
         <tr>
            <td><div align="left"></div></td>
            <td></td>
         </tr><tr>
            <td><div align="left"></div></td>
            <td>
            	<input type="button" class="button" value="预订" onClick="submit()" />
           	  <input type="button" class="button" value="取消" onClick="cancle()"/>
            </td>
         </tr>
     </table>
</body>



<script type="text/javascript" charset="gb2312">

function submit( ) 
{
	if ((($('#end_time').val()-$('#start_time').val())<=2)&&(($('#end_time').val()-$('#start_time').val())>0))
	{
		if ($('#user_phone').val()!="")
		{
			if($('#teacher_name').val()!="")
			{
				if($('#teacher_phone').val()!="")
				{
					if($('#date').val()!="")
					{
						$.ajax
						({
							url : 'reserve',
							type : 'post',
							data : 
							{
								user_id : "<s:property value="#session.userId"/>",
								user_name : $('#user_name').val(),
								user_phone : $('#user_phone').val(),
								teacher_name : $('#teacher_name').val(),
								teacher_phone : $('#teacher_phone').val(),
								meeting_room : $('#meeting_room').val(),
								date : $('#date').val(),
								start_time : $('#start_time').val(),
								end_time : $('#end_time').val(),
								topic : $('#topic').val(),
								participant : $('#participant').val(),
							},
							success : function(data) {
								if (data.available==0)
								{
									$(document).trigger('close.facebox');
									alert("预订成功！");
										location.reload();
								}
								else
									alert("该时段已被预约，请更改预订时段！");
								
								
							}
						});
					}
					else
						alert("预定日期不能为空！");
				}
				else
					alert("教师联系方式不能为空！");
			}
			else
				alert("教师姓名不能为空！");
		}
		else
			alert("预订人电话不能为空！");
	}
	else
		alert("预订时间不符合要求或一次预订时间超过2个小时,请重填起止时间。");
	
}
function cancle()
{
	$(document).trigger('close.facebox');
}
</script>

<script type="text/javascript">
$("#date").click(function(){
	var date = new Date();
	this.day = new Array(7, 6, 5, 4, 3, 2, 8)[date.getDay()];
	$('#date').Zebra_DatePicker({
		  direction: [true, this.day]
	});
});
$("#date").click();

</script>

</html>