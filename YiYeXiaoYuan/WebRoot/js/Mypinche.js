/** * Created by p on 2016/11/14. */$(function(){	var uid= window.sessionStorage.getItem('userId')			$.ajax({
				type:"post",
				url:"",
				dataType:'json',				success:function(data){					var appendData="";										var template1=						'<li>'+					'<div class="one-information">'+						'<div class="overlay"></div>'+						'<div class="information-time">'+							'<span>时间:</span>'+							'<span id="peo1-date" class="time-date startTime_date">'+data[i].startDate+'</span>'+							'<span id="peo1-time" class="time-time startTime_time">'+data[i].startTime+'</span>'+						'</div>'+						'<div class="information-where">'+							'<span>出发:'+							'<span class="where-start startPos">'+data[i].startPos+'</span>'+							'</span>'+							'<span class="where-end">到达:</span>'+							'<span class="where-finish arrivePos">'+data[i].arrivePos+'</span>'+						'</div>'+						'<div class="love-pinche">'+							'<span>真爱校园大巴群:<b>136777985</b></span>'+							'<span>注意事项:</span>'+							'<span class="love-1">&emsp;&emsp;&emsp;&emsp;请等待送票员上门送票</span>'+							'<span class="love-2">&emsp;&emsp;&emsp;&emsp;提前半小时到达上车点</span>'+						'</div>'+					'</div>'+					'</li>'										for(var i=0;i<data.length;++i){						appendData+=template1;					}					$('#list-information').append(appendData);				}
			});			$.ajax({				type:"post",				url:"servlet/MInformationServlet",				data:{'id':uid},				dataType:'json',				success:function(data){					var appendData="";										var template2=						'<li>'+							'<div class="one-information">'+								'<div class="overlay"></div>'+								'<div class="information-time">'+									'<span>时间:</span>'+									'<span id="peo1-date" class="time-date startTime_date">'+data[i].startDate+'</span>'+									'<span id="peo1-time" class="time-time startTime_time">'+ carData[i].startTime_min_hour																	+ ':'																	+ carData[i].startTime_min_min																	+ '-'																	+ carData[i].startTime_max_hour																	+ ':'																	+ carData[i].startTime_max_min'</span>'+								'</div>'+								'<div class="information-where">'+									'<span>出发:'+									'<span class="where-start startPos">西电南校区</span>'+									'</span>'+									'<span class="where-end">到达:</span>'+									'<span class="where-finish arrivePos">咸阳国际机场</span>'+								'</div>'+								'<div class="information-people">'+									'<span class="glyphicon glyphicon-user people-applied"></span>'+									'<span class="glyphicon glyphicon-user"></span>'+									'<span class="glyphicon glyphicon-user"></span>'+									'<span class="glyphicon glyphicon-user"></span>'+									'<span class="glyphicon glyphicon-user"></span>'+									'<span class="people-number">上限<p class="maxMember" style="display: inline;">'+data[i].maxMember+'</p>人，已有<p class="curtMember"  style="display: inline;">'+data[i].curtMember+'</p>人</span>'+								'</div>'+								'<div class="information-remark">'+									'<span>备注:</span>'+									'<span class="remark-content message">'+data[i].message'+</span>'+								'</div>'+								'<div class="information-issue">'+									'发布于<span class="issue-date pubtime">'+data[i].pubTime+'</span>'+								'</div>'+									'<a href="#" role="button" class="issue-btn btn  btn-quxiao">取消</a>'+									'<a href="#" role="button" class="issue-btn btn  btn-see">查看联系方式</a>'+									'<a href="fankui.html" role="button" class="issue-btn btn  btn-fankui">反馈</a>'+								'</div>'+							'<div class="peoTel">'+								'<ul class="list-unstyled" id="passenger_num">'+									'<li>'+										'<span class="glyphicon glyphicon-user people-applied"></span>'+										'<p id="pelTel-id">'+data[i].发起者id+'</p>'+										'<p>手机:&nbsp;<span id="pelTel-tel">'+data[i].发起者tel+'</span></p>'+										'<p>QQ:&nbsp;<span id="pelTel-qq">'+data[i].发起者QQ+'</span></p>'+									'</li><!--发起者-->'+								'</ul>'+							'</div>'+						'</li>'//					var inforPeo="";
//					var  inforPeo1='<span class="glyphicon glyphicon-user"></span>';					for(var i=0;i<data.length;++i){						appendData+=template2;					}					$('#list-information').append(appendData);				}			});										        (".btn-see").on('click tap', function () {	        	var userData=	        		'<li>'+						'<p>'+data[i].userName+'</p>'+						'<p>手机:&nbsp;<span>'+data[i].mobile+'</span></p>'+						'<p>QQ:&nbsp;<span>'+data[i].userQQ+'</span></p>'+					'</li>'				var appendData="";	        	$.ajax({	        		type:'post',	        		url:'',	        		dataType:'json',	        		data:{'id':uid},	        		success:function(data){	        			for(var i=0;i<data.length;++i){							appendData+=userData;							}	        			$(this).parent("div").next("div").find("ul").append(aapendData);	        		},	        		error:function(){	        			alert('出问题了');	        		}	        	})                    $(this).parent("div").next("div").slideToggle(300);                });//下拉显示联系人                                                                var arr1=$("#list-information").children("li");                arr1.each(function(index){                    var that=$(this);                    var timerDate=that.find("span.time-date").text();                    var timerTime=that.find("span.time-time").text().split("-",2);                    timerDate = timerDate.replace(new RegExp("-","gm"),"/");                    timerDate =(new Date(timerDate)).getTime();                    timerTime[0] =timerTime[0].split(":",2);                    var	timermiao=timerTime[0][0]*60*60*1000+timerTime[0][1]*60*1000;                    timermiao= timermiao+timerDate;                    var timer=new Date();                    timer=timer.getTime();                    if(timer>timermiao)                    {                        that.find('.btn-see').remove();                        that.find('.btn-quxiao').remove();                        that.find('.btn-fankui').css("display","block");                        that.find('.overlay').css("display","block");                    }                });//判断是否是已完成的拼车    $.ajax({        method:'post',        url:'',        dataType:'json',        data:{            //usr.id        },        success:function (data) {            var $box=$('.list-unstyled >li:eq(0)');            var $container=$('.sample');            var clone=function(num){                for(var i=0;i<num;i++){                    $container.append($box.clone());                }            };            if(data>=1){                clone(data-1);//克隆n-1个容器            }else{                $box.remove();                $('#start_txt').html('千里之行始于足下，快来添加新的拼车吧~');            }        },        error:function () {            console.log('Net Wrong');            var $box=$('.list-unstyled >li:eq(0)');            $box.remove();            $('#start_txt').html('千里之行始于足下，快来添加新的拼车吧~');        }    });//请求拿到数据});