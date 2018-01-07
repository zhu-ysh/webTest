<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="js/jquery/2.0.0/jquery.min.js"></script>
	<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="text-center">
				图书管理系统
			</h3>
			<form id="myform">
			    书名:<input type="text" name="bookName" id="bName" value="1" size="10"/>
			    作者:<input type="text" name="bookAuthor" id="bAuthor" value="1" size="10"/>
		      <input type="button" value="添加" id="add_btn">
			</form>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>图书编号</th>
						<th>书籍名称</th>
						<th>书籍作者</th>
						<th>借出状态</th>
						<th>借出时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			<p class="table-hover" align="center">
			</p>
		</div>
	</div>
</div>
<script>
var i = 0;
var per = 4;
var pageMax=1;
window.onload = function(){
	pagecount(1);
	pagegege();
};
function pagegege() {
	$.ajax({
		"url":"PageServlet", 
		"async":"false",
		"type":"post", 
		"data":"",
		"success" : function(data){
			$("p").children("button").remove();
			for (var i = 1; i <= Math.ceil(data.count/per); i++) {
				var $_button = $("<button onclick=pagecount("+i+")>"+i+"</button>");
				$("p").append($_button);
			}
			pageMax = data.count;
/* 			alert("gege:"+pageMax); */
		},
		"error":function(data){	
			alert("按钮  error");
		}
	});
}
function pagecount(page) {
	$.ajax({
		"url":"SelectServlet", 
		"async":"false",
		"type":"post", 
		"data":"page="+page+"&per="+per,
		"success" : function(data){
			$("tbody").children("tr").remove();
			for(var j = 0;j<data.length;j++){

				var $_tr = $("<tr></tr>");
			    var $_td1 = $("<td class='td"+i+"Id'></td>");
			    $_td1.html(data[j].bookId);
			   /*  $_td1.text(); */
			    var $_td2 = $("<td class='td"+i+"'></td>");
			    $_td2.html(data[j].bookName);
			    var $_td3 = $("<td class='td"+i+"'></td>");
			    $_td3.html(data[j].bookWriter);
			    var $_td4 = $("<td class='td"+i+"'></td>");
			    $_td4.html(data[j].bookStatus);
			    var $_td5 = $("<td class='td"+i+"'></td>");
			    
			    var jsondate = data[j].bookTime;
			    $_td5.html((jsondate.year+1900)+"-"+
			    			(jsondate.month+1)+"-"+
			    			jsondate.date+" "+
			    			jsondate.hours+":"+
			    			jsondate.minutes+":"+
			    			jsondate.seconds
			    			);
			    
			    var $_btn = $("<button class='del_btn'>删除</button>");
			    var $_td6 = $("<td></td>");
			    $_td6.append($_btn);
			    $_tr.append($_td1).append($_td2).append($_td3).append($_td4).append($_td5).append($_td6);
			    $("tbody").append($_tr);
			   
			    
			    $_btn.click(function(){
			    	var fatherFather = $(this).parent().parent();
			    	$.ajax({
			    		"url":"DeleteServlet", 
			    		"async":"false",
			    		"type":"post", 
			    		"data":"bookId="+fatherFather.children(":first").text(),
			    		"success" : function(data){
			    			 pagegege();
			    			 pagecount(Math.ceil((pageMax-1)/per));
			    		},
			    		"error":function(data){	
			    			alert("delect error");
			    		}
			    	});
			    });
			  
			    
			    $(".td"+i).dblclick(function(){
			        $_inp = $("<input type='text' size='10'/>");
			        $_inp.val($(this).text());
			      	$(this).empty(); 
			        $(this).append($_inp);
			        $_inp.focus();
			        $_inp.blur(function(){
			             $(this).parent().html($(this).val());
			        });
			    });
			    i = i+1;
			}
		},
		"error":function(data){	
			alert("select error");
		}
	});
}

$("#add_btn").click(function(){
	$.ajax({
		"url":"InsertServlet",  //请求的服务器页面
		"async":"false",		 //是否是异步，true就是异步
		"type":"post",       //提交方式,get,post
		"data":$("#myform").serialize(),  //提交的数据
		"success" : function(data){   //当服务成功返回后
			    pagegege();
/* 				alert("页数: "+Math.ceil(pageMax/per)); */
			    pagecount(Math.ceil((pageMax+1)/per));
		},
		"error":function(data){		//出错的时候回调用
			alert("insert error");
		}
	});
});
</script>
</body>
</html>