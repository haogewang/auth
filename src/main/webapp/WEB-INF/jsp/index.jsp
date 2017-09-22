
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="./assets/images/favicon.ico">
<title>授权管理平台</title>
<!-- Bootstrap core CSS -->
<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./assets/css/app.css">
<link href="./assets/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
            <![endif]-->
<style>
.sidebar {
	width: 225px;
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	z-index: 1000;
	display: block;
	padding: 0 20px;
	overflow-x: hidden;
	overflow-y: auto;
	/* Scrollable contents if viewport is shorter than content. */
	background-color: #f5f5f5;
	border-right: 1px solid #eee;
}

.navbar {
	background: #f5f5f5;
	border-radius: 0;
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
}

.nav-sidebar {
	margin-right: -21px;
	margin-bottom: 20px;
	margin-left: -20px;
}

.nav-sidebar>li>a {
	padding-right: 20px;
	padding-left: 20px;
}

.nav-sidebar>.active>a, .nav-sidebar>.active>a:hover, .nav-sidebar>.active>a:focus
	{
	color: #fff;
	background-color: #428bca;
}

.main {
	padding: 75px 25px 25px;
	position: absolute;
}

.main .page-header {
	margin-top: 0;
}

.placeholders {
	margin-bottom: 30px;
	text-align: center;
}

.placeholders h4 {
	margin-bottom: 0;
}

.placeholder {
	margin-bottom: 20px;
}

.placeholder img {
	display: inline-block;
	border-radius: 50%;
}

.table {
	margin-bottom: 0;
}

.add {
	margin-bottom: 20px;
}

.table td a {
	cursor: pointer;
	text-decoration: none;
}

.table td a+a {
	margin-left: 10px;
}

.edit:hover, .delete:hover {
	text-decoration: none;
}

#addform_dialog .modal-dialog lable {
	position: relative
}

.require {
	color: red;
	position: absolute;
	top: 4px;
}

/*#addform_dialog .modal-dialog { position: absolute; top: 50%; left: 50%; margin: -1000px 0 0 -300px; }*/
#logout {
	cursor: pointer
}

textarea {
	resize: none
}

.pagination li a {
	cursor: pointer
}

.form-group {
	margin-bottom: 20px;
}

.navbar-brand {
	padding: 9px 25px;
}

.navbar-brand img {
	width: 30px;
	margin-right: 8px;
	display: inline-block
}

.navbar-brand span {
	vertical-align: middle;
	color: #999;
	font-size: 16px;
	display: inline-block;
	font-family: "AvenirNext-Regular", "Helvetica Neue", "lucida grande",
		"PingFangHK-Light", "STHeiti", "Heiti SC", "Hiragino Sans GB",
		"Microsoft JhengHei", "Microsoft Yahei", SimHei, "WenQuanYi Micro Hei",
		"Droid Sans", "Roboto", Helvetica, Tahoma, Arial, "sans-serif";
}

.modal span:focus {
	outline: none;
}
</style>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="main">
				<nav class="navbar">
					<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-1"
								aria-expanded="false">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand"><img
								src="./assets/images/favicon.ico" alt=""><span>EASTED
									ADMIN</span></a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a><span class="glyphicon glyphicon-user"
										style="margin-right: 10px"></span>admin</a></li>
								<li><a id="logout">注销</a></li>
							</ul>
						</div>
					</div>
				</nav>
				<div class="row">
					<div class="col-sm-3">
						<button type="button" class="btn btn-primary add" title="新建"
							data-toggle="modal" data-target="#addform_dialog">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							新建
						</button>
						<button type="button" class="btn btn-primary add" title="生成授权码"
							data-toggle="modal" data-target="#generateCode_dialog">
							<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
							生成授权码
						</button>
						<form name="filedownload" style="display:inline-block" enctype="form-data" id="exportData" method="post">
							<button type="submit" class="btn btn-primary add" value="下载"><span class="glyphicon glyphicon-export" aria-hidden="true"></span>
							导出</button>
						</form>
					</div>
					<div
						class="col-sm-3 col-sm-offset-3 col-md-4 col-md-offset-1 col-lg-2 col-lg-offset-5">
						<select id="search_status" class="form-control">
							<option value="">请选择状态</option>
							<option value="0">授权中</option>
							<option value="1">授权完成</option>
						</select>
					</div>
					<div class="col-sm-3 col-md-4 col-lg-2">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-search"></span>
							</div>
							<input type="text" class="form-control" id="search_all"
								placeholder="请输入搜索内容">
						</div>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover"
						id="list">
						<thead>
							<tr>
								<th>A级客户</th>
								<th>软件产品</th>
								<th>规格型号</th>
								<th>产品序列号</th>
								<th>产品授权码</th>
								<th>产品服务号</th>
								<th>并发数</th>
								<th>授权期限</th>
								<!--<th>B级客户机器码</th>-->
								<!--<th>B级授权序列号</th>-->
								<th>授权状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="10" align="center">暂无数据</td>
							</tr>
						</tbody>
					</table>
					<nav aria-label="Page navigation" class="text-right">
						<ul class="pagination" id="page">
							<li class="disabled"><a aria-label="Previous"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="disabled"><a aria-label="Next"> <span
									aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
		<div class="modal fade" id="addform_dialog" tabindex="-1"
			role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">新建</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-3 control-label">A级客户： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="aclient"
										autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">软件产品： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<select class="form-control" name="product">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">规格型号： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<select class="form-control" name="type">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">授权日期： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="date"
										autocomplete="off">
								</div>
							</div>
							<div class="form-group" data-step="1">
								<label class="col-sm-3 control-label">授权期限： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<select class="form-control" name="authTimeout" value="测试授权">
										<option value="测试授权(有效期30天)">测试授权(有效期30天)</option>
										<option value="永久授权">永久授权</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">并发数： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="superveneNumber"
										autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">产品序列号： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="serinumber"
										autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">产品授权码： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control"
										name="authorizationcode" autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">产品服务号： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="servernumber"
										autocomplete="off">
								</div>
							</div>
							<!--<div class="form-group">-->
							<!--<label class="col-sm-3 control-label">B级客户机器码：-->
							<!--<span class="require">*</span>-->
							<!--</label>-->
							<!--<div class="col-sm-8">-->
							<!--<textarea rows="2" class="form-control" name="bclientMachinecode"-->
							<!--autocomplete="off"></textarea>-->
							<!--</div>-->
							<!--</div>-->
							<!--<div class="form-group">-->
							<!--<label class="col-sm-3 control-label">B级授权序列号：-->
							<!--<span class="require">*</span>-->
							<!--</label>-->
							<!--<div class="col-sm-8">-->
							<!--<textarea rows="2" class="form-control" name="bauthSerilizenumber"-->
							<!--autocomplete="off"></textarea>-->
							<!--</div>-->
							<!--</div>-->
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="submitAdd">保存</button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="generateCode_dialog" tabindex="-1"
			role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">生成授权码</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group" data-step="1">
								<label class="col-sm-3 control-label">A级客户： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="aclient"
										autocomplete="off">
								</div>
							</div>
							<div class="form-group" data-step="1">
								<label class="col-sm-3 control-label">软件产品： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<select class="form-control" name="product">
									</select>
								</div>
							</div>
							<div class="form-group" data-step="1">
								<label class="col-sm-3 control-label">规格型号： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<select class="form-control" name="type">
									</select>
								</div>
							</div>
							<div class="form-group" data-step="1">
								<label class="col-sm-3 control-label">授权日期： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="date"
										autocomplete="off">
								</div>
							</div>
							<div class="form-group" data-step="1">
								<label class="col-sm-3 control-label">授权期限： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<select class="form-control" name="authTimeout" value="测试授权">
										<option value="测试授权(有效期30天)">测试授权(有效期30天)</option>
										<option value="永久授权">永久授权</option>
									</select>
								</div>
							</div>
							<div class="form-group" data-step="1">
								<label class="col-sm-3 control-label">并发数： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="superveneNumber"
										autocomplete="off">
								</div>
							</div>
							<div class="form-group" data-step="2">
								<label class="col-sm-3 control-label">产品序列号： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="serinumber"
										autocomplete="off">
								</div>
							</div>
							<div class="form-group" data-step="2">
								<label class="col-sm-3 control-label">产品授权码： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control"
										name="authorizationcode" autocomplete="off">
								</div>
							</div>
							<div class="form-group" data-step="2">
								<label class="col-sm-3 control-label">产品服务号： <span
									class="require">*</span>
								</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="servernumber"
										autocomplete="off">
								</div>
							</div>
							<!--<div class="form-group" data-step="3">-->
							<!--<label class="col-sm-3 control-label">B级客户机器码：-->
							<!--<span class="require">*</span>-->
							<!--</label>-->
							<!--<div class="col-sm-8">-->
							<!--<textarea rows="2" class="form-control" name="bclientMachinecode"-->
							<!--autocomplete="off"></textarea>-->
							<!--</div>-->
							<!--</div>-->
							<!--<div class="form-group" data-step="3">-->
							<!--<label class="col-sm-3 control-label">B级授权序列号：-->
							<!--<span class="require">*</span>-->
							<!--</label>-->
							<!--<div class="col-sm-8">-->
							<!--<textarea rows="2" class="form-control" name="bAuthSerilizenumber"-->
							<!--autocomplete="off"></textarea>-->
							<!--</div>-->
							<!--</div>-->
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="generate"
							data-step="1">生成</button>
						<button type="button" class="btn btn-primary" id="submitGenerate"
							data-step="2">保存</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="./assets/js/jquery-1.12.4.min.js"></script>
	<script src="./assets/js/bootstrap.min.js"></script>
	<script src="./assets/js/app.js"></script>
	<script src="./assets/js/bootstrap-datetimepicker.min.js"></script>
	<script src="./assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script>
		$(document).ready(function() {
			$('#exportData').attr('action', App.ajaxUrl + '/auth/export')
			$('.form-control[name="date"]').datetimepicker({
				language : 'zh-CN',
				format : 'yyyy-mm-dd',
				minView : 'month'
			}).on('changeDate', function(ev) {
				$(this).trigger('blur')
			});
			// 列表条件对象
			var dataListOpts = {
				all : '',
				status : '',
				start : 0,
				pageSize : Math.floor(($(document).height() - 268) / 41)
			}
			// 添加授权对象
			var addForm = {
				aclient : '',
				product : '',
				type : '',
				serinumber : '',
				authorizationcode : '',
				servernumber : '',
				date : '',
				superveneNumber : '',
				//            bAuthSerilizenumber: '',
				//            bclientMachinecode: '',
				status : 0
			}
			// 生成授权对象
			var generateForm = {}
			// 获取列表
			function getdataList(opts) {
				$.post(App.ajaxUrl + '/auth/list', opts, function(res) {
					if (res.code === '200') {
						var _html = [];
						if (opts.start >= res.data.count && res.data.count !== 0) {
							opts.start -= opts.pageSize
							getdataList(opts)
						}
						$.each(res.data.dataList, function(k, v) {
							_html.push('<tr id="' + v.id + '">')
							_html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.aclient || '-') + '">' + (v.aclient || '-') + '</td>')
							_html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.product || '-') + '">' + (v.product || '-') + '</td>')
							_html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.type || '-') + '">' + (v.type || '-') + '</td>')
							_html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.serinumber || '-') + '">' + (v.serinumber || '-') + '</td>')
							_html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.authorizationcode || '-') + '">' + (v.authorizationcode || '-') + '</td>')
							_html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.servernumber || '-') + '">' + (v.servernumber || '-') + '</td>')
							_html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.superveneNumber || '-') + '">' + (v.superveneNumber || '-') + '</td>')
							_html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.authTimeout || '-') + '">' + (v.authTimeout || '-') + '</td>')
							//                        _html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.bclientMachinecode || '-') + '">' + (v.bclientMachinecode || '-') + '</td>')
							//                        _html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.bAuthSerilizenumber || '-') + '">' + (v.bAuthSerilizenumber || '-') + '</td>')
							_html.push('<td data-toggle="tooltip" data-placement="bottom" title="' + (v.status === 0 ? '授权中' : '授权完成') + '">' + (v.status === 0 ? '授权中' : '授权完成') + '</td>')
							_html.push('<td><a class="glyphicon glyphicon-eye-open detail" title="查看" data-toggle="modal" data-target="#addform_dialog"></a><a class="glyphicon glyphicon-edit generate" style="display:' + (v.status === 1 ? 'none' : 'inline-block') + ';" title="生成序列号" data-toggle="modal" data-target="#generateCode_dialog"></a><a class="glyphicon glyphicon-pencil edit" style="display:' + (v.status === 0 ? 'none' : 'inline-block') + ';" title="编辑" data-toggle="modal"data-target="#addform_dialog"></a><a class="glyphicon glyphicon-trash delete"title="删除"></a></td>')
							_html.push('</tr>')
						})
						if (res.data.dataList.length === 0) {
							_html.push('<tr><td colspan="10" align="center">暂无数据</td></tr>')
						}
						$('#list tbody').html(_html.join(''))
						var page = Math.ceil(res.data.count / dataListOpts.pageSize),
							_pages = [ '<li class="' + (opts.start === 0 ? 'disabled' : '') + '"><a class="prev" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>' ]
						var start = Math.ceil(opts.start / opts.pageSize) - 3 < 1 ? 1 : (Math.ceil(opts.start / opts.pageSize) - 2)
						var end = Math.ceil(opts.start / opts.pageSize) + 4 > page ? page : Math.ceil(opts.start / opts.pageSize) + 4
						if (Math.ceil(opts.start / opts.pageSize) < 4) {
							end += 3 - Math.ceil(opts.start / opts.pageSize)
						} else if (Math.ceil(opts.start / opts.pageSize) >= page - 3) {
							start = page - 6
						}
						for (var i = (start < 1 ? 1 : start); i <= (end > page ? page : end); i++) {
							_pages.push('<li class="' + ((i - 1) * opts.pageSize === opts.start ? 'active' : '') + '"><a class="page">' + i + '</a></li>')
						}
						_pages.push('<li class="' + (opts.start + opts.pageSize >= res.data.count ? 'disabled' : '') + '"><a class="next" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>')
						$('#page').html(_pages.join(''))
					} else {
						App.alert(res.msg)
					}
				})
			}
	
			function getSelect() {
				$.get(App.ajaxUrl + '/auth/productversionlist', function(res) {
					if (res.code === '200') {
						var _product = [],
							_type = [];
						$.each(res.data.products, function(k, v) {
							_product.push('<option value="' + v + '">' + v + '</option>')
						})
						$.each(res.data.types, function(k, v) {
							_type.push('<option value="' + v + '">' + v + '</option>')
						})
						$('.form-control[name="product"]').html(_product.join(''))
						$('.form-control[name="type"]').html(_type.join(''))
					} else {
						App.alert(res.msg)
					}
				})
			}
	
			function validateForm(formName, form, callback) {
				var flag = true
				$('#' + formName).find('.form-control-error').removeClass('form-control-error');
				$('#' + formName).find('.has-error').remove();
				$('#' + formName).find('.form-control:visible').each(function(v) {
					var k = $(this).attr('name')
					if ($('#' + formName).find('.form-control[name="' + k + '"]').val() === '') {
						flag = false
						$('#' + formName).find('.form-control[name="' + k + '"]').addClass('form-control-error').parent().append('<span class="has-error">请输入' + $('#' + formName).find('.form-control[name="' + k + '"]').parent().prev().text().replace('：', '').replace('*', '') + '</span>')
						$('#' + formName).find('.has-error').show();
					}
					if ((k === 'servernumber' || k === 'superveneNumber') && !new RegExp("^[0-9]*$").test($('#' + formName).find('.form-control[name="' + k + '"]').val())) {
						flag = false
						$('#' + formName).find('.form-control[name="' + k + '"]').addClass('form-control-error').parent().append('<span class="has-error">' + $('#' + formName).find('.form-control[name="' + k + '"]').parent().prev().text().replace('：', '').replace('*', '') + '必须为数字</span>')
						$('#' + formName).find('.has-error').show();
					}
					if (k === 'date' && $('#' + formName).find('.form-control[name="' + k + '"]').val() !== '' && !new RegExp("^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)&").test($('#' + formName).find('.form-control[name="' + k + '"]').val())) {
						flag = false
						$('#' + formName).find('.form-control[name="' + k + '"]').addClass('form-control-error').parent().append('<span class="has-error">' + $('#' + formName).find('.form-control[name="' + k + '"]').parent().prev().text().replace('：', '').replace('*', '') + '必须为日期格式 例如：1990-01-01</span>')
						$('#' + formName).find('.has-error').show();
					}
					form[k] = $('#' + formName).find('.form-control[name="' + k + '"]').val();
				})
				if (flag) {
					callback && callback()
				}
			}
	
			function validateLi(e) {
				e.removeClass('form-control-error').siblings('.has-error').remove()
				if (e.val() === '') {
					e.addClass('form-control-error').parent().append('<span class="has-error">请输入' + e.parent().prev().text().replace('：', '').replace('*', '') + '</span>');
					e.closest('.form-horizontal').find('.has-error').show();
				}
				if ((e.attr('name') === 'servernumber' || e.attr('name') === 'superveneNumber') && !new RegExp("^[0-9]*$").test(e.val())) {
					e.addClass('form-control-error').parent().append('<span class="has-error">' + e.parent().prev().text().replace('：', '').replace('*', '') + '必须为数字</span>');
					e.closest('.form-horizontal').find('.has-error').show();
				}
				if (e.attr('name') === 'date' && e.val() !== '' && !new RegExp("^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)&").test(e.val())) {
					e.addClass('form-control-error').parent().append('<span class="has-error">' + e.parent().prev().text().replace('：', '').replace('*', '') + '必须为日期格式 例如：1990-01-01</span>')
					e.closest('.form-horizontal').find('.has-error').show();
				}
			}
	
			getSelect()
			getdataList(dataListOpts)
			// 搜索框input事件
			$("#search_all").on('input', function() {
				dataListOpts.all = $(this).val()
				getdataList(dataListOpts)
			})
			// select change事件
			$('#search_status').change(function() {
				dataListOpts.status = $(this).val()
				getdataList(dataListOpts)
			})
			// 换页事件
			$('#page').on('click', 'a', function() {
				if ($(this).hasClass('page')) {
					dataListOpts.start = (parseInt($(this).html()) - 1) * dataListOpts.pageSize
					getdataList(dataListOpts)
				} else if ($(this).hasClass('prev')) {
					$('#page li.active').prev().find('a.page').trigger('click')
				} else if ($(this).hasClass('next')) {
					$('#page li.active').next().find('a.page').trigger('click')
				}
			})
			// 模态框show事件
			$('#addform_dialog').on('shown.bs.modal', function(e) {
				$('#addform_dialog .modal-dialog').css({
					'marginTop' : ($(document).height() - $('#addform_dialog .modal-dialog')[0].scrollHeight) / 2 + 'px'
				})
			})
			$('#addform_dialog,#generateCode_dialog').on('show.bs.modal', function(e) {
				if (e.date) {
					return
				}
				var self = this
				$(self).find('.modal-body').css({
					'maxHeight' : $(document).height() * 0.9 - 121 + 'px',
					'overflow' : 'auto'
				})
				$(self).find('.modal-title').html($(e.relatedTarget).attr('title'))
				// 获取当前授权信息详情
				if (!$(e.relatedTarget).hasClass('add')) {
					$(self).attr('did', $(e.relatedTarget).parents('tr').attr('id'))
					$.get(App.ajaxUrl + '/auth/editbefore?id=' + $(e.relatedTarget).parents('tr').attr('id'), function(res) {
						if (res.code === '200') {
							$.each(res.data, function(k, v) {
								$(self).find('.form-control[name="' + k + '"]') && $(self).find('.form-control[name="' + k + '"]').val(v).attr('readOnly', $(e.relatedTarget).hasClass('detail'))
							})
							$(self).find('.form-control[name="date"]').val(App.formatterTime(res.data.date))
							$(self).find('.modal-footer').toggle(!$(e.relatedTarget).hasClass('detail'))
							if ($(e.relatedTarget).hasClass('generate')) {
								$(self).find('.form-group,.btn').show()
								$(self).find('[data-step="2"]').find('.form-control').attr('readOnly', true)
								$(self).find('.form-group:last-child').hide()
								$(self).find('#submitGenerate').hide()
							}
						} else {
							App.alert(res.msg)
						}
					})
				} else {
					if ($(self).attr('id') === 'generateCode_dialog' && $(e.relatedTarget).hasClass('add')) {
						$(self).find('.form-group,.btn').show()
						$(self).find('[data-step="2"],[data-step="3"]').hide()
						$(self).find('[data-step="1"]').show()
					}
					$(self).attr('did', '')
					$(self).find('.form-control').attr('readOnly', false)
					$(self).find('.modal-footer').show()
				}
			})
			// 模态框hidden事件
			$('.modal').on('hidden.bs.modal', function(e) {
				$(this).find('.form-control-error').removeClass('form-control-error');
				$(this).find('.has-error').remove();
				$.each(addForm, function(k, v) {
					$('[name="' + k + '"]').val('').prop('disabled', false)
				})
				$.each(generateForm, function(k, v) {
					$('[name="' + k + '"]').val('').prop('disabled', false)
				})
				$('[name="product"]').val($('[name="product"] option:first-child').attr('value'))
				$('[name="type"]').val($('[name="type"] option:first-child').attr('value'))
			})
			// 点击提交按钮事件
			$('#submitAdd').click(function() {
				validateForm('addform_dialog', addForm, function() {
					addForm.id = $('#addform_dialog').attr('did')
					addForm.status = 1
					$.post(App.ajaxUrl + '/auth/' + ($('#addform_dialog').attr('did') !== '' ? 'update' : 'add'), addForm, function(res) {
						if (res.code === '200') {
							App.alert(($('#addform_dialog').attr('did') !== '' ? '编辑' : '新建') + '授权成功', 'success')
							$('#addform_dialog').modal('hide')
							getdataList(dataListOpts)
						} else {
							App.alert(res.msg)
						}
					})
				})
			})
			// 生成按钮
			$('#generate').click(function() {
				validateForm('generateCode_dialog', generateForm, function() {
					$.post(App.ajaxUrl + '/auth/' + ($('#generateCode_dialog').attr('did') !== '' ? 'generateBclientSeriaNumber' : 'generateCode'), generateForm, function(res) {
						if (res.code === '200') {
							if ($('#generateCode_dialog').attr('did') !== '') {
								$('#generateCode_dialog').find('[name="bauthSerilizenumber"]').val(res.data).attr('readOnly', true).closest('.form-group').show()
								$('#generateCode_dialog').find('#submitGenerate').show()
								$('#generateCode_dialog').find('#generate').hide()
								return
							}
							$.each(res.data, function(k, v) {
								$('#generateCode_dialog').find('.form-control[name="' + k + '"]').val(v).attr('readOnly', true)
							})
							$('#generateCode_dialog').find('[data-step="1"],[data-step="2"]').show()
							$('#generateCode_dialog').find('[data-step="3"],#generate').hide()
						} else {
							App.alert(res.msg)
						}
					})
				})
			})
			$('#submitGenerate').click(function() {
				validateForm('generateCode_dialog', generateForm, function() {
					//                generateForm.status = ($('#generateCode_dialog').attr('did') !== '' ? 1 : 0)
					generateForm.status = 1
					generateForm.id = $('#generateCode_dialog').attr('did')
					$.post(App.ajaxUrl + '/auth/' + ($('#generateCode_dialog').attr('did') !== '' ? 'update' : 'add'), generateForm, function(res) {
						if (res.code === '200') {
							App.alert(($('#generateCode_dialog').attr('did') !== '' ? '保存' : '生成') + '授权成功', 'success')
							$('#generateCode_dialog').modal('hide')
							getdataList(dataListOpts)
						} else {
							App.alert(res.msg)
						}
					})
				})
			})
			$(".modal-dialog .form-control").blur(function() {
				validateLi($(this))
			})
			// 注销按钮点击事件
			$("#logout").click(function() {
				App.confirm('退出登录', '确定退出登录？', function() {
					$.get(App.ajaxUrl + '/logout', function(res) {
						if (res.code === '200') {
							window.location.href = './login'
						} else {
							App.alert(res.msg)
						}
					})
				})
			})
	
			// 点击删除事件
			$('#list').on('click', '.delete', function() {
				var id = $(this).parents('tr').attr('id')
				App.confirm('删除授权', '确定删除该授权？', function() {
					$.ajax({
						type : 'DELETE',
						url : App.ajaxUrl + '/auth/delete?id=' + id,
						success : function(res) {
							if (res.code === '200') {
								getdataList(dataListOpts)
								App.alert('删除授权成功', 'success')
							} else {
								App.alert(res.msg)
							}
						}
					})
				})
			})
		})
	</script>

</body>
</html>