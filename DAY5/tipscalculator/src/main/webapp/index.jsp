<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tips Calculator</title>
        <script src="javaScript/hideScript.js"></script>
        <script src="javaScript/rangeValue.js"></script>
        <link href="styles/indexStyles.css" rel="stylesheet" />
    </head>
    <body>
        <section class="background-container">
            <div class="card-container glass-efect">
                    <header>
                        <span class="logo">
                            <img src="img/card.png" alt="">
                            <h1>Calculadora de Propinas</h1>
                        </span>
                    </header>

                    <div class="formulario">
                        <form action="SvTicket" method="POST">
                            <div class="form-total">
                                <input class="form_input" type="number" name="total" placeholder="Ingresa el total de cuenta" required>
                            </div>
                            <div class="form-porcent">
                                <label>Porcentaje de propina: </label> <br>
                                <input type="range" name="porcentage" min="0" max="100" id="rangeInput" value="0">
                                <span id="rangeValue">0</span>%
                            </div>
                            
                            <p>Divides la cuenta?</p>
                            
                             <div class="form-option">
       
                                <input id="opcion1" type="radio" name="opciones" value="opcion1" >
                                <label for="opcion1">Si</label>

                                <input id="opcion2" type="radio" name="opciones" value="opcion2" checked="">
                                <label for="opcion2">No</label>

                             </div>   
                            
                            <div class="form-num-people" id="numPeople"   style="display: none;">
                                <input class="form_input" type="number" name="numPeople" step="0" placeholder="Número de personas" value="1">
                            </div>
                            
                            <button  class="button" type="submit">Enviar</button>
                        </form>
                    </div>

                </div>
        </section>
        
        
    </body>
</html>
