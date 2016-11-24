$(function (){
	
		var row=10;
		var pages;
		
		init_data(1,row);
		
		//第一次请求分页条的范围和信息
		function init_data(num,row)	
		{
			var get_url ="/ArticlePost/queryList?page="+num+"&rows="+row;
			$.ajax({
		        url:get_url,
		        type:"get",
		        async:true,
		        success:function(data)
		        {
		        	console.log("成功取得数据,总分页数:"+data.pages);
		        	pages= data.pages;		//总页数
					
					$('#pagination').bootpag({
					    total: pages,          		// total pages
					    page: num,            		// default page
					    maxVisible: 10,     			// visible pagination
					    leaps: true,        		// next/prev leaps through maxVisible
					    firstLastUse: true,
					    first: '第一页',
					    last: '最后页',
					    nextClass: 'next',
					    prevClass: 'prev',
					    lastClass: 'last',
					    firstClass: 'first'
					}).on("page", function(event, num){
						get_ajax(num,row);  //只在第一次成功请求后设置
					});//on function end
					
					show(data);	//显示数据
		        },
		        error: function(request) {
		            swal({
		                title: "连接失败",
		                text: "连接失败，1秒后关闭",
		                timer: 1000,
		                showConfirmButton: false
		            });
		        }
		    });	//ajax请求结束的位置
		}
		
		function get_ajax(num,row)
		{
			var get_url ="/ArticlePost/queryList?page="+num+"&rows="+row;
			$.ajax({
		        url:get_url,
		        type:"get",
		        async:true,
		        success:function(data)
		        {
		        	console.log("成功取得数据,总分页数:"+data.pages);
		        	pages= data.pages;		//总页数
		        	
					//之后的每次只是配置展示，不再配置点击
					$('#pagination').bootpag({
					    total: pages,          		// total pages
					    page: num,            	// default page
					    maxVisible: 10,     		// visible pagination
					    leaps: true,        	// next/prev leaps through maxVisible
					    firstLastUse: true,
					    first: '第一页',
					    last: '最后页',
					    nextClass: 'next',
					    prevClass: 'prev',
					    lastClass: 'last',
					    firstClass: 'first'
					});
					
					show(data);
		        },
		        error: function(request) {
		            swal({
		                title: "连接失败",
		                text: "连接失败，1秒后关闭",
		                timer: 1000,
		                showConfirmButton: false
		            });
		        }
		    });	//ajax请求结束的位置
		}; 	
		
		
		//获取数据后，在前端展示整体的数据
		function show(data)
		{
			var content_str="";
			var post_list=data.list;  
			
			for(var post_index in post_list)
			{
				var content_inner="";
				if(post_list[post_index].postType==0)
				{
					content_str+="" +
					 "<div class=\"panel panel-default\">"+
					 "	     	<div class=\"panel-body\">"+
					 "	     		<div class=\"row\">"+
					 "		    		 <input type=\"checkbox\">123 id:12345"+
					 "		    	</div>	<!--row -->"+
					 "		    	<div class=\"row\">"+
					 "		    		<div class=\"col-md-12 well\">"+
					 post_list[post_index].postContent+
					 "		    		</div>"+
					 "		    	</div>	<!-- row -->"+
					 "		    	<div class=\"col-md-12\">"+
					 "<button id=\"button_edit\" type=\"button\"" +
					 	" name=\""+post_list[post_index].postId + "\" " +
					 "class=\"btn btn-primary btn-sm\" >编辑</button>"+
					 "					<button type=\"button\" class=\"btn btn-primary btn-sm\">删除</button>"+
					 "					<button type=\"button\" class=\"btn btn-primary btn-sm\">向上合并</button>"+
					 "					<button type=\"button\" class=\"btn btn-primary btn-sm\">插入文字</button>"+
					 "					<button type=\"button\" class=\"btn btn-primary btn-sm\">插入图片</button>"+
					 "					<button type=\"button\" class=\"btn btn-primary btn-sm\">移上一位</button>"+
					 "					<button type=\"button\" class=\"btn btn-primary btn-sm\">移下一位</button>"+
					 "		    	</div>	<!--row -->"+
					 "		    </div>"+
					 "    	</div><!--panel-->";
					
				}else if(post_list[post_index].postType == 1 )
				{
					content_inner="img class=\"img-responsive img-hover img-rounded\"  src=\"" +
						post_list[post_index].postContent+
						"\"alt=\"\">";
				}
			};		//for end
			//console.log(content_str);
			$('#ct').html(content_str);		//把空白地方的信息设置成字符串
			
			//edit button 的点击事件
			$("#button_edit").click(function()
			{
				console.log("点击的序号是："+$(this).name);       
			});
			
			//edit button 的点击事件
			$("#update_bt123").click(function()
			{
				var data=$("#post_123").val();
				$.ajax({
					  type: "POST",
					  url: url,
					  data: data,
					  success: success,
					  dataType: dataType
					});     
			});
		};	//show end
		
		//
		
		
});	//$function结束
		