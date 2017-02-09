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
    <%@ include file="../layout/left.jsp" %>
  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-11">
        <h1 class="page-header">Courses</h1>
      </div>

      <!-- /.col-lg-12 -->
    </div>
      <div class="row">
          <div class="col-lg-11">
              <div class="btn-group pull-right" style="margin: 5px">
                  <button id="createCourse" class="btn btn-success">Create Course</button>
              </div>
              <div class="btn-group pull-right" style="margin: 5px">
                  <button id="update" class="btn btn-info">Update Course</button>
              </div>
              <div class="btn-group pull-right" style="margin: 5px">
                  <button id="delete" class="btn btn-danger">Delete Course</button>
              </div>
          </div>

      </div>
    <!-- /.row -->
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            <i class="fa fa-bar-chart-o fa-fw"></i> Course List
          </div>
          <!-- /.panel-heading -->
          <div class="panel-body">
              <table id="list" class="table table-bordered table-responsive table-striped">
                <thead>
                    <td>Check</td>
                    <td>Course Code</td>
                    <td>Course Name</td>
                    <td>Description</td>
                    <td>Prerequisite</td>
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


<div id="createModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="gridSystemModalLabel">New Course</h4>
            </div>
            <div class="modal-body">
                <form id="createc">
                    <div class="form-group">
                        <label for="courseCode" class="control-label">Course Code:</label>
                        <input type="text" name="code" class="form-control" id="courseCode">
                    </div>
                    <div class="form-group">
                        <label for="uname" class="control-label">Course Name:</label>
                        <input type="text" name="uname" class="form-control" id="uname">
                        <input type="hidden" name="id" class="form-control" id="courseId">
                    </div>
                    <div class="form-group">
                        <label for="pre" class="control-label">Prerequisite</label>
                        <select name="pre" class="form-control" id="pre">
                            <option value="" >No Prerequisite</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="teachers" class="control-label">Faculty</label>
                        <select name="teachers" multiple class="selectpicker form-control" id="teachers"></select>
                    </div>
                    <div class="form-group">
                        <label for="descrip" class="control-label">Description:</label>
                        <textarea class="form-control" name="descrip" id="descrip"></textarea>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button onclick="js:loadCourses()" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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

        loadCourses();
        loadTeachers();

        $('#createCourse').on('click', function () {
            $('#createModal').modal('show');
        });

        $('#update').on('click', function() {
            if($('.check:checked').length!=1){
                alert('Please select one course');
            }else{
                $('#createModal').modal('show');
                fillIn();
            }
        });
        $('#delete').on('click', function() {
            if($('.check:checked').length!=1){
                alert('Please select one teacher');
            }else{
                var id=$('.check:checked').val();
                $.ajax({
                    url:'/course/delete/'+id,
                    success: function (s) {
                        console.log(s);
                        loadCourses();
                    },
                    error: function (e) {
                        console.log(e);
                        loadCourses
                    }
                })
            }
        });

        $('#save').on('click', function () {
            var da=$('#createc').serialize();
            console.log(da);
            $.ajax({
                url:'/course/create',
                type:'post',
                data:da,
                success: function (s) {
                    console.log(s);
                    loadCourses();
                    $('#createModal').modal('hide');
                },
                error: function (e) {
                    console.log(e);
                    loadCourses();
                    $('#createModal').modal('hide');
                }
            })
        })
    });
    function fillIn(){
       var id=$('.check:checked').val();
        $.ajax({
            url:'/course/'+id,
            success: function (s) {
                console.log(s);
                $('#uname').val(s.uname);
                $('#courseCode').val(s.code);
                $('#descrip').val(s.descrip);
                $('#courseId').val(s.id);

                if(s.pre!=null)
                    $('#pre').val(s.pre.id);
                if(s.teachers.length>0){
                    //$('#teachers').html('');
                    var vals=[];
                    for(var key in s.teachers){
                        if(s.teachers.hasOwnProperty(key)){
                            var current = s.teachers[key];
                            vals.push(current.id);
                        }
                    }
                    $('#teachers').val(vals);
                    $('#teachers').selectpicker('refresh');
                }
            },
            error: function (e) {
                console.log(e);
            }
        })
    }
    function loadTeachers(){
        $.ajax({
            url:'/teacher/list',
            success: function (s) {
                console.log(s);
                for(var key in s){
                    if(s.hasOwnProperty(key)){
                        var item=$('<option>').val(s[key].id).text(s[key].full_name);
                        $('#teachers').append(item);
                    }
                }
                $('#teachers').selectpicker('refresh');
            },
            error: function (e) {
                console.log(e);
            }
        })
    }

    function loadCourses(){
        var table = $('#list tbody');
        table.html('');
        $.ajax({
            url:'/course/list',
            success: function (s) {
                console.log(s);
                for(var  key in s){
                    if(s.hasOwnProperty(key)){
                        var tr=$('<tr>');
                        tr.append($('<td>').html($('<input class="check" type="checkbox">').val(s[key].id)));
                        tr.append($('<td>').text(s[key].code));
                        tr.append($('<td>').text(s[key].uname));
                        tr.append($('<td>').text(s[key].descrip));
                        var str='';
                        if(s[key].pre!=null){
                            str=  s[key].pre.code;
                        }
                        tr.append($('<td>').text(str));
                        str='';
                        if(s[key].teachers!=null){
                            str = s[key].teachers.map(function(el){
                                return el.full_name;
                            }).join(", ");
                        }
                        tr.append($('<td>').text(str));

                        table.append(tr);
                        $('#pre').append($('<option>').val(s[key].id).text(s[key].uname));
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
