/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 $(function () {
     var operation='QRY';
     
        var parametros = {
        operation : operation
      };
     // alert(operation);
      $.ajax({
        data: parametros,
        
        url:   '/SistemaT/ServicioServlet',
        type:  'post',
        
        beforeSend: function () {
          //$("#resultado").html("Procesando, espere por favor...");
        },
        success:  function (response) {
          var Datos=JSON.parse(response);
          alert(response);
          //agregarFila(Datos);
        },
        error: function (result,f) {
          alert('ERROR ' + result.status + ' ' + result.statusText+' '+f);
        }
      });
    });
