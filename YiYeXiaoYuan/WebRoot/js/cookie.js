
			function setCookie(name,value,time){
				var strsec = getsec(time);
				var exp = new Date();
				exp.setTime(exp.getTime() + strsec*1);
				document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
			}
			function getsec(str){
				var str1=str.substring(1,str.length)*1;
				var str2=str.substring(0,1);
				if (str2=="s")
				{return str1*1000;}
				else if (str2=="h")
				{return str1*60*60*1000;}
				else if (str2=="d")
				{return str1*24*60*60*1000;}
			}

				function getCookie(name)	//取cookies函数        
				{
				    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
				    try{
				     if(arr != null) return decodeURI(arr[2]); return null;
				   }catch(err){
				   	
			  }
				}
				function delCookie(name)	//删除cookie
				{
				    var exp = new Date();
				    exp.setTime(exp.getTime() - 1);
				    var cval=getCookie(name);
				    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
				}