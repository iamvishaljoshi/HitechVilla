<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>Supported Device Page</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/resources/pages/ico/60.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/resources/pages/ico/76.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="${pageContext.request.contextPath}/resources/pages/ico/120.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="${pageContext.request.contextPath}/resources/pages/ico/152.png">
<link rel="icon" type="image/x-icon" href="favicon.ico" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<meta content="" name="description" />
<meta content="" name="author" />
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/pace/pace-theme-flash.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/boostrapv3/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/font-awesome/css/font-awesome.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/jquery-scrollbar/jquery.scrollbar.css"
	rel="stylesheet" type="text/css" media="screen" />
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/bootstrap-select2/select2.css"
	rel="stylesheet" type="text/css" media="screen" />
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/switchery/css/switchery.min.css"
	rel="stylesheet" type="text/css" media="screen" />
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/jquery-datatable/media/css/jquery.dataTables.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/jquery-datatable/extensions/FixedColumns/css/dataTables.fixedColumns.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/assets/plugins/datatables-responsive/css/datatables.responsive.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/resources/pages/css/pages-icons.css"	rel="stylesheet" type="text/css">
<link class="main-stylesheet"
	href="${pageContext.request.contextPath}/resources/pages/css/pages.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 9]>
        <link href="pages/css/ie9.css" rel="stylesheet" type="text/css" />
    <![endif]-->
<script type="text/javascript">
    window.onload = function()
    {
      // fix for windows 8
      if (navigator.appVersion.indexOf("Windows NT 6.2") != -1)
        document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/pages/css/windows.chrome.fix.css" />'
    }
    </script>

<script type="text/javascript">

function nextPage(currentPage){
	document.getElementById("currentPageNo").value = currentPage+1;
	
	if(document.getElementById("endIndexPerPage").value == document.getElementById("totalNoOfRecord").value){
		document.getElementById("nextButton").disabled = true;
	}
}

function previousPage(currentPage){
	if(document.getElementById("currentPageNo").value == 1){
		document.getElementById("previousButton").disabled = true;
	}
	document.getElementById("currentPageNo").value = currentPage - 1;
	
}

function showData(deviceId, view, edit){
	document.getElementById("deviceId").value = deviceId;
}
</script>
</head>
<body class="fixed-header">
	<input type="hidden" name="recordPerPage" value="${page.recordPerPage}"
		id="recordPerPage" />
	<div style="margin-top: 10px"></div>
	
	<!-- START CONTAINER FLUID -->
	<ul>
	<sec:authorize access="hasRole('Admin')">
	<div class="panel-heading">
					<div class="col-xs-12">
					<form:form action="addEntityAction.do" method="POST"
				commandName="device">
						<button class="btn btn-primary btn-cons pull-right">
							<i class="fa fa-plus"></i> Add Device
						</button>
						</form:form>
					</div>
	</div>
	</sec:authorize>
	</ul>
	<div class="container-fluid container-fixed-lg">
		<!-- START PANEL -->
		<div class="panel panel-transparent">
			<div class="panel-heading">
				<div class="panel-title">Supported Devices List</div>
			</div>
			<form:form action="deviceSearch.do" method="POST"
				commandName="search">
				<div id="example_filter" class="pull-right">
				<input type="text" id="search-table" class="form-control pull-right" placeholder="Search">
					<!-- <input type="search" name="search" class=""
						placeholder="Search" aria-controls="example"><input
						type="submit" name="action" value="Go" /> -->
				</div>
			</form:form>
			<input type="hidden" name="record" id="deviceId"/>
			<div class="panel-body">
				<table
					class="table table-hover demo-table-dynamic table table-hover demo-table-search"
					id="tableWithSearch" role="grid">
					<thead>
					<tr>
							<td>
								<div class="pull-right">
	                  				<div class="col-xs-12">
	                    				<input type="text" id="search-table-column-name" class="form-control pull-right" placeholder="Search for name">
	                  				</div>
	                			</div>
                			</td>
                			<td rowspan="1" colspan="1">
								<div class="pull-right">
	                  				<div class="col-xs-12">
	                    				<input type="text" id="search-table-column-type" class="form-control pull-right" placeholder="Search for type">
	                  				</div>
	                			</div>
                			</td>
                			<td rowspan="1" colspan="1">
								<div class="pull-right">
	                  				<div class="col-xs-12">
	                    				<input type="text" id="search-table-coulmn-adapter" class="form-control pull-right" placeholder="Search for adapter">
	                  				</div>
	                			</div>
                			</td>
                			<td rowspan="1" colspan="1">
								<div class="pull-right">
	                  				<div class="col-xs-12">
	                    				<input type="text" id="search-table-column-vendor" class="form-control pull-right" placeholder="Search for vendor">
	                  				</div>
	                			</div>
                			</td>
                			<td rowspan="1" colspan="1">
								
                			</td>
							


						</tr>
						<tr role="row">
							<th class="sorting_asc" tabindex="0"
								aria-controls="tableWithDynamicRows" rowspan="1" colspan="1"
								aria-label="App name: activate to sort column ascending"
								style="width: 259px;" aria-sort="ascending">Device Name</th>
							<th class="sorting" tabindex="0"
								aria-controls="tableWithDynamicRows" rowspan="1" colspan="1"
								aria-label="Description: activate to sort column ascending"
								style="width: 317px;">Type</th>
							<th class="sorting" tabindex="0"
								aria-controls="tableWithDynamicRows" rowspan="1" colspan="1"
								aria-label="Price: activate to sort column ascending"
								style="width: 199px;">Adapter</th>
							<th class="sorting" tabindex="0"
								aria-controls="tableWithDynamicRows" rowspan="1" colspan="1"
								aria-label="Notes: activate to sort column ascending"
								style="width: 258px;">Vendor</th>
							<th class="sorting" tabindex="0"
								aria-controls="tableWithDynamicRows" rowspan="1" colspan="1"
								aria-label="Notes: activate to sort column ascending"
								style="width: 258px;">Action</th>


						</tr>
						
					</thead>
					<tbody>
						<c:forEach items="${deviceList}" var="device">
							<tr>
								<td class="v-align-middle">
									<p>${device.deviceName}</p>
								</td>
								<td class="v-align-middle">
									<p>${device.deviceType}</p>
								</td>
								<td class="v-align-middle">
									<p>${device.deviceAdapter}</p>
								</td>
								<td class="v-align-middle">
									<p>${device.deviceVendor}</p>
								</td>
								<td class="v-align-middle">
						<a href="${pageContext.request.contextPath}/supportedDevices/viewEntityAction.do?deviceId=${device.id}">View</a>/<a href="${pageContext.request.contextPath}/supportedDevices/editEntityAction.do?deviceId=${device.id}">Edit</a>/<a href="${pageContext.request.contextPath}/supportedDevices/viewEntityAction.do?deviceId=${device.id}">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<!-- <tfoot>
					<tr>

							<td>Showing <b>${page.startIndexPerPage} to
									${page.endIndexPerPage}</b> of ${page.totalNoOfRecord} entries
							</td>
							<td></td>
							<td></td>
							<td><form:form action="devicePaging.do" method="POST"
									commandName="page">
									<span class="pull-right"> <input type="submit" id="previousButton"
										name="action" value="Previous"
										onclick="javascript:previousPage(${page.currentPageNo});">
										<a href="#">Page ${page.currentPageNo}</a> <input
										type="submit" name="action" value="Next" id="nextButton"
										onclick="javascript:nextPage(${page.currentPageNo});"></span>
									<form:hidden id="currentPageNo" value="${page.currentPageNo}" path="currentPageNo" />
									<form:hidden id="totalNoOfRecord" path="totalNoOfRecord" value="${page.totalNoOfRecord}" />
									<form:hidden id="recordPerPage" path="recordPerPage"
										value="${page.recordPerPage}" />
										<form:hidden id="endIndexPerPage" path="endIndexPerPage"
										value="${page.endIndexPerPage}" />
										
								</form:form></td>
								<td></td>
						</tr>
					
					</tfoot> -->
				</table>
			</div>
		</div>
		<!-- END PANEL -->
	</div>
	


     
     
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/pace/pace.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/modernizr.custom.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery/jquery-easy.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-bez/jquery.bez.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-ios-list/jquery.ioslist.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-actual/jquery.actual.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/plugins/bootstrap-select2/select2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/plugins/classie/classie.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/switchery/js/switchery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-datatable/media/js/jquery.dataTables.columnFilter.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-datatable/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-datatable/extensions/TableTools/js/dataTables.tableTools.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-datatable/extensions/Bootstrap/jquery-datatable-bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/plugins/datatables-responsive/js/datatables.responsive.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/plugins/datatables-responsive/js/lodash.min.js"></script>
    <!-- END VENDOR JS -->
    <!-- BEGIN CORE TEMPLATE JS -->
    <script src="${pageContext.request.contextPath}/resources/pages/js/pages.min.js"></script>
    <!-- END CORE TEMPLATE JS -->
    <!-- BEGIN PAGE LEVEL JS -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/datatables.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/scripts.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS -->
  </body>
</html>