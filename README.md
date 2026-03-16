# Spring Batch em Ação

Projeto de estudo do framework Spring Batch, construído a partir do artigo [Spring Batch em ação: processamento de grandes lotes de dados](https://devsuperior.com.br/blog/spring-batch-em-acao-processamento-de-grandes-lotes-de-dados)

## Objetivo do projeto:

Automatizar a leitura de relatórios de diversas fontes e gerar um relatório geral que centraliza os dados do negócio, utilizando processamento em lote.

>A aplicação gera um único relatório de vendas consolidado a partir dos relatórios individuais de várias concessionárias filiais espalhadas pelo país.

## Caso de uso:

O projeto simula o funcionamento de uma rede de concessionárias que possui um relatório para cada uma de suas filiais, gerado pelos seus responsávies, e processa os dados de todos esses relatórios para gerar um único relatório final da concessioária matriz, que busca apresentar as informações das vendas para seus acionistas de forma clara e objetiva.

O relatório final segue o formato: dealer_name, model, units_sold, revenue_brl.

Exemplo:

    Aurora Belém Guajará,SERRA,33,4884524.36
    Aurora Belém Guajará,TOURO,27,6330693.73
    Aurora Brasília Eixo,ATLAS,21,4869395.22
    Aurora Brasília Eixo,BRISA,15,2065704.66
    Aurora Brasília Eixo,EON,8,1674214.38

## Etapas do processamento:

Assim que a aplicação é acionada ela lê os dados dos relatórios enviados por cada filial. Após a leitura, os dados são processados em lotes de 100 linhas, essas linhas são lidas>processadas>exportadas e guardadas na memória. Ao final do processamento de todos os lotes, o relatório final é construído a partir dos dados exportados por todos os lotes do pipeline de execução.

## Por que usar o processamento em lotes?
As técnicas de processamento em lote são ideais para automatizar processos sem necessidade de interferência humana, reduzindo o risco de erros no caminho. Além de garantir um uso eficiente dos recursos computacionais, já que a divisão em lotes de tamanho delimitado evita a sobrecarga.

Neste cenário onde grandes volumes de dados são processados, é a oportunidade perfeita para usar o Spring Batch já que, além de dividir o processamento em lotes, ele também permite monitorar possíveis falhas de execução e evita que uma falha em um lote específico interrompa o fluxo da aplicação ou prejudique a análise de outros dados em outros lotes.

## Melhorias:
O projeto original foi adaptado para garantir um melhor funcionamento. As seguintes melhorias foram implementadas:

> - Melhora na organização dos pacotes: Estrutura de pastas alterada para melhorar a legibilidade e facilitar futuras refatorações no código. Todas as etapas do pipeline de processamento em lote estão no pacote **batch** e as classes de domínio estão separadas em outro pacote chamado **domain**
> - Ajuste da normalização no Processor: Deixa os dados da coluna **model** em maiúsculo, dando mais destaque a esse dado importante;
> - Adição de testes unitários:
    >  - -  **Teste da classe Processor** para validar a normalização dos dados;
> - - **Teste da classe de domínio ReportLine** para validar a soma dos valores da coluna units_sold e da coluna revenue_brl;
> - - **Teste da classe Writer** para validar o processamento da saída dos dados da aplicação e garantir que não há erro.

## Conclusão:

Este projeto me permitiu analisar de forma prática como funciona o processamento em lotes, entender todos os seus requisitos e entender o funciomento da estrutura JobRepository > Job > Step > Leitura >  Processamento > Saída; Aplicada no framework Spring Batch.
