<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Mum Sched</title>

  <!-- Bootstrap Core CSS -->
  <link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/static/vendor/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet">

  <!-- MetisMenu CSS -->
  <link href="/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="/static/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>

<body>

<div id="wrapper">

  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">Mum Sched</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">

      <!-- /.dropdown -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
          <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
          <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
          </li>
          <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
          </li>
          <li class="divider"></li>
          <li><a href="/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
          </li>
        </ul>
        <!-- /.dropdown-user -->
      </li>
      <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->
      <%@ include file="../layout/left.jsp" %>
      <!-- /.navbar-static-side -->
  </nav>

  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-11">
        <h1 class="page-header">Schedule</h1>
      </div>

      <!-- /.col-lg-12 -->
    </div>
    <div class="row">
      <div class="col-lg-11">
        <div class="btn-group pull-right1" style="margin: 5px">
          <select id="entryList" class="form-control">

          </select>
        </div>
        <div class="btn-group pull-right1" style="margin: 5px">
            <button id="view" class="btn btn-success">View Schedule</button>
        </div>

      </div>

    </div>
    <!-- /.row -->
      <div class="row">
          <input type="hidden" value="" id="entryGen">
          <div class="col-lg-12">
              <div class="panel panel-default">
                  <div class="panel-heading">
                      <i class="fa fa-bar-chart-o fa-fw"></i> Section List
                  </div>

                  <!-- /.panel-heading -->
                  <div class="panel-body">
                      <table id="list2" class="table table-bordered table-responsive table-striped">
                          <thead>
                          <td>Name</td>
                          <td>Block</td>
                          <td>Course Code</td>
                          <td>Course name</td>
                          <td>Capacity</td>
                          <td>Faculty</td>
                          </thead>
                          <tbody>
                          <tr>

                          </tr>
                          </tbody>
                      </table>
                  </div>
                  <!-- /.panel-body -->
              </div>

              <!-- /.panel -->
          </div>
          <!-- /.col-lg-8 -->
          <!-- /.col-lg-4 -->
      </div>

      <!-- /.row -->
  </div>
  <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->



<!-- jQuery -->
<script src="/static/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/static/vendor/bootstrap/js/bootstrap.min.js"></script>


<script src="/static/vendor/bootstrap-select/js/bootstrap-select.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/static/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="/static/vendor/raphael/raphael.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/static/js/sb-admin-2.js"></script>

</body>
<script>
  $(document).ready(function () {

      $('#view').on('click', function () {
          generate();
      });
      $.ajax({
          url:'/entry/list',
          success: function (s) {
              console.log(s);
              for(var key in s){
                  if(s.hasOwnProperty(key)){
                      $('#entryList').append($('<option>').val(s[key].id).text(s[key].uname));
                  }
              }
          },
          error: function (e) {
              console.log(e);
          }
      });



      getEntries();
      $('#createTeacher').on('click', function () {
      $('#createModal').modal('show');
          getEntries();
    });

    $('#update').on('click', function() {
      if($('.check:checked').length!=1){
        alert('Please select one teacher');
      }else{
          getEntries();
          fillIn();
        $('#createModal').modal('show');
      }
    });
    $('#delete').on('click', function() {
      if($('.check:checked').length!=1){
        alert('Please select one teacher');
      }else{
        var id=$('.check:checked').val();
        $.ajax({
          url:'/block/'+id,
          type:'delete',
          success: function (s) {
            console.log(s);
            loadBlocks();
          },
          error: function (e) {
            console.log(e);
            loadBlocks();
          }
        })
      }
    });

    $('#save').on('click', function () {
      var da=$('#createc').serialize();
      console.log(da);
      $.ajax({
        url:'/block/create',
        type:'post',
        data:da,
        success: function (s) {
          console.log(s);
          loadBlocks();
          $('#createModal').modal('hide');
        },
        error: function (e) {
          console.log(e);
          loadBlocks();
          $('#createModal').modal('hide');
        }
      })
    })
  });

  function fillIn(){

    var id=$('.check:checked').val();

    $.ajax({
      url:'/block/'+id,
      success: function (s) {
        console.log(s);
        $('#fullName').val(s.uname);
          if(s.entry!=null)
        $('#entry').val(s.entry.id);
        $('#startDate').val(s.startDate);
        $('#endDate').val(s.endDate);
        $('#blockId').val(s.id);
      },
      error: function (e) {
        console.log(e);
      }
    })
  }

  function getEntries(){
      $.ajax({
          url:'/entry/list',
          success: function (s) {
              console.log(s);
              $('#entry').html('');
              for(var  key in s){
                  if(s.hasOwnProperty(key)){
                      $('#entry').append($('<option>').val(s[key].id).text(s[key].uname));
                  }
              }
          },
          error: function (e) {
              console.log(e);
          }
      })
  }

  function generate(){
      var id=$('#entryList').val();
      $('#entryGen').val(id);
      $.ajax({
          url:'/schedule/get/'+id,

          success: function (s) {
              console.log(s);
              fillinSched(s);

          },
          error: function (e) {
              console.log(e);
          }
      })
  }

  function fillinSched(s){
      var table = $('#list2 tbody');
      table.html('');
      for(var  key in s){
          if(s.hasOwnProperty(key)){
              var tr=$('<tr>');
              tr.append($('<td>').text(s[key].uname));
              tr.append($('<td>').text(s[key].block.uname));
              tr.append($('<td>').text(s[key].course.code));
              tr.append($('<td>').text(s[key].course.uname));
              tr.append($('<td>').text(25));
              if(s[key].teacher!=null)
                  tr.append($('<td>').text(s[key].teacher.full_name));
              else
                  tr.append($('<td>').text('No Staff'));
              table.append(tr);
          }
      }
  }

</script>
</html>
