# Crawler.

O projeto consiste em crawlear um xml e transformar em um json.

## Tecnologias utilizadas.

- Java 8.
- Spring Boot, MVC e Actuator.
- Junit 4.
- Mockito.

## Para rodar o projeto, execute os passos que estão descritos abaixo.

- Importar o projeto na sua IDE como um projeto maven.
- Baixar todas as dependências que estão configuradas no pom.
- Executar o main da classe br.com.crawler.CrawlerApplication

## Endpoints disponíveis.

### Método GET: http://localhost:8080/feed

**Descrição:** Faz o parser do xml e retorna um json com o conteúdo.

Ex:

```
{
    "feed": [
        "item": {
            "title": "titulo da materia",
            "link": "url da materia",
            "description": [
                {
                    "type": "text",
                    "content': "conteudo da tag"
                },
                {
                    "type": "image",
                    "content": "url da imagem"
                },
                {
                    "type": "links",
                    "content": ["urls dos links"]
                }
            ]
        }
    ]
}
```

## Build do projeto e execução dos testes

Ao executar esse comando o maven irá realizar o processo de build que contém a execução dos testes.

    mvn clean package


## Rodando com docker

Para rodar o projeto com docker é necessário estar na pasta raiz do projeto e seguir os passos abaixo.

- executar ```mvn clean package``` para construir o jar da aplicação.
- após a construção do jar ser concluído com sucesso, executar ```docker-compose up``` para subir a aplicação.

## Monitoramento

Como o projeto utiliza o Actuator, é possível consultar a saúde do serviço por exemplo pelo endereço:

- http://localhost:8080/actuator/health