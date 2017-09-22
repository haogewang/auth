<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<form name="fileupload" enctype="multipart/form-data"
		action="./getExcelData" method="post">
		<p style="font-size:16px;">请选择正确的excel文件上传</p>
		<input id="txt" class="input" type="text" disabled="disabled"
			value="文件域" name="txt"> 
		<input id="file1" class="files" type="file" hidefocus="" size="1"
			style="height:26px;" name="file" onchange="txt.value=this.value">
		<br /> <input type="button" onclick="checkSuffix();" value="提交上传"
			style="height:26px;width:100px">
		<p style="color:red;">支持的excel格式为：xls、xlsx、xlsb、xlsm、xlst！</p>
	</form>
	<form name="filedownload" enctype="form-data"
		action="./export" method="post">
		<input type="submit" value="下载" style="height:26px;width:100px">
	</form>
	<script>
		function checkSuffix() {
			var name = document.getElementById("txt").value;
			var strRegex = "(.xls|.xlsx|.xlsb|.xlsm|.xlst)$";
			var re = new RegExp(strRegex);
			if (re.test(name.toLowerCase())) {
				alert("上传成功");
				document.fileupload.submit();
			} else {
				alert("文件名不合法");
			}
		}
	</script>
</html>

