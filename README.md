# Desafio
<p/>
1 - Para executar, baixe o fonte:
<p/>
git clone https://github.com/helderlee/desafio.git
<p/>
2 - Execute com maven no diretório do pom.xml:
<p/>
mvn spring-boot:run
<p/>
-----------------------------------------------------
<p/>
O teste pode ser feito com Postman:
<p/>
<b>Listar planetas</b> - método GET - http://localhost:8080/desafio/planetas
<p/>
<b>Adicionar planeta</b> - método POST - http://localhost:8080/desafio/planetas
<p/>
Selecione Body, raw e JSON (application/json)
<p/>
Exemplo para preenchimento:
<p/>
{
	"id": 3,
	"nome": "Yavin IV",
	"clima": "temperate, tropical",
	"terreno": "jungle, rainforests"
}
<p/>
<b>Buscar por nome</b> - método GET - http://localhost:8080/desafio/planetas?nome={nome-a-pesquisar}
<p/>
<b>Buscar por ID</b> - método GET - http://localhost:8080/desafio/planetas/{id}
<p/>
<b>Remover planeta</b> - método DELETE - http://localhost:8080/desafio/planetas/{id}
