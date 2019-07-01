# API Banco - Teste Infoway

## Sobre
Se trata de uma API que gerencia tudo a respeito de um banco financeiro, simulando as transações de um banco real, como cadastro, saque, listagem de contas, saldo e etc.

## Instalação

#### Ambiente de Desenvolvimento
Você irá precisar possuir instalado a JDK 11.


#### Clonando Repositório
Clone o Repositório do Git

```bash
git clone https://github.com/abdiassantos/api-bank-infoway.git
```


#### Building

Execute a instalação dos pacotes necessários e pre configuração do proojeto criado através do [Starter Spring Initializr](https://start.spring.io)

```bash
./mvnw clean install
```

#### Executando

Uma vez preparado o ambiente, podemos executá-lo usando o comando
 ```bash
 cd meu-projeto-spring
 ./mvnw spring-boot:run
 ```

#### Servidor Executando
Após iniciado, o servidor deve apresentar uma saída semelhante a esta
![Output Console](https://i.imgur.com/76muVmP.png)

#### Paths de Acesso
http://localhost:8080/api/bank - ` é o path raíz da aplicação, a partir dele podemos acessar outros paths `

/newBank - `é o path para adicionar um novo banco, adicionando ao body do postman um json com os dados do banco a ser inserido`
```json
{
    "bankName": "Banco do Abdias",
    "bankAddress": "Rua Mdo Banco do Abdias, 123",
    "bankCnpj": "11.222.333/4444-55",
    "bankPhone": "+5511233334444",
    "bankBornCity": "Teresina",
    "bankBornState": "Piauí"
}
```
/newAgency - `é o path para adicionar um novo banco, adicionando ao body do postman um json com os dados do banco a ser inserido`
```json
{
    "agencyName": "Banco do Abdias",
    "agencyAddress": "Rua Mdo Banco do Abdias, 123",
    "agencyCnpj": "11.222.333/4444-55",
    "agencyPhone": "+5511233334444",
    "agencyBornCity": "Teresina",
    "agencyBornState": "Piauí",
    "agencyBankId": "1"
}
```
/newClient - `é o path para adicionar um novo banco, adicionando ao body do postman um json com os dados do banco a ser inserido`
```json
{
	"clientName": "Banco do Andressa",
	"clientAddress": "Rua do Parque Jurema ",
	"clientCnpj": "11.222.333/1111-11",
	"clientPhone": "86999677811",
	"clientBornCity": "Teresina",
	"clientBornState": "Piaui",
	"clientAgencyId": "1"
}
```
/newAccount - `é o path para adicionar um novo banco, adicionando ao body do postman um json com os dados do banco a ser inserido`
```json
{
	"accountAgencyId": "1",
	"accountBalance": 10,
	"accountClientId": "1",
	"accountOpenning": "2019-10-19",
	"deposit": 0,
	"withdraw": 0
}
```

/newAgency - `é o path para Listar todos o registro, trocando o último path por bank, agency, account, ou client para um dos tipos`
```bash
localhost:8080/api/client/bank
localhost:8080/api/client/agency
localhost:8080/api/client/client
localhost:8080/api/client/account
```

/newAccount - `é o path para listar pelo id do path escolhido, entre bank, agency, account, client`
```bash
localhost:8080/api/client/bank/1
localhost:8080/api/client/agency/1
localhost:8080/api/client/client/1
localhost:8080/api/client/account/1
```