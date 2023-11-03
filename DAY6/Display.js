class Display{
    constructor(displayValorAnterior, displayValorActual){
        this.displayValorAnterior = displayValorAnterior;
        this.displayValorActual = displayValorActual;
        this.calculator = new Calculadora();
        this.operatorTipe = undefined;
        this.valorActual = '';
        this.valorAnterior = '';
    }
    delete(){
        this.valorActual = this.valorActual.toString().slice(0,-1);
        this.printValue();
    }
    deleteAll(){
        this.valorActual = '';
        this.valorAnterior = '';
        this.operatorTipe = undefined;
        this.printValue();
    }
    setNumber(number){
        if(number === '.' && this.valorActual.includes('.')) return;
        this.valorActual = this.valorActual + number.toString();
        this.printValue();
    }
    setOperator(operator){

    }
    printValue(){
        this.displayValorActual.textContent = this.valorActual;
        this.displayValorAnterior.textContent = this.valorAnterior;
    }
}