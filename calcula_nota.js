
const info_notas =  {
    notas: [],

    setNotas(valores) {
        this.notas = valores
    },


     media() {

        let soma = 0

        for (let i = 0; i < this.notas.length; i++) {
            soma += this.notas[i]
        }
        let media = soma / this.notas.length
        console.log('A média é: ' + media.toFixed(1))
    },

     maior_nota() {
    maior = Math.max(...this.notas)
        console.log('A maior nota é: ' + maior)
    },

     menor_nota() {
    menor = Math.min(...this.notas)
        console.log('A menor nota é: ' + menor)
    },

     aprovados() {

        const nota_minima = this.notas.filter(nota => nota >= 7)

        console.log('os alunos aprovados são os que tiraram: ' + nota_minima)
    },

     reprovados() {

        const nota_minima = this.notas.filter(nota => nota < 5)

        console.log('os alunos reprovados são os que tiraram: ' + nota_minima)
    },

     recuperacao() {

        const nota_minima = this.notas.filter(nota => nota >= 5 && nota < 7)

        console.log('os alunos que ficaram de recuperação são os que tiraram: ' + nota_minima)
    }
}

info_notas.setNotas([0,1,2,3,4,5,6,7,8,9,10])

info_notas.media();
info_notas.maior_nota();
info_notas.menor_nota();
info_notas.aprovados();
info_notas.reprovados();
info_notas.recuperacao();





    
 
    







