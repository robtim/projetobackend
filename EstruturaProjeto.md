```shell
.
└── src
    └── main
         ├── java\com\teste\primeiro_exemplo
         |    ├── handler
         |    |   └── RestExceptionHandler.java (Controle Exceção)
         |    ├── model
         |    |   ├── error (Classe Tratamento mensagem de erro)
         |    |   |   └── ErrorMessage.java
         |    |   ├── exception
         |    |   |   └── ResourceNotFoudException.java (Classe Execeção não encontrado)
         |    |   └── Produto.java (Classe Model de produto)
         |    ├── repository
         |    |   └── ProdutoRepository.java (Classe Repositorio Req Services chama banco)
         |    ├── servces
         |    |   └── ProdutoServices.java (Classe Serviço Req controller Cham Repository)
         |    ├── shared
         |    |   └── ProdutoDTO.java  (Transferencia Dados Control e Serv )                 
         |    ├── view
         |    |   ├── controller
         |    |   |     ├── handlers
         |    |   |     |   └── handlers.java   
         |    |   |     └── ProdutoController.java(Controller Req Serv Cham Rep)             
         |    |   └── model
         |    |       ├── ProdutoRequest.java (Objeto Request Controller)
         |    |       └── ProdutoResponse.java (Objeto Response Controller)         
         |    └── PrimeiroExemploApplication.java 
         └── resource
              └── application.properties (Configurações projeto, banco etc..)
```