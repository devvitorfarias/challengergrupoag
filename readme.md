
<header>
    <p>Sistema para Gerenciamento de Projetos e Desenvolvimento de Software</p>
</header>

<section>
    <div class="content">
        <h2>Sobre o Projeto</h2>
        <p>Este é um sistema desenvolvido para gerenciar projetos de forma eficaz, permitindo a integração de times, clientes e tarefas, além de proporcionar um acompanhamento em tempo real dos status dos projetos e atividades.</p>

<h2>Funcionalidades</h2>
        <ul>
            <li>Cadastro de Clientes;</li>
            <li>Cadastro de Projetos e Atividades;</li>
            <li>Relacionamento de atividades aos projetos e clientes;</li>
            <li>Acompanhamento de status de projetos (abertos, concluídos, etc.);</li>
            <li>Listagem de atividades cadastradas em projetos específicos.</li>
        </ul>

<h2>Tecnologias Utilizadas</h2>
        <ul>
            <li><strong>Back-end:</strong> Java e Spring Boot;</li>
            <li><strong>Banco de Dados:</strong> PostgreSQL com mapeamento ORM utilizando Hibernate;</li>
            <li><strong>Persistência:</strong> Hibernate para persistir registros de clientes, projetos e atividades;</li>
            <li><strong>Framework de Desenvolvimento:</strong> Spring Boot para construção da API e lógica de negócios.</li>
        </ul>

<h2>Estrutura de Banco de Dados</h2>
        <p>O banco de dados utilizado é o PostgreSQL, e a persistência dos dados é feita através do Hibernate, com as seguintes entidades principais:</p>
        <ul>
            <li><strong>Cliente:</strong> Registra informações sobre os clientes da empresa.</li>
            <li><strong>Projeto:</strong> Registra os projetos em andamento e os status associados.</li>
            <li><strong>Atividade:</strong> Cada atividade é associada a um projeto e cliente, podendo ser adicionada a qualquer momento.</li>
        </ul>
<h2>Diagrama</h2>
https://app.eraser.io/workspace/9JSXCl8VP71xGeLPAqA5?origin=share
<h2>Dificuldades</h2>
<p>O teste ficou meio confuso pra mim em relação a exibição de atividades cadastradas em cada projeto e gerenciamento de status , acredito eu que no meu Postman o problema que eu esteja sofrendo é em relação a cache . Se caso meu codigo não funcionar eu aceito feedbacks para melhorias</p>

