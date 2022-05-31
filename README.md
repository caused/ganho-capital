# Começe aqui

## Requisitos para executar projeto

* JDK 11 instalado

## Como executar o projeto

Dentro da pasta compactada, entre no diretório target, e lá você irá encontrar o arquivo _ganho-capital.jar_. Abra o terminal e execute da seguinte forma:

```
java -jar ganho-capital.jar
```

A partir daqui o sistema já irá esperar a entrada da pessoa usuário para processamento das operações.

*_A cada nova tentativa, o comando acima deverá ser executado novamente, pois o processo morre assim que o resultado for retornado_*

## Importante

Caso a pasta target esteja vazia, acesse o diretório raiz do projeto na linha de comando, e execute a seguinte instrução:

```
./mvnw clean install
```

Este comando irá:

* Realizar o download das dependências utilizadas
* Executar e exibir os testes unitário dentro da aplicação
* Gerar o arquivo .jar para ser executado

### Código fonte

Dentro do projeto, os arquivos de código fonte estão localizados nos diretórios *src/main/java*, enquanto que os arquivos de testes estão localizados nos diretórios *src/test/java*, incluindo testes unitários e de integração

### Dados de entrada

Devido a forma como o terminal lida com entrada textual, é importante verificar que o texto esteja todo em uma única linha.

Exemplo de entrada mal-formatada:

```
[{"operation":"buy", "unit-cost":10.00, "quantity": 10000},
{"operation":"sell", "unit-cost":50.00, "quantity": 10000},
{"operation":"buy", "unit-cost":20.00, "quantity": 10000},
{"operation":"sell", "unit-cost":50.00, "quantity": 10000}]
```

Exemplo de entrada formatada: 

```
[{"operation":"buy", "unit-cost":10.00, "quantity": 10000}, {"operation":"sell", "unit-cost":50.00, "quantity": 10000}, {"operation":"buy", "unit-cost":20.00, "quantity": 10000}, {"operation":"sell", "unit-cost":50.00, "quantity": 10000}]
```
