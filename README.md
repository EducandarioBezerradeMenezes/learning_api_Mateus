# Learning API Mateus

API de Validação de CNPJ

Este projeto tem como objetivo, a partir da utilização do framework Spring, criar uma API, utilizando a linguagem de programação Java e a IDE Eclipse, utilizando o plug-in Spring Tool Suite, que ao enviar uma requisição http, com um CNPJ como parâmetro, verifica se o CNPJ é valido, armazena esta requisição em uma base de dados do SGBD Postgresql, envia uma resposta em Jason contendo o valor do CNPJ e uma variável indicando se tal CNPJ é valido ou não. Para o desenvolvimento desta aplicação foram utilizados:

    • JDK 1.8_101;

    • Eclipse JSE + Spring Tool Suite 4.6 para Windows x64;

    • Framework Spring;

    • JPA 2.1;

    • Postgresql  9.4.1210.

No desenvolvimento desta aplicação foi criada uma classe JavaApiApplication que em seu método main inicializa a API utilizando o Spring Boot , gerenciando as outras classes. Esta aplicação possui também:
	
  •	Models:

    •  CNPJ – armazena uma String contendo um CNPJ e o valida;
    
    •  Request – guarda informações que envolvem uma requisição http (Data, IP, Dispositivo, Protocolo, Método,
       Parâmetro e Resposta);

  •	Services:

    •	ServiceRequestDb – armazena as informações de objetos Request em uma base de dados Postgresql;
    
    •	ServiceRequestFile – armazena as informações de objetos Request em um arquivo chamado Request.txt;

  •	Controllers:

    •	ControllerCnpj – direciona requisições http envolvendo CNPJ para seus devidos métodos e as armazena na 
      base de dados utilizando um objeto Service.
    
    •	ControllerRequest – redireciona requisições http envolvendo o histórico de requisições (retorna o historico
      de requisições).