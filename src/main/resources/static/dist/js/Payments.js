$(document).ready(function () {
    $("#btnTest").click(function () {
        var edad = $("#txtEdad").val();
        var tableFilter = "";
        console.log(edad);
        if (edad == "") {
            swal("¡Atención!", "No has ingresado una edad", "warning");
            return;
        }

        fetch(`http://localhost:8080/workers/age/${edad}/`).then(response =>
            response.json().then(data => ({
                    data: data,
                    status: response.status
                })
            ).then(res => {
                if (res.data == "") {
                    swal("¡Atención!", "No existen empleados con la edad ingresada", "info");
                    return;
                }

                $.each(res.data, function (i, item) {
                    console.log(item.nombre);
                    tableFilter += "<tr>";
                    tableFilter += "<td>" + item.nombre + "</td>";
                    tableFilter += "<td>" + item.apellidos + "</td>";
                    tableFilter += "<td>" + item.edad + "</td>";
                    tableFilter += "<td><a href='/workers/update/" + item.id + "' class='btn btn-info'>Editar</a><a href='/workers/" + item.id + "' class='btn btn-danger'>Eliminar</a></td>";
                    tableFilter += "</tr>";
                });
                $("#tWorkers").html(tableFilter);
                swal("¡Éxito!", "Datos cargados", "success");
            }));
    });

    $("#btnBuscarPagos").click(function () {
        var concepto = $("#txtConcepto").val();
        var tableFilter = "";

        if (concepto == "") {
            swal("¡Atención!", "No has ingresado un monto", "warning");
            return;
        }

        fetch(`http://localhost:8080/workers/payments/${concepto}/`).then(response =>
            response.json().then(data => ({
                    data: data,
                    status: response.status
                })
            ).then(res => {
                if (res.data == "") {
                    swal("¡Atención!", "No existen pagos mayor al monto ingresado", "info");
                    return;
                }

                tableFilter += "<table class='table table-bordered'>";
                tableFilter += "<thead class='thead-dark'>";
                tableFilter += "<tr>";
                tableFilter += "<th scope='col'>Concepto</th>";
                tableFilter += "<th scope='col'>ID Empleado</th>";
                tableFilter += "<th scope='col'>Fecha</th>";
                tableFilter += "</tr>";
                tableFilter += "</thead>";
                tableFilter += "<tbody>";
                $.each(res.data, function (i, item) {
                    tableFilter += "<tr>";
                    tableFilter += "<td>" + item.concepto + "</td>";
                    tableFilter += "<td>" + item.idEmpleado + "</td>";
                    tableFilter += "<td>" + item.fecha + "</td>";
                    tableFilter += "</tr>";
                });
                tableFilter += "</tbody>";
                tableFilter += "</table>";
                
                $("#divPagos").html(tableFilter);
                swal("¡Éxito!", "Datos cargados", "success");
            }));
    });
    
    $("#language").change(function (){
       var selectedOption = $("#language").val();
       if(selectedOption != ''){
           window.location.replace('?lang=' + selectedOption);
       }
    });
});