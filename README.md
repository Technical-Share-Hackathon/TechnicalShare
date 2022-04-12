> Status: em Desenvolvimento ⚠️

### É uma aplicação web FullStack que tem como objetivo facilitar a interação entre funcionários de uma empresa, com foco em oferecer ajuda e mentoria a quem precisa.

## O principal modelo do projeto é um Usuario, sendo composto por:

+ nome 
+ resumo
+ profissão
+ squad
+ e todas as suas habilidades técnicas e comportamentais
 
## Tecnologias usadas:

<table>
  <tr>
    <td>Java</td>
    <td>Spring</td>
    <td>MySql</td>
    <td>Angular</td>
  </tr>
  <tr>
    <td>8.*</td>
    <td>7.4</td>
    <td>8.0</td>
    <td>7.0</td>
  </tr>
</table>

## Como rodar o Backend do Projeto:

1) o projeto já possuí um script que faz a inserção dos dados no banco de dados, portanto, certifique-se de no application.properties direcionar o usuário e senha para seu próprio banco de dados, além de adicionar a dependência correta no pom.xml: 
![image](https://user-images.githubusercontent.com/72326473/163059595-87cdf1fc-8f8e-4f5f-9648-20639965691a.png | width=100)
![image](https://user-images.githubusercontent.com/72326473/163059677-3ee6aaa0-860c-4898-87b5-b65c3ab0a010.png | width=100)
2)basta iniciar o projeto pela própria IDE do seu gosto. Para uma documentação mais detalhada dos endpoints, acesse o swagger da aplicação:
3)![image](https://user-images.githubusercontent.com/72326473/163060619-95d0be70-9351-40f6-bdee-249c071b18e1.png | width=100)

## Como rodar o FrontEnd do Projeto:
1) Primeiro execute o comando "npm install" no diretório do projeto angular, isso vai garantir que vc instale todas as dependências que são ignoradas pelo git
2) Depois disso basta digitar o comando "ng serve", o terminal indica a porta onde você pode acessar a aplicação

