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
<p/>
O teste pode ser feito com Postman:
<p/>
Listar planetas - método GET - http://localhost:8080/desafio/planetas
<p/>
Adicionar planeta - método POST - http://localhost:8080/desafio/planetas
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
Buscar por nome - método GET - http://localhost:8080/desafio/planetas?nome={nome-a-pesquisar}
<p/>
Buscar por ID - método GET - http://localhost:8080/desafio/planetas/{id}
<p/>
Remover planeta - método DELETE - http://localhost:8080/desafio/planetas/{id}
