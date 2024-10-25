package Hotel

import kotlin.system.exitProcess
var usuario = String
 val senha = 2678
var nome_hotel = "hotel otsuki"
var teste = ("Digite sua senha: ")
var lista_de_quartos = mutableListOf(
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",
"livre",

)
val nome = readln()
fun main() {
    inicio()
}
fun inicio() {
    println("por favor Digite seu nome: ")
    val nome= readln()
    println("Digite sua senha: ")
    val senha = readln().toInt()
    if (senha!= 2678){
        println("Senha invalida, por favor tente novamente!")
        inicio()
    }
    else if (senha== 2678){
        print("Bem vindo ao Hotel Otsuki!\n"+"É um grande prazer receber você aqui!\n")
    }
    println("Escolha uma opção:\n " +
            "        1 -> cadastrarQuartos()\n" +
            "        2 -> cadastrarHospedes()\n" +
            "        3 -> AbastecimentoDeAutomoveis()\n" +
            "        4 -> sairDoHotel() ")

    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> cadastrarQuartos()
        2 -> cadastrarHospedes()
        3 -> AbastecimentoDeAutomoveis()
        4 -> eventos()
        5 -> sairDoHotel()
        else -> erro()
    }
}

fun cadastrarQuartos() {
    println("por favor digite o valor da diaria do quarto" )
    var valor_diaria = 55
    readln().toInt()
    println("Digite a quantidade de dias que ira ficar no nosso hotel")
    var dias_hotel = readln().toInt()
    var valor_hospedagem = valor_diaria * dias_hotel
    println("Qual o seu nome? \n")
    var nome_docliente = readln()

    var num = 1
for (i in lista_de_quartos){
    println(" quarto $num está: $i")
    num ++
}
    println("Escolha um quarto temos 20 opções dos melhores quartos")
    var escolha= readln().toInt()

    if (escolha in 1..20){
        if (lista_de_quartos[escolha-1]=="livre"){
            lista_de_quartos [escolha-1]= "ocupado"
            println("quarto confirmado com sucesso")
            println("$nome_docliente você confirma o valor da diaria de $valor_hospedagem " +
                    "no quarto $escolha para $dias_hotel dias s/n ?")
            var opcao = readln()
            if (opcao == "s"){
                println("hospedagem confirmado com sucesso , " +
                        "agora vamos cuidar de tudo para voê")
                inicio()
            }
            else if (opcao == "n"){
                println("agradecemos, tente novamente quando quiser " +
                        "estamos sempre a disposição")
                inicio()
            }
        }
    else if (escolha in 1 .. 20){
        if (lista_de_quartos [escolha-1]=="ocupado"){
            println("Quarto indisponivel")
            cadastrarQuartos()



        }}
    }

}


fun AbastecimentoDeAutomoveis() {


}

fun erro(){
    println("Por favor, informe um número entre 1 e 5.")
    inicio()
}

fun sairDoHotel() {
    println("Você deseja sair?")
    val confirma = readln().toBoolean()
    if (confirma) {
        println("Muito Obrigado, esperamos receber você novamente em breve, até mais!")
    } else {
        inicio()
    }
}
fun cadastrarHospedes() {
    val listaHospedes = mutableListOf(
        "Carlos Villagran", "Maria Antonieta de las Nieves", "Roberto Gómez Bolaños", "Florinda Meza", "Ramón Valdés", "Rubén Aguirre", "Angelines Fernández", "Edgar Vivar", "Horácio Gómez Bolaños", "Raúl Padilla"
    )

    while (true) {
        println("""Cadastro de Hóspedes
            Selecione uma opção:
            1. Cadastrar
            2. Pesquisar
            3. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarHospede(listaHospedes)
            2 -> pesquisarHospede(listaHospedes)
            3 -> sairCadastroDeHospedes()
            else -> erroCadastroDeHospedes()
        }
    }
}

fun cadastrarHospede(listaHospedes: MutableList<String>) {

    var totalHospedagem = 0
    var gratuidade = 0
    var meia = 0

    while (true) {
        println("Cadastro de Hóspedes.\nPor favor, informe o nome do Hóspede (ou digite PARE para encerrar):")
        val novoHospede = readln()

        if (novoHospede.equals("PARE", ignoreCase = true)) {

            println("$novoHospede, o valor total das hospedagens é: R$$totalHospedagem; $gratuidade gratuidade(s); $meia meia(s)")
            break
        }

        println("Qual o valor padrão da diária? ")
        val valorDiaria = readln().toIntOrNull() ?: 0

        println("Informe sua idade:")
        val idadeHospede = readln().toIntOrNull() ?: 0

        when {
            idadeHospede < 6 -> {
                println("$novoHospede cadastrado(a) com sucesso. $novoHospede possui gratuidade.")
                gratuidade++
            }
            idadeHospede > 60 -> {
                println("$novoHospede cadastrado(a) com sucesso. $novoHospede paga meia.")
                meia++
                totalHospedagem += valorDiaria / 2
            }
            else -> {
                println("$novoHospede cadastrado(a) com sucesso!")
                totalHospedagem += valorDiaria
            }
        }

        listaHospedes.add(novoHospede)
        println("Lista de Hóspedes atuais: $listaHospedes")
    }
}

fun pesquisarHospede(listaHospedes: MutableList<String>) {
    println("Pesquisa de Hóspedes.\nPor favor, informe o nome do Hóspede:")
    val nomeHospede = readln()

    if (listaHospedes.any { it.contains(nomeHospede, ignoreCase = true) }) {
        println("\nEncontramos a(s) hóspede(s):")
        listaHospedes.filter { it.contains(nomeHospede, ignoreCase = true) }
            .forEach { println(it) }
    } else {
        println("Não encontramos nenhuma hóspede com esse nome.")
    }
}

fun sairCadastroDeHospedes() {
    println("Você deseja sair? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        // uppercase fará o que for digitado ser convertido para maiúsculo por exemplpo x -> X
        "S" -> {
            println("obrigado pela preferencia ")
            exitProcess(0)
        }
        "N" -> {
            println("tudo bem, vamos retomar")
            cadastrarHospedes()
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeHospedes()
        }
    }
}

fun erroCadastroDeHospedes() {
    println("Por favor, informe um número entre 1 e 4 .")
}
var pessoas_eventos = 0
var dia_evento = ""
var hora_evento = 0
var empresa =""
var garçom = 0
var horario_eventos1 = 0
var custogarçom = 0.0
var contagem_garçom = 0
var custoTotal=0.0

fun eventos(){

    println("Quantas pessoas estarão no eventos")
    pessoas_eventos = readln().toInt()

    if (pessoas_eventos in 0..350){
        if (pessoas_eventos < 150){
            println("Use o auditório Laranja")
            horario_Eventos()
        }
        else if (pessoas_eventos <220 && pessoas_eventos > 150){
            println("Use o auditório Laranja (inclua mais ${pessoas_eventos - 150} cadeiras)")
            horario_Eventos()
        }
        else if (pessoas_eventos > 220){
            println("Use o auditório Colorado")
            horario_Eventos()
        }
    }
    else if (pessoas_eventos < 0){
        println("Valor invalido!")
        println("digite novamente:")
        eventos()
    }
    else{
        println("de convidados superior à capacidade máxima")
        eventos()
    }
}

fun horario_Eventos(){
    println("Agora vamos ver a agenda do evento")
    println("")
    println("")



    println(" Qual o dia do seu evento? ")
    dia_evento = readln().lowercase()
    if (dia_evento == "SABADO" || dia_evento == "DOMINGO") {
        print(" Qual a hora do seu evento? ")
        hora_evento = readln().toInt()
        if (hora_evento > 15 || hora_evento < 7) {
            println("Horario fora de funcionamento, Auditório indisponível\n")
            println(" Segunda a Sexta das 7hs às 23hs \n Sábados e Domingos apenas das 7hs às 15hs \n")
            horario_Eventos()
        }else {
            println(" Qual o nome da empresa? ")
            empresa = readln()
            println(" Auditório reservado para $empresa . $dia_evento às $hora_evento hs.\n \n")
        }
    } else {
        print(" Qual a hora do seu evento? ")
        hora_evento = readln().toInt()
        while (hora_evento> 23 || hora_evento < 7) {
            println("Horario fora de funcionamento, Auditório indisponível")
            println(" Segunda a Sexta das 7hs às 23hs \n Sábados e Domingos apenas das 7hs às 15hs \n")
            print(" Qual a hora do seu evento? ")
            hora_evento = readln().toInt()
        }

        println(" Qual o nome da empresa? ")
        empresa = readln().lowercase()
        println(" Auditório reservado para $empresa . $dia_evento às $hora_evento")

    }
    garçom()
}

fun garçom(){
    println("Qual a duração do evento em horas?")
    horario_eventos1 = readln().toInt()
    var calc = horario_eventos1 / 2
    contagem_garçom = pessoas_eventos/12
    garçom = contagem_garçom + calc
    custogarçom = garçom * horario_eventos1* 10.5
    println("são necessarios $garçom garçons")
    println("E o custo é $custogarçom ")
    println("Agora vamos calcular o custo do buffet do hotel para o evento." )
    buffet()

}
fun buffet(){
    var cafe_litros = pessoas_eventos * 0.2
    var agua_litros = pessoas_eventos * 0.5
    var contagem_salgado = pessoas_eventos * 7

    var custoCafe = cafe_litros * 0.8
    var custoAgua = agua_litros * 0.4
    var custoSalgados = contagem_salgado / 100.0 * 34

    custoTotal = custoCafe + custoAgua + custoSalgados

    println("O evento precisará de $cafe_litros litros de café, $agua_litros litros de água, $contagem_salgado salgados.")
    println("Custo total com comida do evento: R$ $custoTotal")
    confirm_eventos()
}
fun confirm_eventos(){

    println("\nEvento no Auditório tal.")
    println("Nome da Empresa: $empresa")
    println("Data: $dia_evento, $hora_evento hs.")
    println("Duração do evento: $horario_eventos1 horas.")
    println("Quantidade de garçons: $garçom")
    println("Quantidade de Convidados: $pessoas_eventos")
    println("Custo do garçom: $custogarçom")
    println("Custo do Buffet: R$custoTotal ")
    println("Valor total do evento: ${custogarçom + custoTotal} ")

    print("\nGostaria de efetuar a reserva? S/N: ")
    val resposta = readLine()?.lowercase() ?: ""
    if (resposta == "s") {
        println("Reserva efetuada com sucesso.")
    } else {
        println("Reserva não efetuada.")
    }
    inicio()
}
fun ar_condicionado (){
    fun manutencaoArCondicionado() {
        println("Qual o número do quarto para manutenção do ar condicionado?")
        val quartoManutencao = readln().toIntOrNull() ?: -1

        if (quartoManutencao < 1 || quartoManutencao > 20) {
            println("Número do quarto inválido.")
        } else {
            println("Manutenção do ar condicionado para o quarto $quartoManutencao agendada.")
        }
        inicio()
    }

    fun sairDoHotel() {
        println("Saindo do hotel. Até logo, $nome!")
    }

    fun erro() {
        println("Opção inválida. Tente novamente.")
        inicio()
    }
}
