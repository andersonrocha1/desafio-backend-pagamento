# Criando o Back-End simples de uma plataforma pagamentos

## Índice
- <a href="#desafioproposto">Desafio Proposto</a>
- <a href="#tecnologiasutilizadas">Tecnologias Utilizadas</a>
- <a href="#bancosutilizados">Banco de Dados</a>
- <a href="#padroesutilizados">Padrões do Projeto</a>
- <a href="#observacoes">Observações</a>
- <a href="#contatos">Contatos</a>


##  Desafio Proposto

### Objetivo: PicPay Simplificado

- Temos 2 tipos de usuários, os comuns e lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles. Vamos nos atentar somente ao fluxo de transferência entre dois usuários.

Requisitos:

* Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.

* Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.

* Lojistas só recebem transferências, não enviam dinheiro para ninguém.

* Validar se o usuário tem saldo antes da transferência.

* Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock para simular (https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6).

* A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia.

* No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock para simular o envio (http://o4d9z.mocklab.io/notify).

* Este serviço deve ser RESTFul.

##   Tecnologias Utilizadas

  - [x] Java
  - [x] SQL
  - [x] Spring Boot

## Banco de Dados

  - [x] Banco de dados H2 - Testes



## Padrões do projeto

- API REST

    ### Padrão Rest

        • Cliente/servidor com HTTP 
        • Interface uniforme, formato padronizado (*)
        • Cache
        • Sistema em camadas

    ### Padronização

        GET https://meusistema.com/users
        {
          ...
        }

        POST https://meusistema.com/users         
        {          
          ...        
        }

        POST https://meusistema.com/transactions         
        { 
          ...
        }
   

## Padrão Camadas

![Camadas](https://user-images.githubusercontent.com/23089093/239023317-bf27fd4c-82b4-4a77-887d-3e88dd0d1511.png)



## Observações:

*  Neste requisito tive problemas: Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock para simular (https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6). Pois, o corpo estava vindo vazio, na verdade a url não funcionava...

  - Solução: Utilizei este site http://echo.jsontest.com/message/Autorizado , passando na url a notificação esperada, assim a transação era concluída com sucesso...



## Contatos

* Links    
<a href= "https://www.linkedin.com/in/anderson-rocha-228231222/">Linkedin : Anderson</a>


