
	//用来获取请求里面的参数
	//******使用****** 
	// query string: ?foo=lorem&bar=&baz
	//	var foo = getParameterByName('foo'); // "lorem"
	//	var bar = getParameterByName('bar'); // "" (present with empty value)
	//	var baz = getParameterByName('baz'); // "" (present with no value)
	//	var qux = getParameterByName('qux'); // null (absent)
	//**************** 
	function getParameterByName(name, url) {
	    if (!url) {
	      url = window.location.href;
	    }
	    name = name.replace(/[\[\]]/g, "\\$&");
	    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
	        results = regex.exec(url);
	    if (!results) return null;
	    if (!results[2]) return '';
	    return decodeURIComponent(results[2].replace(/\+/g, " "));
	}

	
