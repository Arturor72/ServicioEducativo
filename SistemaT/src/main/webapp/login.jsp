<%-- 
    Document   : login
    Created on : 14/09/2014, 03:09:41 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="bg-black">
    <head>
        <meta charset="UTF-8">
        <%@include file="WEB-INF/jspf/title.jspf" %>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="WEB-INF/jspf/links.jspf" %>
    </head>
    <body class="bg-black">
        <div>
            <div class="col-md-4">
                <div class="col-md-6"> 
                </div>
                <div class="col-md-6">  
                </div>
            </div>
            <div class="col-md-4">
            </div>
            <div class="col-md-4" style="clear: both">
            </div>
            <div class="col-md-4">
                <div class="form-box" id="login-box">
                    <div class="header"> 

                        <img src="img/logo3.png" class="img-responsive" style="margin-left:auto;margin-right:auto">
                        SISED
                    </div>
                    <form action="UsuarioServlet" method="post">
                        <input type="hidden" name="operation" value="login"/>
                        <div class="body bg-gray">
                            <div class="form-group">
                                <input type="text" name="user" class="form-control" placeholder="Usuario"/>
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control" placeholder="Password"/>
                            </div>          
                        </div>
                        <div class="footer">
                            <button type="submit" class="btn bg-light-blue btn-block">Ingresar</button>  
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>        

    </body>
</html>