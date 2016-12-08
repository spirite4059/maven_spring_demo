/**
 * 所有以“_”开始的方法和变量都属于内部变量，不对外使用。
 */

$(document).ready(function() {
	addWin = $('#add-window').dialogFrameWindow();
	addForm = $('#addForm').form();
	modifyWin = $('#modify-window').dialogFrameWindow();
	modifyForm = $('#modifyForm').form();
	lookUpWin = $("#lookUpSelect-window").dialogFrameWindow();
	$("#add-window, #modify-window").window({ 
		top:60,   
        left:300,
        width:600,
        height:360,
		resizable: false
	});
	
	//新增时判断是否选择到地区
	$("#add_cityCode").combotree({
		onSelect: function (node) {
			var cityCode = node.id;
			if(cityCode != null){
				if(cityCode.length != 8){
					alert("请选择精确到地区！");
					$("#add_cityCode").combotree("clear");
				}
			}
		}
	});
});

var modifyWin;
var modifyForm;	
var addWin;
var addForm;
var lookUpWin;
/**
 * 回调查询
 */
function callback(data){
	if(data.status)
		grid.datagrid('reload',$("#queryForm").serializeObject());
	else
		$.messager.alert('系统提示',data.msg,'warning');	
}

/**
 * 增加
 */
function add(){
	addWin.window('open');
	$("#add_save").linkbutton("enable");
	//XFrameUtils.clearForm('addForm');
	$('#addForm').form('reset');
	//$("#add_cityCode").combotree('setValue','');
	//$("#add_status,#add_source,#add_type").combobox('setValue','1');
	//$("#add_screenNum").combobox('setValue','1');
	addDefaultCheck();
}

function addDefaultCheck(){}  

function modify(){
	var row = grid.datagrid('getSelected');
	if (row){
		modifyRow(row);
	} else {
		$.messager.show({
			title:'系统提示', 
			msg:'请先选择信息。'
		});
	}
}

//更新
function modifyRow(row){
		modifyWin.window('open');
		//XFrameUtils.clearForm('modifyForm'); 
		$('#modifyForm').form('clear');
		//XFrameUtils.fillForm('modifyForm',row);
		$('#modifyForm').form('load',row);
		modifyDefaultCheck(row);
}

function modifyDefaultCheck(row){
}

//模块名称
function removeModule(){
	var row = grid.datagrid('getSelected');
	if (row){
		$.messager.confirm('系统提示', '确定要删除这条记录吗？', function(r){
			if (r){
				$.post('delete?id='+row.id,'',callback,'json');
			}
		});
	} else {
		$.messager.show({
			title:'系统提示', 
			msg:'请先选择信息'
		});
	}
}

//校验用户名的唯一性
//修改时
function checkUpdateUserName(id, userName, url){
	var userId = $("#id").val();
	checkUserName(id, userId, userName, url);
}

//添加时
function checkUserName(id, userId, userName, url){
	$.ajax({  
		    url:url,   
		    data:{  
		    	id : userId,
		    	userName : userName
		    },  
		    type:'post',  
		    dataType:'json',  
		    success:function(data) { 
		        if(data == false ){
		        	alert("用户名已存在，请重新输入！");
		            $("#"+id).val(''); 
		            $("#"+id).focus();
		        } 
		     },  
		     error : function() {  
		          alert("异常！");  
		     }  
		});
}

//校验确认密码
function checkRetPassword(){
	var psw = $("#password").val();
	var r_psw = $("#ret_password").val();
	if((psw == null || psw == "") && (r_psw != null && r_psw != "")){
		alert("请先输入密码！");
		$("#password").focus();
		$("#ret_password").val('');
	} else if((psw != null && psw != "") && (r_psw != null && r_psw != "") && psw != r_psw){
		alert("两次输入的密码不一样!");
		$("#ret_password").focus();
		$("#ret_password").val('');
	}
}

//焦点定位
function onFocusMain(){
	$('#mainPanel').focus();
}

//有地区查询条件的查询的查询
function queryWithCode(){
	$("#queryCountryCode").val("");
	$("#queryAreaCode").val("");
	$("#queryCityCode").val("");
	var code = $("#query_code").combotree("getValue");
	if(code != null && code != ""){
		if(code.length == 4){
			$("#queryCountryCode").val(code);
		} else if(code.length == 6){
			$("#queryCountryCode").val(code.substring(0,4));
			$("#queryAreaCode").val(code);
		}else if(code.length == 8){
			$("#queryCountryCode").val(code.substring(0,4));
			$("#queryAreaCode").val(code.substring(0,6));
			$("#queryCityCode").val(code);
		}
	}
	query();
}

//?? 什么地方定义的??  加了参数做查询  
function query(){
	grid.datagrid('reload',$("#queryForm").serializeObject());	
}

//带有校验唯一性的保存
function addCheckSave(url){
	if(addForm.form('validate')){
		$("#add_save").linkbutton("disable");
		$.post( url,$("#addForm").serializeObject(),addCheckCallback,'json');		
	}
}

function addCheckCallback(data){
	if(!data.status){
		var mes = data.msg;
		if(mes == "exist"){//数据库已存在，值为空，不能保存
			$("#add_check").val(''); //add_check校验唯一性的字段id
		}else{
			$.messager.alert('系统提示',data.msg,'warning');
		}
	}else{
		addWin.window('close');
		grid.datagrid('reload',$("#queryForm").serializeObject());
	}
	$("#add_save").linkbutton("enable");
}

function addCallback(data){
	if(!data.status){
		$.messager.alert('系统提示',data.msg,'warning');
	}else{
		addWin.window('close');
		grid.datagrid('reload',$("#queryForm").serializeObject());
	}
	$("#add_save").linkbutton("enable");
}


function addSave(url){
	if(addForm.form('validate')){
		$("#add_save").linkbutton("disable");
		$.post( url,$("#addForm").serializeObject(),addCallback,'json');		
	}
}


function cancel(){
	addWin.window('close');
}

//=================================修改==============

function modifySave(url){
	if(modifyForm.form('validate')){
		$("#update_save").linkbutton("disable");
		$.post(url,$("#modifyForm").serializeObject(),modifyCallback,'json');		
	}
}
	
function modifyCallback(data){
	if(!data.status){
		$.messager.alert('系统提示',data.msg,'warning');
	}else{
		modifyWin.window('close');
		grid.datagrid('reload',$("#queryForm").serializeObject());	
		$("#update_save").linkbutton("enable");
	}
}
//带有校验唯一性的保存
function modifyCheckSave(url){
	if(modifyForm.form('validate')){
		$("#update_save").linkbutton("disable");
		$.post(url,$("#modifyForm").serializeObject(),modifyCheckCallback,'json');		
	}
}
	
function modifyCheckCallback(data){
	if(!data.status){
		var mes = data.msg;
		if(mes == "exist"){//数据库已存在，值为空，不能保存
			$("#update_check").val(''); //update_check校验唯一性的字段id
		}else{
			$.messager.alert('系统提示',data.msg,'warning');
		}
	}else{
		modifyWin.window('close');
		grid.datagrid('reload',$("#queryForm").serializeObject());	
		$("#update_save").linkbutton("enable");
	}
}
function winClose(){
	modifyWin.window('close');
}


function uploadPic(form,id,idFileId,urlTmp){
	var reg = /(jpg|gif|bmp|png)/i;
	if(!reg.test($(idFileId).val())){
		$.messager.alert("提示","请选择图片");
		return ;
	}
	$('#'+form).form('submit',{
		url:XFrame.getContextPath()+ urlTmp,
		success:function(data){
			var object =eval('('+data+')');
		 	if(object.success){
		   		$.messager.alert("提示","上传成功");
		   		$(id).val(object.msg);
		   	}else{
		   		if(object.msg!=undefined&&object.msg!=null&&object.msg!=''){
		   			$.messager.alert("提示",object.msg);
		   		}else{
		   			$.messager.alert("提示","上传失败，请重试");
		   		}
		   	}
		}
	});
}

function show(text){
	if(text==''){
		$.messager.alert("提示","暂无图片");
		return ;
	}
	$("#custom").attr("src",text);
	$("#priewPicWin").window({width:300,height:300,top:100});
	$("#priewPicWin").window('open');
}

function showPic(picId){
	var text = $(picId).val();
	show(text);
}

function pressEnter(event,functionname){
	if(event.keyCode==13){
		functionname();
	}
}

$(function(){
//	
//	var default_option = "<option value=''>--请选择--</option>";
//	var country = $("select[id$='countryCode']");
//	country.html("");
//	country.append(default_option);
//	for (i = 0; i < _country.length; i++) {
//		country.append("<option value="+_country[i].id+">"+_country[i].text+"</option>");
//	}
//	
//	$("select[id$='areaCode'],select[id$='cityCode']").html(default_option);
//	
//	$("select[id$='countryCode'],select[id$='areaCode']").change(function(){
//		   var value = $(this).val();
//		   var targetId = $(this).attr("target");
//		   var data = eval("_"+value);
//		   $("#"+targetId).html(default_option);
//		   for (i = 0; i < data.length; i++) {
//				$("#"+targetId).append("<option value="+data[i].id+">"+data[i].text+"</option>");
//			}
//	});
//	
//	
//	$("table","#addForm,#modifyForm").attr("class","table-bordered");
//	var table = "table[class='table-bordered']";
//	$("tr:eq(0) > td",table).attr("style","border-top:0px");
//	$("tr > td:even",table).attr("bgcolor","#E0ECFF");
//	$("tr > td:nth-child(1)",table).attr("style","border-left:0px");
//	$("tr > td:eq(0)",table).attr("style","border-left:0px;border-top:0px;");
//	
});

/**************************************************************************************************************/
//lookup
function openLookUp(url) {
	lookUpWin.dialogFrameHtml(url);
}

function openLookUpCallBack(row){
	$('#add_lookUpId,#edit_lookUpId').val(row.id);
	$('#add_lookUpName,#edit_lookUpName').val(row.userName);
	$('#add_lookUpCname,#edit_lookUpCname').val(row.cname);
	$('#edit_cityCode').val(row.cityCode);
	
	$('#add_lookUpName,#edit_lookUpName').validatebox({novalidate: true});
	
	
	lookUpWin.window('close');
}

function resetQueryForm(){
	   $('#queryForm').form('reset');
	   $(':input').val('');
}
