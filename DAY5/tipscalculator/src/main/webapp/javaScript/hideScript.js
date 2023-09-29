document.addEventListener('DOMContentLoaded', function () {
    // Obtén una referencia al input oculto
    const inputOculto = document.getElementById('numPeople');

    // Función para manejar el evento de clic en los radio buttons
    function manejarClicRadioButton() {
        // Si el radio button "opcion1" está seleccionado, muestra el input. Si no, escóndelo.
        inputOculto.style.display = document.getElementById('opcion1').checked ? 'block' : 'none';
    }

    // Agrega el manejador de eventos a los radio buttons
    const radioButtons = document.querySelectorAll('input[name="opciones"]');
    radioButtons.forEach(radioButton => {
        radioButton.addEventListener('click', manejarClicRadioButton);
    });
});
