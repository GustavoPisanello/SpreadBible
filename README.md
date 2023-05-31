# ProjetoSpreadBible
Autores: Alexandre Mezack de Lima & Gustavo Laur Pisanello

Dados da API escolhida:

<p align="center">
<img align="center" src = "https://user-images.githubusercontent.com/99992149/230115916-9f3e7ad6-e2f1-47cd-84b8-25514d7d6a2a.png" width="100px" heigth="100px"/>
</p>


-  URL da documentação: https://github.com/marciovsena/abibliadigital/blob/master/DOCUMENTATION.md
-  URL de Acesso a API: https://www.abibliadigital.com.br/api/

- Métodos disponíveis / (endpoints) / Foi utilizado ou não (0 = não foi usado, 1 = foi usado).  Todos os métodos abaixo não requisitam autenticação, mas, se não possuir uma, são limitadas a 20 requisições por hora. Além disso, TODOS retornam strings e ints. <br> <br>
```Get Books (retorna a lista de 66 livros da bíblia) / GET https://www.abibliadigital.com.br/api/books - 1 ```<br>
```Get Book (retorna detalhes de um livro específico da bíblia) / GET https://www.abibliadigital.com.br/api/books/:abbrev - 1``` <br>
```Get Chapter (retorna todos o versos e detalhes de um capítulo) / GET https://www.abibliadigital.com.br/api/verses/:version/:abbrev/:chapter - 1```<br>
```Get Verse (retorna um verso de um capítulo) / GET https://www.abibliadigital.com.br/api/verses/:version/:abbrev/:chapter/:number - 1``` <br>
```Get Random Verse (retorna um verso aleatório de um capítulo aleatório) / GET https://www.abibliadigital.com.br/api/verses/:version/random - 1```<br>
```Get Random Verse Book (retorna um verso aleatório de um livro específico) / GET https://www.abibliadigital.com.br/api/verses/:version/:abbrev/random - 1 ```<br>
```Search by word (retorna versos com a palavra digitada como parâmetro) / POST https://www.abibliadigital.com.br/api/verses/search - 1```<br>
```Get Versions (retorna todas as versões da bíblia e o número de versos) / GET https://www.abibliadigital.com.br/api/versions - 1``` 

      
Exemplo 
~~~javascript
abbrev: {
pt: "js",
en: "js"
},
author: "Josué",
chapters: 24,
group: "Históricos",
name: "Josué",
testament: "VT"
} 
~~~

      - Create Users (cria um novo usuário) / POST https://www.abibliadigital.com.br/api/users (Dados para a criação de usuário: Nome, Email e Senha) - NÃO Precisa de autenticação - 0
      - Get User (retorna um usuário) / GET https://www.abibliadigital.com.br/api/users/:email - Precisa de autenticação - 0
      - Get User Stats (retorna as estatísticas do usuário) / GET https://www.abibliadigital.com.br/api/users/stats - Precisa de autenticação - 0
      - Update Token (retorna um token) / PUT https://www.abibliadigital.com.br/api/users/token - NÃO Precisa de autenticação - 0
      - Delete User (remove um usuário) / DELETE https://www.abibliadigital.com.br/api/users - Precisa de autenticação - 0
      - Resend User Password (Manda um email com a senha do usuário) / POST https://www.abibliadigital.com.br/api/users/password/:email - NÃO Precisa de autenticação - 0
      
Todos os métodos ABAIXO necessitam obrigatoriamente uma autenticação 

      - Get Requests (retorna as requisições num período) / GET https://www.abibliadigital.com.br/api/requests/:range (mês, semana, dia) - 0
      - Get Number Requisitions (retorna o número de requisições num período / GET https://www.abibliadigital.com.br/api/requests/amount/:range (mês, semana, dia) - 0

Sumário de Parâmetros de busca desta API:
```      - abbrev: abreviação do livro {Gênesis = Gn / Êxodo = Ex / Levítico = Lv / Números = Nm / Deuteronômio = Dt / Josué = Js / Samuel = Sm / Ruth = Rt / Jó = job / Salmos = sl / Mateus = mt / Isaías = Is / Jeremias = Jr / Judas = Jd, etc }
      - chapter: capítulo da bíblia
      - search: variável digitada pelo usuário como índice de busca
      - verses: verso da bíblia
      - version: versão da bíblia
      - number: número do versículo
```      
Exemplo de retorno de busca: https://www.abibliadigital.com.br/api/verses/nvi/sl/23

~~~javascript
book: {
abbrev: "sl",
name: "Salmos",
author: "David, Moisés, Salomão",
group: "Poéticos",
version: "nvi"
},
chapter: {
number: 23,
verses: 6
},
verses: [
{
number: 1,
text: "O Senhor é o meu pastor; de nada terei falta."
},
{
number: 2,
text: "Em verdes pastagens me faz repousar e me conduz a águas tranqüilas;"
},
{
number: 3,
text: "restaura-me o vigor. Guia-me nas veredas da justiça por amor do seu nome."
},
{
number: 4,
text: "Mesmo quando eu andar por um vale de trevas e morte, não temerei perigo algum, pois tu estás comigo; a tua vara e o teu cajado me protegem."
},
{
number: 5,
text: "Preparas um banquete para mim à vista dos meus inimigos. Tu me honras, ungindo a minha cabeça com óleo e fazendo transbordar o meu cálice."
},
{
number: 6,
text: "Sei que a bondade e a fidelidade me acompanharão todos os dias da minha vida, e voltarei à casa do Senhor enquanto eu viver."
}
]
}
~~~
