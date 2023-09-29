document.addEventListener('DOMContentLoaded', function () {
    // Obtén referencias a los elementos
    const rangeInput = document.getElementById('rangeInput');
    const rangeValue = document.getElementById('rangeValue');

    // Función para manejar el evento de cambio en el input de tipo "range"
    function actualizarValorDeRango() {
        // Actualiza el valor en el elemento <span> con el valor seleccionado del rango
        rangeValue.textContent = rangeInput.value;
    }

    // Agrega el manejador de eventos para el cambio en el rango
    rangeInput.addEventListener('input', actualizarValorDeRango);
});
