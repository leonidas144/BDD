#Author: leo_alvarenga92@hotmail.com
#Keywords Summary : conta
#Feature: Cliente faz saque de dinheiro. Como um cliente, eu gostaria de sacar dinheiro em um caixa eletrônico, para que eu não tenha que esperar em uma fila do banco.
#Scenario: Cliente especial com saldo negativo
#Given: Cliente especial com saldo de -200 reais
#When: solicitado saque no valor de 100 reais
#Then: efetuar saque e atualizar o saldo para -300 reais
#And,But: check more outcomes
#Scenario Outline: Cliente comum com saldo negativo
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Cliente faz saque de dinheiro
  Como um cliente, eu gostaria de sacar
	dinheiro em um caixa eletrônico, para
	que eu não tenha que esperar em uma
	fila do banco

  @tag1
  Scenario: Cliente especial com saldo negativo
    Given Cliente especial com saldo de -200 reais
    When solicitado saque no valor de 100 reais
    Then efetuar saque e atualizar o saldo para -300 reais
    And check more outcomes

  @tag2
  Scenario Outline: Cliente comum com saldo negativo
    Given Cliente comum com saldo de -200 reais
    When solicita um saque de 200 reais
    Then não efetua o saque e retorna mensagem Saldo insuficiente


  
