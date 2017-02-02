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
          <li><a href="/j_spring_security_logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
          </li>
        </ul>
        <!-- /.dropdown-user -->
      </li>
      <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
      <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
          <li>
            <a href="/"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
          </li>
          <li>
            <a href="/course/"><i class="fa fa-dashboard fa-fw"></i> Courses</a>
          </li>
            <li>
                <a href="/teacher/"><i class="fa fa-edit fa-fw"></i> Faculty</a>
            </li>
          <%--
          <li>
            <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
              <li>
                <a href="panels-wells.html">Panels and Wells</a>
              </li>
            </ul>
            <!-- /.nav-second-level -->
          </li>--%>
        </ul>
      </div>
      <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
  </nav>

  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-11">
        <h1 class="page-header">Faculty</h1>
      </div>

      <!-- /.col-lg-12 -->
    </div>
      <div class="row">
          <div class="col-lg-11">
              <div class="btn-group pull-right" style="margin: 5px">
                  <button id="createTeacher" class="btn btn-success">Create Faculty</button>
              </div>
              <div class="btn-group pull-right" style="margin: 5px">
                  <button id="update" class="btn btn-info">Update Faculty</button>
              </div>

          </div>

      </div>
    <!-- /.row -->
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            <i class="fa fa-bar-chart-o fa-fw"></i> Faculty List
          </div>
          <!-- /.panel-heading -->
          <div class="panel-body">
              <table id="list" class="table table-bordered table-responsive table-striped">
                <thead>Forms
                    <td>Check</td>
                    <td>Faculty Name</td>
                    <td>Description</td>
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


<div id="createModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel">New Teacher</h4>
            </div>
            <div class="modal-body">
                <form id="createc">
                    <div class="form-group">
                        <label for="fullName" class="control-label">Full Name:</label>
                        <input type="text" name="fullName" class="form-control" id="fullName">
                        <input type="hidden" name="id" class="form-control" id="teacherId">
                    </div>

                    <div class="form-group">
                        <label for="descrip" class="control-label">Description:</label>
                        <textarea class="form-control" name="descrip" id="descrip"></textarea>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button onclick="js:loadTeachers()" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button id="save" type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

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

        loadTeachers();

        $('#createTeacher').on('click', function () {
            $('#createModal').modal('show');
        });

        $('#update').on('click', function() {
            if($('.check:checked').length!=1){
                alert('Please select one teacher');
            }else{
                $('#createModal').modal('show');
                fillIn();
            }
        });

        $('#save').on('click', function () {
            var da=$('#createc').serialize();
            console.log(da);
            $.ajax({
                url:'/teacher/create',
                type:'post',
                data:da,
                success: function (s) {
                    console.log(s);
                    loadTeachers();
                    $('#createModal').modal('hide');
                },
                error: function (e) {
                    console.log(e);
                    loadTeachers();
                    $('#createModal').modal('hide');
                }
            })
        })
    });
    function fillIn(){
       var id=$('.check:checked').val();
        $.ajax({
            url:'/teacher/'+id,
            success: function (s) {
                console.log(s);
                $('#fullName').val(s.full_name);
                $('#descrip').val(s.descrip);
                $('#teacherId').val(s.id);
            },
            error: function (e) {
                console.log(e);
            }
        })
    }


    function loadTeachers(){
        var table = $('#list tbody');
        table.html('');
        $.ajax({
            url:'/teacher/list',
            success: function (s) {
                console.log(s);
                for(var  key in s){
                    if(s.hasOwnProperty(key)){
                        var tr=$('<tr>');
                        tr.append($('<td>').html($('<input class="check" type="checkbox">').val(s[key].id)));
                        tr.append($('<td>').text(s[key].full_name));
                        tr.append($('<td>').text(s[key].descrip));
                        var str='';
                        tr.append($('<td>').text(str));
                        table.append(tr);
                    }
                }
            },
            error: function (e) {
                console.log(e);
            }
        })
    }
</script>
</html>
