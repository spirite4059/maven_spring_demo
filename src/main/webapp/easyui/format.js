
/************************************************************************************************************/
/**
 * 国家格式化
 */
function formatCountry(val, row) {
	var text='暂无';
	/*if(_country!=undefined){
		
	}*/
	for(var i=0;i<_country.length;i++){
		if(_country[i].id==val){
			text = _country[i].text;
			break;
		}
	}
	return text;
}

/**
 * 地区格式化
 * @param val
 * @param row
 * @returns {String}
 */
function formatArea(val, row) {
	var text='暂无';
	if(val!=null && val!=""){
	   var country_code = val.substring(0,4);
	   var _json = eval("_"+country_code);
	   for(var i=0;i<_json.length;i++){
		  if(_json[i].id==val){
			  text = _json[i].text;
			  break;
		  }   
	   }
	}
	return text;
}

/**
 * 地市格式化
 * @param val
 * @param row
 * @returns {String}
 */
function formatCity(val, row) {
	var text='暂无';
	if(val!=null && val!=""){
	   var area_code = val.substring(0,6);
	   var _json = eval("_"+area_code);
	   for(var i=0;i<_json.length;i++){
		  if(_json[i].id==val){
			  text = _json[i].text;
			  break;
		  }   
	   }
	}
	return text;
}

/**
 * 启用状态
 * @param val
 * @param row
 * @returns {String}
 */
function formatStatus(val, row) {
	if (val == 1) {
		return '正常使用';
	}else if (val == 2) {
		return '已禁用';
	}else if (val == 3) {
		return '待分配';
	}else if (val == 4) {
		return '邮寄中';
	}else if (val == 5) {
		return '待收回';
	}else if (val == 6) {
		return '待维修';
	}else if (val == 7) {
		return '待启用';
	}else if (val == 8) {
		return '丢失';
	}else if (val == 9) {
		return '作废';
	}else if (val == 10) {
		return 'offline';
	}else {
		return '已禁用';
	}
}
/**
 * 适用状态
 * @param val
 * @param row
 * @returns {String}
 */
function formatIsApply(val, row) {
	if (val == 1) {
		return '适用';
	} else {
		return '不适用';
	}
}
/**
 * 分屏数量
 * @param val
 * @param row
 * @returns {String}
 */
function formatScreenNum(val, row) {
	if (val == 4) {
		return '4屏';
	} else if(val == 1) {
		return '1屏';
	}
}
/**
 * 广告来源
 * @param val
 * @param row
 * @returns {String}
 */
function formatSource(val, row) {
	if (val == 1) {
		return '自有';
	} else if(val == 2){
		return '商家';
	}
}

function dateFormat(now) {
	var result=[];
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var date = now.getDate();
	var hour = now.getHours();
	var minute = now.getMinutes();
	var second = now.getSeconds();
	result.push(year);
	result.push(month);
	result.push(date);
	result.push(hour);
	result.push(minute);
	result.push(second);
	return result;
} 

/**
 * 格式化时间YYYY-MM-DD
 * @param val
 * @param row
 * @returns {String}
 */
function formatYYYYMMDD(val, row){
	if(val==null || val==""){
		return "";
	}
	var result = dateFormat(new Date(val));
	return result[0]+ "-" + result[1] + "-" + result[2];
}

/**
 * 格式化时间YYYY-MM-DD HH:MM:SS
 * @param val
 * @param row
 * @returns {String}
 */
function formatYYYYMMDDHHMMSS(val, row){
	if(val==null || val==""){
		return "";
	}
	var result = dateFormat(new Date(val));
	return result[0]+ "-" + result[1] + "-" + result[2]+ " " + result[3] + ":" + result[4] + ":" + result[5];
}

/**
 * 店铺类型
 * @param val
 * @param row
 * @returns {String}
 */
function formatPlaceType(val, row) {
	if (val == 1) {
		return '非清真餐厅';
	} else if(val == 2){
		return '大使馆';
	}else if(val == 3){
		return '商场';
	}else if(val == 4){
		return '美甲区';
	}else if(val == 5){
		return '其他';
	} else if(val == 6){
		return '清真餐厅';
	}
}

/**
 * 广告类型
 * @param val
 * @param row
 * @returns {String}
 */
function formatAdvertisementType(val, row) {
	if (val == 1) {
		return '视频类型';
	} else if(val == 2){
		return '图片类型';
	}else if(val == 3){
		return '文字类型';
	}
}

function adsType(val, row){
	 if (val == 1) {
		return '图片';
	 } else {
		return '文字';
	 }
}

function formatValid(val, row) {
	if (val == 1) {
		return '有效';
	} else {
		return '无效';
	}
}
function formatOnlineStatus(val, row) {
	if (val == 1) {
		return '上线';
	} else {
		return '下线';
	}
}


function formatOrderStatus(val,row){
	var text='';
	if(val=='0'){
		text = '已取消';
	}else if(val=='1'){
		text = '待审核';
	}else if(val=='2'){
		text = '审核通过';
	}else if(val=='3'){
		text = '审核不通过';
	}else if(val=='4'){
		text = '已过期';
	}
	return text;
}

function formatImage(val,row){
	if(val!=null && val!=''){
		return '<img src="' + val + '" style="width:80px;height:80px">';
	}
	return '';
}