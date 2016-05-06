# Projeto Leilão

## Configurações

1. Abra um terminal
2. Vá até o diretório do workspace do Eclipse digitando: `cd workspace`
3. Baixe o projeto Leilão para sua máquina digitando: `git clone git@github.com:alexandreaquiles/fj25-leilao.git`
4. Vá até o diretório do projeto com `cd fj25-leilao`.
5. Execute um script de BD com o comando: `mysql -u root < leilao.sql`
6. Abra o Eclipse. Vá em *File > Import... > General > Existing Projects into Workspace*. Em *Select root directory*, clique em *Browse..*. Selecione o projeto `fj25-leilao`. Certifique-se que *Copy projects into workspace* está **desabilitado**.
7. Clique com o botão direito no diretório `src/test`. Escolha *Run As > JUnit Test*. Se estiver vermelho, tá ERRADO. Se estiver verde, **SUCESSO**.

## O que fazer?

Seu objetivo é fazer com que os testes fiquem verdes usando anotações do JPA nas classes de modelo do pacote `br.com.caelum.leilao.modelo`. 

Analise a estrutura do BD. Dica: pode olhar o script `leilao.sql` para ter uma ideia.

Verifique as classes Java. Como mapeá-las para que funcionem com esse BD?

**NÃO** vale mudar o conteúdo do BD, nem do persistence.xml, nem de atributos e métodos das classes Java.


