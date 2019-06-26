#API Banco - Teste Infoway

##Sobre
Se trata de uma API que gerencia tudo a respeito de um banco financeiro, simulando as transações de um banco real, como cadastro, saque, listagem de contas, saldo e etc.

## Instalação

####Ambiente de Desenvolvimento
Você irá precisar possuir instalado a JDK 11.
#

####Clonando Repositório
Clone o Repositório do Git

```bash
git clone https://github.com/abdiassantos/api-bank-infoway.git
```
#

####Building

Execute a instalação dos pacotes necessários e pre configuração do proojeto criado através do [Starter Spring Initializr](https://start.spring.io)

```bash
./mvnw clean install
```

####Executando

Uma vez preparado o ambiente, podemos executá-lo usando o comando
 ```bash
 cd meu-projeto-spring
 ./mvnw spring-boot:run
 ```

####Servidor Executando
Após iniciado, o servidor deve apresentar uma saída semelhante a esta
![Output Console](https://i.imgur.com/76muVmP.png)

####Paths de Acesso
http://localhost:8080/api/bank - ` é o path raíz da aplicação, a partir dele podemos acessar outros paths `
#
/newBank - `é o path para adicionar um novo banco, adicionando ao body do postman um json com os dados do banco a ser inserido`
```json
{
    "bankName": "Banco do Abdias",
    "banckAddress": "Rua Mdo Banco do Abdias, 123",
    "bankCnpj": "11.222.333/4444-55",
    "bankPhone": "+5511233334444",
    "bankBornCity": "Teresina",
    "bankBornState": "Piauí"
}
```

/newAgency - `é o path para adicionar uma nova agência, adicionando ao body do postman um json com os dados da agência a ser inserida`
```json
{
    "agencyName": "Banco do Abdias",
    "agencyAddress": "Rua da Agencia do Banco do Abdias, 1234",
    "agencyCnpj": "55.444.333/2222-11",
    "agencyPhone": "+5511233334444",
    "agencyBornCity": "Teresina",
    "agencyBornState": "Piauí",
    "agencyBankId": "1"
}
```

/newAccount - `é o path para adicionar um novo banco, adicionando ao body do postman um json com os dados do banco a ser inserido`
```json
{
    "clientName": "Banco do Abdias",
    "clientAddress": "Rua do Abdias, 1235",
    "clientCpfCnpj": "111.222.333-44",
    "clientPhone": "+5511233334444",
    "clientBornCity": "Teresina",
    "clientBornState": "Piauí",
    "clientAgencyId": "1"
}
```