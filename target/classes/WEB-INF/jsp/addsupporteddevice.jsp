<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Device</title>

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

</head>
<body>

<div style="margin-top: 15px"></div>
        <!-- MODAL STICK UP  -->
        <div id="addNewAppModal" tabindex="-1">
            <div class="modal-content">
            <form:form action="saveEntityAction.do" method="POST" commandName="device">
            <form:hidden path="id" id="id"/>
              <div class="modal-header clearfix ">
                <h4 class="p-b-5"><span class="semi-bold">${action}</span> Device Deatils</h4>
              </div>
              <div class="modal-body">
               <!--  <p class="small-text">Add a new app using this form, make sure you fill them all</p> -->
                  <div class="row">
                    <div class="col-sm-12">
                      <div class="form-group form-group-default required">
                        <label>Device Name</label>
                        <form:input path="deviceName"  id="deviceName" type="text" class="form-control" placeholder="Name of your device"/>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-12">
                      <div class="form-group form-group-default required">
                        <label>Device Type</label>
                        <form:input path="deviceType" id="deviceType" type="text" class="form-control" placeholder="Type of your device"/>
                      </div>
                    </div>
                  </div>
                   <div class="row">
                    <div class="col-sm-12">
                      <div class="form-group form-group-default required">
                        <label>Device Adapter</label>
                        <form:input path="deviceAdapter" id="deviceAdapter" type="text" class="form-control" placeholder="Adapter of your device"/>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-12">
                      <div class="form-group form-group-default required">
                        <label>Device Vendor</label>
                        <form:input path="deviceVendor" id="deviceVendor" type="text" class="form-control" placeholder="Vendor of your device"/>
                      </div>
                    </div>
                  </div>
                  <!--  <div class="row">
                    <div class="col-sm-6">
                      <div class="form-group form-group-default">
                        <label>Price</label>
                        <input id="appPrice" type="text" class="form-control" placeholder="your price">
                      </div>
                    </div>
                    <div class="col-sm-6">
                      <div class="form-group form-group-default">
                        <label>Notes</label>
                        <input id="appNotes" type="text" class="form-control" placeholder="a note">
                      </div>
                    </div>
                  </div>-->
              </div>
              <div class="modal-footer" id="makeAction">
                <input type="submit" name="action"  type="button" class="btn btn-primary  btn-cons" value="${action}" id="action">
                <a href="listEntityAction.do"><button type="button" class="btn btn-cons" lass="close">Cancel</button></a>
              </div>
              </form:form>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        <!-- END MODAL STICK UP  -->
     
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