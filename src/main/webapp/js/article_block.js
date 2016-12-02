
$(function(){
	
	var globalCurrentPage=1;//默认设置成1
	var url=$.url();	
	var globalArticleId=url.param("articleId");
	
	if(globalArticleId==undefined)
	{	//异常,无法正常运行了
		return;
	}
	
	//初始的时候，设置
	var row=10;
	var pages;

	
	init_data(1,row);
	
	//第一次请求分页条的范围和信息
	function init_data(num,row)	
	{
		var get_url ="/ArticleBlock/queryList";
		
		$.ajax({
	        url:get_url,
	        type:"get",
	        async:true,
	        data:{page:num,rows:row,articleId:globalArticleId},	
	        success:function(data)
	        {
	        	console.log("成功取得数据,总分页数:"+data.pages);
	        	pages= data.pages;		//总页数
				
				$('#pagination').bootpag({
				    total: pages,         		// total pages
				    page: num,            		// default page
				    maxVisible: 10,     		// visible pagination
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
	
	
	function get_ajax(num,row,articleId)
	{
		//请求list;
		var get_url ="/Article/queryList";   
		$.ajax({
	        url:get_url,
	        type:"get",
	        data:{page:num,rows:row,articleId:globalArticleId},
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
		var block_list=data.list;  
		
		for(var index in block_list)
		{
			content_str+=
			"			<div class=\"panel panel-default\">"+
			"		     	<div class=\"panel-body\">"+
			"		     		<div class=\"row\">"+
			"			    		 <input type=\"checkbox\"> id:" + block_list[index].blockId +
			"			    	</div>	<!--row -->"+
			"	    	 		<div class=\"col-md-12 content_div\">"+
			"					 	<textarea class=\"form-control\" readonly  id=\"post_123\">"+block_list[index].blockContent+"</textarea>"+
			"					</div>"+
			"					<div class=\"col-md-12\">"+
			"			    		<button type=\"button\" class=\"btn btn-primary btn-sm edit_class\" >编辑</button>"+
			"			   			<button type=\"button\" class=\"btn btn-primary btn-sm update_class\">保存</button>"+
			"						<button type=\"button\" class=\"btn btn-primary btn-sm delete_class\" >删除</button>"+
			"						<button type=\"button\" class=\"btn btn-primary btn-sm merge_up_class\">向上合并</button>"+
			"						<button type=\"button\" class=\"btn btn-primary btn-sm insert_text_class\">插入文字</button>"+
			"						<button type=\"button\" class=\"btn btn-primary btn-sm insert_img_class\">插入图片</button>"+
			"						<button type=\"button\" class=\"btn btn-primary btn-sm move_down_class\">移上一位</button>"+
			"						<button type=\"button\" class=\"btn btn-primary btn-sm move_up_class\">移下一位</button>"+
			"						<input  type=\"hidden\" value=\""+ block_list[index].blockId +"\" >"+
			"						<input  type=\"hidden\" value=\"0\" >"+
			"			    	</div>	<!--row -->		"+
			"				</div> <!--panel-body-->	"+
			"			</div> <!-- panel -->		"
			;
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
		
		//edit functions
		edit_fun();	//直接调用
		
	};	//show end
	
	
	//show函数之后，必须是页面已经都调用完成了，才会真正调用起来
	//***这是一个配置函数，对元素配置了相关的点击事件
	var edit_fun= function()
	{
		//先把所有的textarea设置成随着输入变化
		autosize($('textarea'));
		
		//修改每个页面的状态
		$('button.edit_class').click(function()
		{	
			//当前单元格的属性,id和类型
			var my_id 	= $(this).parent().children('input').eq(0).prop('value');
			var my_type = $(this).parent().children('input').eq(1).prop('value');
			
			//获取了内容部分的div
			var textArea = $(this).parent().parent(".panel-body").find('textarea');
	
			
			//点击编辑修改只读属性
			if(textArea.prop('readonly'))
			{
				textArea.prop('readonly',false);
			}else
				textArea.prop('readonly',true);
			
			console.log(my_id);
			
		});
		
		
		//点击保存按钮的时候  
		$('button.update_class').click(function()
		{	
			//当前单元格的属性
			var my_inputs = $(this).parent().children('input');
			var my_id=my_inputs.eq(0).prop('value'); 		//第一个参数
			var my_type = my_inputs.eq(1).prop('value');	
			
			//获取了内容部分的div
			var textArea = $(this).parent().parent(".panel-body").find('textarea');
			var update_data = 	JSON.stringify({blockId:my_id,
												blockContent:textArea.val(),
												articleId:globalArticleId,
												blockType:0});
			
			//提交代码
			$.ajax({
				url:"/ArticleBlock/update",
				type:'post',
				data:update_data,		//上传的数据
				dataType:"json",      
		        contentType:"application/json",  
				success:function(data) 
				{
					if(data.status==true)
		    		{
		    			swal({
		    				  title: "成功",
		    				  text: data.msg,
		    				  timer: 1000,
		    				  showConfirmButton: false 
		    				});
		    		}else if(data.status==false)
		    		{
		    			swal({
		    				  title: "失败",
		    				  text: data.msg,
		    				  timer: 2000,
		    				  showConfirmButton: false
		    			});
		    		};  
				}//succeed end
			});
		});	//update click end
		
		
		//点击保存按钮的时候
		$('button.insert_text_class').click(function()
		{
			//当前单元格的属性
			var my_inputs = $(this).parent().children('input');
			var my_id=my_inputs.eq(0).prop('value');
			var my_type = my_inputs.eq(1).prop('value');
			
			//获取了内容部分的div
			var textArea = $(this).parent().parent(".panel-body").find('textarea');
			
			var data1={
					index:my_id,
					"articleBlock":{
							"articleId":globalArticleId,
							"blockContent":"",
							"blockType":0,
							"date":""
							}
						};
			
			//提交代码
			$.ajax({
				url:"/ArticleBlock/insert",	//插入文章block
				type:'post',
				data:JSON.stringify(data1),
				dataType:"json",      
				contentType: "application/json",
				success:function(data) 
				{
		    		console.log( "Data Loaded: " + data );
		    		//如果成功的话，提示成功，1秒消失
				},
				error:function(data)
				{
					console.log(data);
				}
			});
			
			var content=textArea.val();
			//点击编辑修改只读属性
			if(textArea.prop('readonly'))
			{
				textArea.prop('readonly',false);
			}else
				textArea.prop('readonly',true);
			console.log(my_id);	
		});	//插入按钮结束
		
		
		//点击删除按钮的时候进行的操作
		$('button.delete_class').click(function()
		{
			//当前单元格的属性
			var my_inputs = $(this).parent().children('input');
			var my_id=my_inputs.eq(0).prop('value');
			var delete_data={blockId:my_id,articleId:globalArticleId};
			
			//提交代码
			$.ajax({
				url:"/ArticleBlock/delete",	//插入文章碎片
				type:'get',
				data:delete_data,
				success:function(data) 
				{
					if(data.status==true)
		    		{
		    			remove_fun();
		    			swal({
		    				  title: "成功",
		    				  text: data.msg,
		    				  timer: 1000,
		    				  showConfirmButton: false 
		    				});
		    			
		    			//真的删除当前的元素

		    		}else if(data.status==false)
		    		{
		    			swal({
		    				  title: "失败",
		    				  text: data.msg,
		    				  timer: 2000,
		    				  showConfirmButton: false
		    			});
		    		};  
				}//succeed end
			});//ajax end
			
			//alert(this);
			
			var remove_fun=function()
			{	
				$(this).parent().parent().parent().remove();
			}.bind(this);
			
		});	//delete bt end
	}	//edit之后相关操作结束 end
	

	
	//插入按钮 ，这个不用在加载之后调用，因为这个是页面的基本元素
	//特别的元素
	$('#insert_bt').click(function()
	{	
		var str=JSON.stringify({articleName:"",articleList:""});
			
		//提交代码
		$.ajax({
			url:"/ArticleBlock/insertAndGetId",	//插入文章碎片
			type:'post',
			data:str,
			dataType:"json",      
	        contentType:"application/json",  
			success:function(data) 
			{
	    		//console.log( "Data Loaded: " + data.status );
	    		if(data.status==true)
	    		{
	    			swal({
	    				  title: "提示",
	    				  text: data.msg,
	    				  timer: 1000,
	    				  showConfirmButton: false 
	    				});
	    			
	    			//在最后插入一个新的展示，或者是直接刷新一下
	    			var html_str = $("#ct").html();
	    			//console.log(html_str);
	    			var insert_str =  
	    				"<div class=\"panel panel-default\">"+
	    				"		     	<div class=\"panel-body\">"+
	    				"		     		<div class=\"row\">"+
	    				"			    		 <input type=\"checkbox\"> id:" + data.data.key +
	    				"			    	</div>	<!--row -->"+
	    				"	    	 		<div class=\"col-md-12 content_div\">"+
	    				"					 	<textarea class=\"form-control\" readonly  id=\"post_123\"></textarea>"+
	    				"					</div>"+
	    				"					<div class=\"col-md-12\">"+
	    				"			    		<button type=\"button\" class=\"btn btn-primary btn-sm edit_class\" >编辑</button>"+
	    				"			   			<button type=\"button\" class=\"btn btn-primary btn-sm update_class\">保存</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm delete_class\" >删除</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm merge_up_class\">向上合并</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm insert_text_class\">插入文字</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm insert_img_class\">插入图片</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm move_down_class\">移上一位</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm move_up_class\">移下一位</button>"+
	    				"						<input  type=\"hidden\" value=\""+ data.data.key +"\" >"+
	    				"						<input  type=\"hidden\" value=\"0\" >"+
	    				"			    	</div>	<!--row -->"+
	    				"				</div>";
	    			html_str=insert_str+html_str;
	    			//console.log(html_str);
	    			$("#ct").html(html_str);
	    			edit_fun();
	    			
	    		}else if(data.status==false)
	    		{
	    			swal({
	    				  title: "提示",
	    				  text: data.msg,
	    				  timer: 1000,
	    				  showConfirmButton: false
	    			});
	    		};  
			}
		});//ajax end
	});	//insert_bt end
	
});









