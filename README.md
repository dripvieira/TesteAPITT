README - Projeto de Automação de Testes de API para Plataforma ERP Contábil com Java e Rest Assured
  TesteAPITT
Este projeto visa desenvolver e executar testes automatizados de API para uma plataforma ERP Contábil. A plataforma ERP Contábil é um sistema essencial para organizações contábeis e financeiras, fornecendo funcionalidades como gestão de contas, lançamentos contábeis, emissão de relatórios financeiros, entre outros.

Este repositório contém o código-fonte e os recursos necessários para a automação de testes de API em uma plataforma ERP Contábil, utilizando Java e Rest Assured. O projeto tem como objetivo assegurar a qualidade e integridade das APIs da plataforma, validando suas funcionalidades e comportamentos esperados.

Tecnologias Utilizadas:
- Java: Linguagem de programação principal utilizada no projeto.
- Rest Assured: Framework Java usado para testar APIs RESTful de forma simplificada e fluente.
- Maven: Ferramenta de gerenciamento de dependências utilizada para configuração e execução do projeto.
- JUnit: Framework de teste unitário utilizado para execução dos testes de forma automatizada.

Pré-requisitos:
- JDK (Java Development Kit) instalado.
- Maven configurado corretamente em seu ambiente.

Configuração do Ambiente:
1. Clone este repositório em sua máquina local.
2. Certifique-se de que o JDK e o Maven estão configurados corretamente em seu ambiente.

Estrutura do Projeto:
- src/test/java: Contém os testes de API escritos em Java utilizando Rest Assured.
  - api_tests**: Contém os testes específicos para as APIs da plataforma ERP Contábil.
  - common: Contém classes e utilitários comuns para serem reutilizados nos testes.
- src/test/resources: Contém arquivos de configuração e dados para os testes, como arquivos JSON para envio de requisições e arquivos de propriedades para configurações específicas.

Executando os Testes:
1. Navegue até o diretório raiz do projeto.
2. Execute o comando `mvn test` no terminal para executar todos os testes de forma automatizada.
3. Para executar testes individuais, utilize as anotações do JUnit em seus respectivos métodos de teste.
4. 

Este projeto destina-se a demonstrar a implementação de automação de testes de API utilizando Java e Rest Assured em uma plataforma ERP Contábil. Qualquer dúvida ou problema, não hesite em abrir uma issue para discussão. Agradecemos sua contribuição e interesse neste projeto!
