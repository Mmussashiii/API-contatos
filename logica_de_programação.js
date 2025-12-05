function Calc_imposto (valor_prod){

    if (valor_prod > 3000){
        imposto = 0.18
        let valor_comimposto = valor_prod * imposto
        console.log('o valor do seu produto excedeu R$: 3.000,00 e sofreu taxação de 18% de imposto sobre o produto, o total taxado é de R$:  '+ (valor_comimposto) + ' ou seja você irá pagar R$: ' + (valor_comimposto + valor_prod));

    }else if (valor_prod > 2000){
        imposto = 0.15
        let valor_comimposto = valor_prod * imposto
        console.log('o valor do seu produto excedeu R$: 2.000,00 e sofreu taxação de 15% de imposto sobre o produto, o total taxado é de R$: '+ (valor_comimposto) + ' ou seja você irá pagar R$: ' + (valor_comimposto + valor_prod));

    }else if (valor_prod > 1000){
        imposto = 0.12
        let valor_comimposto = valor_prod * imposto
        console.log('o valor do seu produto excedeu R$: 1.000,00 e sofreu taxação de 12% de imposto sobre o produto, o total taxado é de R$: ' + (valor_comimposto) + ' ou seja você irá pagar R$: ' + (valor_comimposto + valor_prod));

    }else{
        console.log('o valor do seu produto não excedeu R$: 1.000,00 ou seja, não sofrerá taxação de imposto! Seu valor é R$: ' + (valor_prod));

    }
}

Calc_imposto(1000)























