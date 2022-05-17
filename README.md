# Projeto: SpringBoot + Mongo + Kafka + Feign + Docker
Projeto desenvolvido para demonstrar a utilização de aplicações com Spring Boot + Kafka + Feign + Mongo + Docker  

Neste projeto estou utilizando o Feign – um cliente HTTP declarativo desenvolvido pela Netflix, no qual visa simplificar os clientes de API HTTP. Simplificando, o desenvolvedor só precisa declarar e anotar uma interface enquanto a implementação real é provisionada no tempo de execução.

O Feign é utilizado para integrar a API desenvolvida com o VIACEP, um webservice gratuito e de alto desempenho para consultar Códigos de Endereçamento Postal (CEP) do Brasil.

O docker é utilizado para a criação de um contâiner Docker para o banco de dados MongoDB.

## Organização do Projeto
A organização do projeto é apresentada abaixo.

```
+-- consumer/      # Aplicação que irá consumir os tópicos e salvar no banco
+-- producer/       # Aplicação que irá produzir os tópicos 
+-- docker/        # Arquivos de inicialização dos serviços containerizados 
```

## Inicialização
1. Clone o projeto para sua máquina local:
    ```shell
    # Com SSH
    git clone git@github.com:davigomesflorencio/project_mongo_kafka_feign.git
    
    # Ou com HTTPS
    git clone https://github.com/davigomesflorencio/project_mongo_kafka_feign.git
    ```
2. Acesse a *branch* de master:
    ```shell
    $ git checkout master
    ```

### Serviços Docker
> **Obs.:** Para iniciar esses serviços é necessário ter o [Docker Engine](https://docs.docker.com/engine/install/) e o [Docker Compose](https://docs.docker.com/compose/install/) instalados.

Execute o comando abaixo para **iniciar** os contêineres:
```shell
sudo docker-compose -f ____docker-compose.yml up -d
```
Execute o comando abaixo para **encerrar** a execução dos contêineres:
```shell
sudo docker-compose -f ____docker-compose.yml down
```
> Utilize o sinalizador `-v` para remover os volumes de dados gerados

#### Executando os Microsserviços no Mesmo Espaço de Trabalho
1. Inicie o IntelliJ e clique em `Open` e abra o diretório raiz do projeto (*sgo-microservices*).
2. Em seguida, importe cada microsserviço como um módulo. Para isso, no menu superior, clique em `File > New > Module from Existing Sources...`
3. Em seguida, no pop-up que será aberto, selecione o arquivo `pom.xml`no diretório do microsserviço desejado e clique `Ok` para importar o módulo.
4. Repita o processo para todos os microsserviços e o *commons*.
> Para mais detalhes e um passo-a-passo com imagens, acesse [IntelliJ IDEA : Running multiple project (Microservices) in one workspace](https://medium.com/backend-habit/intellij-idea-running-multiple-project-microservices-in-one-workspace-d61126fe0eef).

## Desenvolvimento
### IDE
A IDE recomendada para o desenvolvimento dos microsserviços é o [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/), pois tem excelente integração com linguagens que rodam na Máquina virtual Java além de ser uma das referências de mercado de IDEs.

### Configuração
Seguindo as recomendações de [aplicativos de doze fatores](https://12factor.net/pt_br/), os microsserviços possuem suas configurações armazenadas em variáveis de ambiente, para facilitar a portabilidade entre ambientes de desenvolvimento, homologação e produção. Cada microsserviço/módulo possui ao menos um arquivo de configuração no diretório `src/main/resources`. 
