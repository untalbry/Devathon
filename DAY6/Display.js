class Display{
    constructor(displayValorAnterior, displayValorActual){
        this.displayValorAnterior = displayValorAnterior;
        this.displayValorActual = displayValorActual;
        this.calculator = new Calculadora();
        this.valorActual = '';
        this.valorAnterior = '';
    }
    setNumber(number){
        if(number === '.' && this.valorActual.includes('.')) return;
        this.valorActual = this.valorActual + number.toString();
        this.printValue();
    }
    printValue(){
        this.displayValorActual.textContent = this.valorActual;
        this.displayValorAnterior.textContent = this.valorAnterior;
    }
}