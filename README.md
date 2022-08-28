# Overview
## Regras e Requisitos
- Este trabalho de **Paradigmas de Programação** tem o objetivo de se desenvolver um software usando o paradigma de **Programação Orientada a Objetos**.
- O trabalho deve utilizar conceitos do **Paradigma de Programação Orientada a Objetos**.
- O trabalho deve ser desenvolvido na linguagem **Java** e deverá rodar no ambiente do **DInf**.
- O trabalho deve possuir uma **Interface Gráfica**.
- O tema escolhido para ser desenvolvido foi o **Sistema Pedido de quebra de barreiras**.

## Tema: Sistema Pedido de quebra de barreiras
- O sistema tem por objetivo auxiliar o aluno no seu pedido de quebra de barreira, verificar a situação do aluno e gerar um arquivo texto com o pedido de quebra e seus dados.
- O sistema deve permitir que o aluno obtenha as suas informações do histórico importando um arquivo .CSV. Além disso, o sistema deverá importar dados sobre as disciplinas, sua disponibilidade no semestre e a grade curricular, também de arquivo .CSV.
- O sistema deverá colocar estes dados em uma lista com as matérias cursadas e uma lista das matérias do curso. O sistema deverá então apresentar uma tabela com as matérias cursadas por período e as matérias que faltam cursar para a barreira. Além disso, o sistema deverá apresentar os dados de aprovação do último período como porcentagem de aprovação e quantas matérias reprovou por falta.
- O sistema deverá mostra ao aluno o conjunto de disciplinas ofertadas neste semestre que não foram cursadas neste semestre por ordem de período. O sistema deverá possibilitar que o aluno selecione um conjunto de disciplinas que ele deseja cursar com informação sobre a prioridade delas.
- O sistema deverá calcular o número de disciplinas sugerido pelas regras aprovadas em colegiado e mostrar este resultado. O sistema deve permitir salvar os dados do pedido em um arquivo de forma a permitir que o aluno os edite posteriormente. Quando o aluno selecionar enviar, o sistema deverá gerar um arquivo texto contendo os dados do pedido.


# Descrição do trabalho
## Modelo escolhido:  Model View Controller (MVC)
- O trabalho utiliza o Modelo Model-View-Controller (MVC), esse Modelo foi escolhido devido ao fato de que é uma abstração que facilita o particionamento da aplicação em componentes lógicos. Além disso, o modelo consegue dividir funcionalidade entre objetos de forma que o grau de acoplamento entre eles permanaça o menor possível.