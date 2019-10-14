<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Nelson Dick Kelechi">
    <meta name="email" content="ndick4@gmail.com">
    <meta property="og:title" content="Pixelfaerie Report"/>
    <meta property="og:description" content="Pixelfaerie report template"/>
    <meta property="og:url" content="https://www.pixelfaerie.com"/>

    <!--Icon-->
    <link rel="icon" href="https://www.pixelfaerie.com/content/themes/ai/dist/favicon/ms-icon-144x144.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>${Project} - PixelFaerie</title>

    <!--Feather light CSS -->
    <link href="https://cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.css" type="text/css"
          rel="stylesheet"/>

    <!--Overlay Scrollbar-->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/overlayscrollbars/1.9.1/css/OverlayScrollbars.min.css">

    <!--Font awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!--Montserrat Font-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,600,600i" rel="stylesheet">

    <link rel="stylesheet" href="https://spin.js.org/spin.css">
    <!--Custom CSS-->
    <style>
        body {
            font-family: 'Montserrat', sans-serif;
            color: black;
            background-color: #ffffff !important;
        }


        .bg-pf-yellow {
            background-color: #ffcc00 !important
        }

        .bg-pf-green {
            background-color: #8fd400 !important
        }

        .bg-pf-brown {
            background-color: rgb(81, 48, 20) !important
        }

        .bg-pf-grey {
            background-color: #c7c7c7 !important
        }

        .text-pf-yellow {
            color: #ffcc00 !important
        }

        .text-pf-green {
            color: #8fd400 !important
        }

        .text-pf-brown {
            color: rgb(81, 48, 20) !important
        }

        .text-pf-grey {
            color: #c7c7c7 !important
        }

        .fixed-top {
            height: 60px;
        }


        .back-to-top {
            cursor: pointer;
            position: fixed;
            bottom: 20px;
            right: 20px;
            display: none;
        }


        #navigation .nav-pills .nav-link {
            background: transparent no-repeat;
            -webkit-filter: none;
            filter: none;
            text-shadow: none;
            color: #000;
        }

        .nav-pills .nav-link.active, .nav-pills .nav-link:hover {
            background: #8fd400 !important;
            border: none;
            color: #ffffff !important;
        }


        /*extra-info section*/
        #extra-info #extra {
            font-size: 10px;
        }

        #extra-info .font-weight-bold {
            font-size: 18px
        }

        .bg-white {
            background-color: whitesmoke !important;
        }

        .text-white {
            color: whitesmoke !important;
        }

        .btn.btn-fab, .input-group-btn .btn.btn-fab {
            position: fixed;
            bottom: 50px;
            right: 30px;
            border-radius: 50%;
            font-size: 24px;
            min-width: 50px;
            width: 50px;
            height: 50px;
            margin: auto;
            overflow: hidden;
            -webkit-box-shadow: 0 1px 1.5px 0 rgba(0, 0, 0, .12), 0 1px 1px 0 rgba(0, 0, 0, .24);
            box-shadow: 0 1px 1.5px 0 rgba(0, 0, 0, .12), 0 1px 1px 0 rgba(0, 0, 0, .24);
        }

        /**
        General
         */
        .modal-backdrop {
            z-index: -1;
        }

        #project {
            font-size: 20px;
        }

        .test-execution {
            font-size: 13px;
            alignment: right;
        }

        .card-pf {
            font-size: 30px;
        }

        .test-name {
            font-size: 24px;
        }

        input:focus {
            outline: none;
            border-color: #aaa;
        }

        .results .list-group-item {
            background-color: #2d2e32;
        }

        .results .nav-pills .nav-link {
            border-radius: 0;
            border-color: transparent;
        }

        .list-group-item {
            background-color: #ebebeb;
        }

        .list-group-item-action {
            color: rgb(81, 48, 20);
        }

        .list-group .list-group-item:hover {
            background-color: #8fd400;
            color: white;
            border-color: #8fd400;
        }

        .list-group-item.active {
            background-color: #8fd400;
            color: white;
            border-color: #8fd400;
        }

        .nav-pills .nav-link {
            border-radius: unset;
        }

        #pills-dashboard .card-group {
            background-color: #ffffff;
        }

        #pills-dashboard .card {
            background-color: #ebebeb;
        }

        #navigation {
            background-color: #ffcc00;
        }

        /*report detail*/
        #report-detail div.timestamp {
            font-size: 12px;
        }

        #report-detail .testDetail {
            font-weight: 600;
        }

        /**
         Test lists css
         */
        .avatar {
            vertical-align: middle;
            width: 40px;
            height: 40px;
            border-radius: 50%;
            border: 2px solid whitesmoke;
        }


        span.status {
            font-size: 9px;
            color: white;
        }

        .status {
            position: relative;
            float: left;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            font-weight: bold;
            color: inherit;
            font-size: 9px;
        }

        <#list listColours as key, value>
        .${key} {
            background-color: ${value};
            color: white;
        }

        </#list>

        .Total {
            background-color: grey;
            color: white;
        }


        .lightbox {
            display: none;
        }

        .lightbox label {
            padding: 5px;
        }

        .lightbox input {
            padding: 5px;
        }

        .featherlight .featherlight-content {
            background-color: white;
        }

        .sidenav {
            position: fixed;
            top: 60px;
            bottom: 0;
            left: 0;
            z-index: 980;
            padding: 20px;
            overflow-x: hidden;
            overflow-y: auto;
        }

        .list-group-item:first-child {
            border-radius: 0;
        }

        .list-group-item:last-child {
            border-radius: 0;
        }

        .nav-tabs .nav-link.active, .nav-tabs .nav-item.show .nav-link {
            border-left: transparent;
        }

        .nav-tabs .nav-link, .nav-tabs .nav-link {
            color: black;
        }


        .nav-item .active > a.nav-link > i {
            color: white;
        }

        .form-control-pf {
            display: block;
            width: 100%;
            height: calc(1.5em + 1.5rem + 2px);
            padding: 0.5rem .5rem;
            font-size: 0.9375rem;
            font-weight: bold;
            line-height: 1;
            color: rgb(81, 48, 20) !important;
            background-color: #ebebeb !important;
            background-clip: padding-box;
            border: transparent;
            -webkit-transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
        }

        .top-bottom {
            margin-top: 60px;
            margin-bottom: 60px
        }

        .zoom {
            border: 1px solid rgb(81, 48, 20);
        }

        @media (max-width: 756px) {
            .top-bottom {
                margin-bottom: 90px
            }

            .zoom {
                width: 13%;
                border: 1px solid rgb(81, 48, 20);
            }
        }

        @media (min-width: 75em) {
            .card-columns {
                -webkit-column-count: 1;
                -moz-column-count: 1;
                column-count: 2;
            }
        }

        .card .card-header:first-child {
            border-radius: unset !important;
        }

        .modal-content .modal-header {
            border-radius: unset !important;
        }
    </style>
</head>
<body class="scroll">
<!--Automation reporting-->
<div id="automation-report">
    <#--Navigation Bar-->
    <nav class="navbar navbar-expand-lg navbar-light bg-pf-yellow fixed-top">
        <a class="navbar-brand" href="#">
            <img src="https://www.pixelfaerie.com/content/themes/ai/dist/favicon/ms-icon-144x144.png" width="40"
                 alt="PixelFaerie">
        </a>

        <!--Project Name-->
        <span id="project" class="ml-lg-2 mb-0 font-weight-bolder text-pf-brown">${Project}</span>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
                aria-controls="navigation" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navigation">
            <ul class="nav nav-pills nav-fill ml-auto" id="pills-tab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link text-pf-brown active" id="pills-report-tab" data-toggle="pill"
                       href="#pills-report"
                       role="tab" aria-controls="pills-report" aria-selected="true"
                       onclick="$(function(){$('#navigation').removeClass('show')})">
                        <i class="fa fa-bar-chart" aria-hidden="true"></i> Report</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-pf-brown" id="pills-dashboard-tab" data-toggle="pill"
                       href="#pills-dashboard"
                       role="tab" aria-controls="pills-dashboard" aria-selected="false"
                       onclick="$(function(){$('#navigation').removeClass('show')})">
                        <i class="fa fa-tachometer"></i> Dashboard</a>
                </li>
                <li class="nav-item d-block d-sm-none">
                    <a data-toggle="modal" data-target="#mobile-test-list"
                       aria-controls="tests" aria-expanded="false" aria-label="Toggle tests" class="nav-link"
                       aria-selected="false" onclick="$(function(){$('#navigation').removeClass('show')})">
                        <i class="fa fa-th-list"></i> Tests list
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">
                        <small class="font-weight-bold text-pf-brown">${startTime?datetime.iso?string("EEEEE MMMM dd, yyyy")}</small>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid top-bottom">
        <div class="tab-content" id="pills-tabContent">
            <!--Report tab-->
            <div class="tab-pane fade show active" id="pills-report" role="tabpanel" aria-labelledby="pills-report-tab">
                <div class="row">
                    <#if tests?has_content>
                        <!--test list-->
                        <div id="tests" class="col-md-3 d-none d-md-block p-0 scroll sidenav full-height">
                            <div class="card">
                                <div class="card-header bg-pf-brown text-white font-weight-bold">
                                    Test Lists
                                </div>
                                <div class="card-body p-0">
                                    <div class="list-group" id="list-tab" role="tablist">
                                        <#list tests as key, testValue>
                                            <a class="list-group-item list-group-item-action <#if testValue?index == 0>active </#if>"
                                               id="${key}"
                                               data-toggle="list"
                                               href="#list-${key}" role="tab" aria-controls="${key}">
                                                <div class="avatar float-left ${testValue.testStatus}">
                                                    <span class="status">${testValue.testStatus}</span>
                                                </div>
                                                <div class="content ml-5">
                                                    <small class="float-right">${testValue.starTime?datetime.iso?string("HH:mm:ss")}</small>
                                                    <span class="font-weight-bold name">${testValue.testName}</span>
                                                    <br>
                                                    <small>${testValue.testExecutionTime}</small>
                                                </div>
                                            </a>
                                        </#list>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--test details-->
                        <div id="test-detail" class="col-md-9 col-sm-12 pt-2 offset-md-3">
                            <div class="tab-content" id="nav-tabContent">
                                <#list tests as key, testValue>
                                    <div class="tab-pane fade show <#if testValue?index == 0>active </#if>"
                                         id="list-${key}" role="tabpanel"
                                         aria-labelledby="list-${key}">
                                        <!-- Test Header-->
                                        <div class="row">
                                            <div class="col-12">
                                                <div class="row">
                                                    <div class=" col-8 col-md-9 font-weight-bolder text-pf-brown mb-0">
                                                        <!--Test Name-->
                                                        <div class="test-name font-weight-bold">${testValue.testName}</div>
                                                        <!--Test Description-->
                                                        <small class="font-weight-bold">${testValue.testDescription}</small>
                                                    </div>
                                                    <!--Test Execution Time-->
                                                    <small class="col-4 col-md-3 test-execution text-right">${testValue.testExecutionTime}</small>
                                                </div>

                                                <#if testValue.tags?has_content || user?? || testValue.category?? >
                                                    <!--Extra info-->
                                                    <div id="extra-info" class="my-2">
                                                        <div id="extra" class="font-italic">Hover over to the view
                                                            description.
                                                        </div>

                                                        <#if testValue.category?? >
                                                            <!--Category-->
                                                            <span class="category-list">
                                                         <small class="badge badge-danger p-2" data-toggle="tooltip"
                                                                data-placement="top"
                                                                title="${testValue.category}">
                                                           <i class="fa fa-list"
                                                              aria-hidden="true"></i> ${testValue.category}
                                                         </small>
                                                    </span>
                                                        </#if>

                                                        <#if user?? >
                                                            <!--Author-->
                                                            <span class="author-list">
                                                     <small class="badge badge-dark p-2" data-toggle="tooltip"
                                                            data-placement="top"
                                                            title="${user}"><i
                                                                 class="fa fa-user"
                                                                 aria-hidden="true"></i> ${user}</small>
                                                    </span>
                                                        </#if>

                                                        <#if testValue.tags?has_content>
                                                            <!--Tags-->
                                                            <span class="tag-list">
                                                                <#list testValue.tags as tag>
                                                                    <#if tag??>
                                                                        <small class="badge badge-info p-2"
                                                                               data-toggle="tooltip"
                                                                               data-placement="top"
                                                                               title="<#if tag??>${tag}</#if>">
                                                                          <i class="fa fa-tag"
                                                                             aria-hidden="true"></i> #${tag}
                                                                        </small>
                                                                    </#if>
                                                                </#list>
                                                            </span>
                                                        </#if>
                                                    </div>
                                                </#if>

                                                <#if testValue.testStats?has_content >
                                                    <!--test status summary-->
                                                    <div id="test-summary">
                                                        <h6 class="font-weight-bold text-pf-brown">Test Status
                                                            Summary</h6>
                                                        <div class="card-group mb-3">
                                                            <#list testValue.testStats as keyStats, valueStats>
                                                                <#if valueStats != 0>
                                                                    <div class="card ${keyStats}">
                                                                        <div class="card-body text-center p-1">
                                                                            <div>${keyStats}</div>
                                                                            <div class="font-weight-bold">${valueStats}</div>
                                                                        </div>
                                                                    </div>
                                                                </#if>
                                                            </#list>
                                                        </div>
                                                    </div>
                                                </#if>
                                            </div>
                                        </div>

                                        <!--Report details-->
                                        <div class="row">
                                            <div class="col-12">

                                                <!--Report Detail-->
                                                <div id="report-detail">
                                                    <!--Search Result bar-->
                                                    <input type="text" class="form-control-pf mb-3 fuzzy-search"
                                                           title="Filter results"
                                                           placeholder="Filter results"/>

                                                    <#if testValue.stepResults?has_content >

                                                        <!--List of Step Results-->
                                                        <ul class="list-group list">
                                                            <#list testValue.stepResults as result>
                                                                <li class="list-group-item">
                                                                    <div class="avatar float-left ${result.status}">
                                                                        <span class="status">${result.status}</span>
                                                                    </div>
                                                                    <div class="content ml-5">

                                                                        <#if result.exception??>
                                                                            <a class="text-warning float-right extra-warning"
                                                                               data-toggle="collapse" title="Click to expand"
                                                                               href="#collapse-${testValue.stepResults?seq_index_of(result)}"
                                                                               role="button" aria-expanded="false"
                                                                               aria-controls="collapse-${testValue.stepResults?seq_index_of(result)}">
                                                                                <i class="fa fa-2x fa-exclamation-triangle"></i>
                                                                            </a>
                                                                        <#elseif result.screenshot??>
                                                                            <a href="${result.screenshot}"
                                                                               data-featherlight="image">
                                                                                <img src="${result.screenshot}" data-toggle="tooltip"
                                                                                     data-placement="bottom"
                                                                                     title="Click to view screenshot"
                                                                                     alt="${result.message}'s image"
                                                                                     class="float-right zoom" style="width: 6%;"/>
                                                                            </a>
                                                                        </#if>
                                                                        <span class="testDetail m-0">${result.message}</span>
                                                                        <div class="timestamp">${result.timestamp?datetime.iso?string("HH:mm:ss")}</div>
                                                                        <#if result.exception??>
                                                                            <div class="collapse"
                                                                                 id="collapse-${testValue.stepResults?seq_index_of(result)}">
                                                                                <div class="card card-body">
                                                                                    <div class="media">
                                                                                        <div class="media-body">
                                                                                            <div class="mt-0 mb-1 text-danger font-weight-bold">
                                                                                                Error Message
                                                                                            </div>
                                                                                            <pre class="text-danger font-weight-bold text-wrap"><code
                                                                                                        class="">${result.exception}</code></pre>
                                                                                        </div>
                                                                                        <#if result.screenshot??>
                                                                                            <a href="${result.screenshot}"
                                                                                               data-featherlight="image"
                                                                                               class="ml-3">
                                                                                                <img src="${result.screenshot}" data-toggle="tooltip"
                                                                                                     data-placement="bottom"
                                                                                                     title="Click to view screenshot"
                                                                                                     alt="${result.message}'s image"
                                                                                                     class="float-sm-right zoom"
                                                                                                     style="width: 90px"/>
                                                                                            </a>
                                                                                        </#if>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </#if>
                                                                    </div>
                                                                </li>
                                                            </#list>
                                                        </ul>
                                                    </#if>
                                                    <div class="no-result"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </#list>
                            </div>
                        </div>
                    </#if>
                </div>
            </div>
            <!--Dashboard tab-->
            <div class="tab-pane fade " id="pills-dashboard" role="tabpanel" aria-labelledby="pills-dashboard-tab">
                <div class="row">
                    <div class="col-12 my-3">
                        <!--Overall test statistic-->
                        <div class="card-group">
                            <#list dashboard.summary as key, summaryValue>
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title text-center text-pf-green font-weight-bolder">${key}</h4>
                                        <h5 class="text-center mb-1">${summaryValue}</h5>
                                    </div>
                                </div>
                            </#list>
                        </div>
                    </div>
                </div>
                <div class="row mb-3 mt-1">
                    <!--Graphical stats-->
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title text-pf-green font-weight-bolder">Tests Statistics</h4>
                                <canvas id="test-doughnut" height="40" width="120"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title text-pf-green font-weight-bolder">Environments</h4>
                                <table class="table table-sm display m-0 w-100">
                                    <tbody>
                                    <#list environments as key, value>
                                        <#if value??>
                                            <tr>
                                                <td class="my-0">${key}</td>
                                                <td class="my-0 font-weight-bold"> ${value} </td>
                                            </tr>
                                        </#if>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!--Footer-->
        <footer class="footer mt-auto py-2 px-3 bg-white fixed-bottom text-right">
            <small class="text-muted font-weight-bold">© 2019 PixelFaerie - Quality Automation Assurance report.</small>
        </footer>
    </div>
</div>


<!--Mobile test list floating button-->
<a data-toggle="modal" data-target="#mobile-test-list" data-placement="top" title="Test Lists"
   aria-controls="tests" aria-expanded="false" aria-label="Toggle tests"
   class="btn btn-fab bg-pf-brown text-pf-green d-md-none d-block"
   aria-selected="false" onclick="$(function(){$('#navigation').removeClass('show')})">
    <i class="fa fa-th-list"></i>
</a>
<!-- Test Mobile List modal-->
<div class="modal fade" id="mobile-test-list" tabindex="-1" role="dialog" aria-labelledby="mobile-test-listTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header text-white bg-pf-brown">
                <h5 class="modal-title" id="mobile-test-listTitle">Tests</h5>
                <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body p-0">
                <div id="mobileTest" class="list-group list" role="tablist">
                    <#list tests as key, testValue>
                        <a class="list-group-item list-group-item-action <#if testValue?index == 0>active </#if>"
                           id="${key}"
                           onclick="mobileTestDisplay(this.id);" data-toggle="list"
                           href="#list-${key}" role="tab" aria-controls="${key}">
                            <div class="avatar float-left ${testValue.testStatus}">
                                <span class="status">${testValue.testStatus}</span>
                            </div>
                            <div class="content ml-5">
                                <small class="float-right">${testValue.starTime?datetime.iso?string("HH:mm:ss")}</small>
                                <span class="font-weight-bold name">${testValue.testName}</span>
                                <br>
                                <small>${testValue.testExecutionTime}</small>
                            </div>
                        </a>
                    </#list>
                </div>
            </div>
        </div>
    </div>
</div>

<!--Jquery CDN-->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<!--Popper CDN-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>

<!--Bootstrap Js-->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<!--Feature Light-->
<script src="http://cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.js" type="text/javascript"
        charset="utf-8"></script>

<!--Overlays Scrollbar-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/overlayscrollbars/1.9.1/js/jquery.overlayScrollbars.min.js"></script>
<!--Search-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/list.js/1.5.0/list.min.js"></script>

<!--Chart Plugin-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>

<!--Custom scripts-->
<script>
    function mobileTestDisplay(id) {
        // removing all active link
        $('#pills-tabContent').find('div').removeClass('active').removeClass('show');
        $('#pills-tab').find('a').removeClass('active');
        $('#list-tab').find('a').removeClass('active');

        // Update active link
        $('#pills-report-tab').addClass('active');
        $('#pills-report').addClass('show active');
        $('#list-' + id).addClass('show active');
        $('#mobile-test-list').modal('hide')
    }


    $(document).ready(function () {
        $(".scroll").overlayScrollbars({
            scrollbars: {
                visibility: "auto",
                autoHide: "scroll",
                autoHideDelay: 500,
                dragScrolling: true,
                clickScrolling: false,
                touchSupport: true,
                snapHandle: false
            },
        }).overlayScrollbars();

        // Activate tooltips
        $('[data-toggle="tooltip"]').tooltip();

        /*Search functionality*/
        new List('test-detail', {valueNames: ['testDetail', 'status']})
            .on('updated', function (list) {
                if (list.matchingItems.length > 0) {
                    $('#test-detail').find('.no-result').find("h4").remove();
                } else {
                    console.log(list.matchingItems.length);
                    $('#test-detail').find('.no-result').html('<h4 class="font-weight-bold text-center m-2">No Result(s) Found.</h4>');
                }
            });


        let options = {
            scales: {
                xAxes: [{
                    ticks: {
                        beginAtZero: true,
                        display: false,
                    },
                    gridLines: {
                        display: false,
                        drawBorder: false,
                    }
                }],
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                        display: false,
                    },
                    gridLines: {
                        display: false,
                        drawBorder: false,
                    },
                }]
            },
            legend: {
                display: true,
                position: 'left'
            }
        };
        let ctx = document.getElementById('test-doughnut').getContext('2d');
        new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: [<#if dashboard?has_content ><#list dashboard.testDonuts as key, value><#if value != 0>"${key}", </#if></#list></#if>],
                datasets: [{
                    data: [<#if dashboard?has_content ><#list dashboard.testDonuts as key, value><#if value != 0>"${value}", </#if></#list></#if>],
                    backgroundColor: [
                        <#if dashboard?has_content >
                        <#list dashboard.testDonuts as key, value>
                        <#list listColours as colourKey, valueColor>
                        <#if value != 0 && colourKey == key>'${valueColor}', </#if>
                        </#list>
                        </#list>
                        </#if>],
                    borderWidth: 2
                }]
            },
            options: options
        });

    });
</script>
</body>
</html>