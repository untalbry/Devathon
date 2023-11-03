class Display{
    constructor(displayValorAnterior, displayValorActual){
        this.displayValorAnterior = displayValorAnterior;
        this.displayValorActual = displayValorActual;
        this.calculator = new Calculadora();
        this.operatorType = undefined;
        this.valorActual = '';
        this.valorAnterior = '';
        this.signos = { 
            sumar : '+',
            restar : '-',
            dividir : '/',
            multiplicar: 'X'
        }
    }
    delete(){
        this.valorActual = this.valorActual.toString().slice(0,-1);
        this.printValue();
    }
    deleteAll(){
        this.valorActual = '';
        this.valorAnterior = '';
        this.operatorType = undefined;
        this.printValue();
    }
    setOperator(type){
        this.operatorType !== 'igual' && this.calculate();
        this.operatorType = type;
        this.valorAnterior = this.valorActual || this.valorAnterior;
        this.valorActual = '';
        this.printValue();
    }
    setNumber(number){
        if(number === '.' && this.valorActual.includes('.')) return;
        this.valorActual = this.valorActual + number.toString();
        this.printValue();
    }
    printValue(){
        this.displayValorActual.textContent = this.valorActual;
        this.displayValorAnterior.textContent = `${this.valorAnterior} ${this.signos[this.operatorType ] || ''}`;
    }
    calculate(){
        const valorAnterior = parseFloat(this.valorAnterior);
        const valorActual = parseFloat(this.valorActual);

        if(isNaN(valorActual) || isNaN(valorAnterior)) return;
        this.valorActual = this.calculator[this.operatorType](valorAnterior, valorActual);
    }
}