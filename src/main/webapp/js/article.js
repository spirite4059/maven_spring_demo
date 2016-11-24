
$(function(){
	
	
	//修改每个页面的状态
	$('button.edit_class').click(function()
	{	
		//当前单元格的属性,id和类型
		var my_id = $(this).parent().children('input').eq(0).prop('value');
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
	$('button.save_class').click(function()
	{	
		//当前单元格的属性
		var my_inputs = $(this).parent().children('input');
		var my_id=my_inputs.eq(0).prop('value');
		var my_type = my_inputs.eq(1).prop('value');
		//获取了内容部分的div
		var textArea = $(this).parent().parent(".panel-body").find('textarea');
		
		//提交代码
		$.ajax({
			url:"/post/savePost",
			type:'post',
			data:"{id:"+my_id+",content:"+textArea.val()+"}",
			success:function(data) 
			{
	    		cosole.log( "Data Loaded: " + data );
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
	});	//保存按钮结束
	
	
	//点击插入按钮
	//点击保存按钮的时候
	$('button.insert_class').click(function()
	{	
		//当前单元格的属性
		var my_inputs = $(this).parent().children('input');
		var my_id=my_inputs.eq(0).prop('value');
		var my_type = my_inputs.eq(1).prop('value');
		
		//提交代码
		$.ajax({
			url:"/post/insertPost",	//插入文章碎片
			type:'post',
			data:"{id:"+my_id+",content:"+textArea.val()+"}",
			success:function(data) 
			{
	    		cosole.log( "Data Loaded: " + data );
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
	});	//保存按钮结束
	
	
	//插入按钮 
	$('#insert_bt').click(function()
	{	
		var str=JSON.stringify({articleName:"",articleList:""});
			
		//提交代码
		$.ajax({
			url:"/Article/insertAndGetId",	//插入文章碎片
			type:'post',
			data:str,
			dataType:"json",      
	        contentType:"application/json",  
			success:function(data) 
			{
	    		console.log( "Data Loaded: " + data.status );
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
	    			console.log(html_str);
	    			var insert_str =  
	    				"<div class=\"panel panel-default\">"+
	    				"		     	<div class=\"panel-body\">"+
	    				"		     		<div class=\"row\">"+
	    				"			    		 <input type=\"checkbox\"> id:" + data.msg.key+
	    				"			    	</div>	<!--row -->"+
	    				"	    	 		<div class=\"col-md-12 content_div\">"+
	    				"					 	<textarea class=\"form-control\" readonly rows=\"3\"  id=\"post_123\"></textarea>"+
	    				"					</div>"+
	    				"					<div class=\"col-md-12\">"+
	    				"			    		<button type=\"button\" class=\"btn btn-primary btn-sm edit_class\" >编辑</button>"+
	    				"			   			<button type=\"button\" class=\"btn btn-primary btn-sm save_class\">保存</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm delete_class\" >删除</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm merge_up_class\">向上合并</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm insert_text_class\">插入文字</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm insert_img_class\">插入图片</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm move_down_class\">移上一位</button>"+
	    				"						<button type=\"button\" class=\"btn btn-primary btn-sm move_up_class\">移下一位</button>"+
	    				"						<input  type=\"hidden\" value=\"12345\" >"+
	    				"						<input  type=\"hidden\" value=\"0\" >"+
	    				"			    	</div>	<!--row -->"+
	    				"				</div>";
	    			html_str=insert_str+html_str;
	    			console.log(html_str);
	    			
	    			$("#ct").html(html_str);
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
	
	
	//初始和列表
	
	
	
	
	
});









