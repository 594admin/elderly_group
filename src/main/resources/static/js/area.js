$(function () {
    $("#sheng").change(function () {
        $("#shi").val(-1);
        $("#qv").val(-1);
        $("#jie").val(-1);
        var o = "<option value='-1'>请选择</option>";
        $("#shi").html("");
        $("#shi").append(o)
        $("#qv").html("");
        $("#qv").append(o)
        $("#jie").html("");
        $("#jie").append(o)

        var areaId = $(this).val();
        $.post("/getArea",{"areaId":areaId},function (data) {
            for (var i = 0; i< data.length; i++){
                var option = "<option value='"+data[i].areaId+"'>"+data[i].areaName+"</option>";
                $("#shi").append(option);
            }
        },"json");
    });

    $("#shi").change(function () {
        $("#qv").val(-1);
        $("#jie").val(-1);
        var areaId = $(this).val();

        var o = "<option value='-1'>请选择</option>";
        $("#qv").html("");
        $("#qv").append(o)
        $("#jie").html("");
        $("#jie").append(o)

        $.post("/getArea",{"areaId":areaId},function (data) {
            for (var i = 0; i< data.length; i++){
                var option = "<option value='"+data[i].areaId+"'>"+data[i].areaName+"</option>";
                $("#qv").append(option);
            }
        },"json");
    });

    $("#qv").change(function () {
        $("#jie").val(-1);
        var areaId = $(this).val();

        var o = "<option value='-1'>请选择</option>";
        $("#jie").html("");
        $("#jie").append(o)

        $.post("/getArea",{"areaId":areaId},function (data) {
            for (var i = 0; i< data.length; i++){
                var option = "<option value='"+data[i].areaId+"'>"+data[i].areaName+"</option>";
                $("#jie").append(option);
            }
        },"json");
    });
})