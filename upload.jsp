/**
  *参数说明： url：下载地址，val:需要提交的参数值，具体类型和个数自行扩展
  * 参数可以用obj = {url:""",val1:"111",val2:"222",...}这样的 格式，也可以用(url,val1,val2....)根据自己喜好来
  */
function ajaxPostLoadFile(url,val){
	var form = $("<form>");//定义一个form表单
	form.attr("id", "downloadform");
	form.attr("style", "display:none");//将表单隐藏
	form.attr("target", "");
	form.attr("method", "post");
	form.attr("action", url);

	var input1 = $("<input>");
	input1.attr("type", "hidden");
	input1.attr("name", "testName");
	input1.attr("value", val);
	//如果有多个参数，参照上面input1 的写法

	form.append(input1);//一定要把参数添加到form里
	$("body").append(form);//将表单放置在页面中
	form.submit();//表单提交
	$("#downloadform").remove();//移除表单
}
