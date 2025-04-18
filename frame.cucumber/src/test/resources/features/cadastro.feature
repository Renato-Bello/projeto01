#Author: your.email@your.domain.com


@regressivos @cadastroPrestador
Feature: Cadastro de prestador de servicos
  Como prestador de serviços
  Quero realizar meu cadastro
  Para realizar entregas

Background: 
Given que eu esteja na tela de cadastro

  @positivo @smoke @moto
  Scenario: Realizar cadastro metodo moto
    And preencha dados pessoais validos
    And preencha endereco valido
    And selecione tipo de veiculo
    When envio a foto da cnh valida
    Then clicar em cadastrar para fazer entregas
    And valido cadastro realizado com sucesso
    
    @positivo @bicicleta
    Scenario: Realizar cadastro metodo bicicleta
    And preencha dados necessarios corretamente   
    And selecione tipo de veiculo como bicicleta
    When envio foto da cnh valida
    Then clicar em cadastrar para fazer as entregas
    And valido mensagem cadastro realizado com sucesso
    
    @positivo @van
    Scenario: Realizar cadastro metodo Van
    And preencha todos os dados necessarios corretamente   
    And selecione tipo de veiculo como van
    When envio uma foto da cnh valida
    Then clicar em cadastrar para fazer a entrega
    And valido o cadastro realizado com sucesso
    
    @negativo @branco
    Scenario: realizar cadastro com dados em branco
    But nao informo nenhum dado obrigatorio
    When eu clicar em cadastrar 
    Then eu valido as mensagens nos campos indicando a obrigatoriedade do preenchimento
    
    @negativo @invalidos
    Scenario: realizar cadastro com dados invalidos
    But informo dados obrigatorios invalidos
    When eu clicar para cadastrar 
    Then eu valido as mensagens nos campos indicando os dados invalidos
    
    @negativo @semcnh
    Scenario: realizar cadastro sem enviar anexo
    And preencho os campos obrigatorios
    But nao anexo a cnh
    When eu clicar no botão para cadastrar 
    Then eu valido a mensagem de erro sobre a obrigatoriedade do anexo
    
    @negativo @sementrega
    Scenario: realizar cadastro sem metodo de entrega
    And preencho todos os campos obrigatorios
    But nao informo nenhum metodo de entrega
    When eu clicar no botão cadastrar 
    Then eu valido a mensagem de erro sobre a obrigatoriedade de um metodo