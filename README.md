# SoccerScore

Simulador de Placar de Futebol desenvolvido como parte da disciplina de Programação para Dispositivos Móveis.

## Descrição
O SoccerScore é uma aplicação Android que permite configurar uma partida de futebol entre dois times, visualizar um resumo do placar para confirmação e, finalmente, verificar o resultado final (vencedor ou empate).

## Exigências Técnicas Cumpridas
- **Minimum SDK:** 26 (Android 8.0 Oreo)
- **Kotlin:** 2.2
- **Gradle:** 9.2.1
- **Android Gradle Plugin (AGP):** 9.0.1
- **Pacote Customizado:** `br.edu.ifsp.scl.sc3037291.soccerscore`
- **Navegação:** Jetpack Navigation Compose
- **Persistência de Estado:** Uso de `rememberSaveable` para suportar mudanças de configuração (ex: rotação de tela) sem perda de dados nos formulários.

## Fluxo do Aplicativo
1. **Configuração (`MatchConfigScreen`):** O usuário insere o nome dos dois times e a quantidade de gols de cada um. A tela valida se os campos não estão vazios e se os gols são números válidos antes de prosseguir.
2. **Resumo (`MatchSummaryScreen`):** Exibe os dados inseridos em um formato de placar (ex: "Time A 2 x 1 Time B"). O usuário pode optar por **Confirmar** o resultado ou **Editar** (voltando para a tela de configuração).
3. **Resultado (`MatchResultScreen`):** Apresenta o veredito da partida, indicando qual time venceu ou se houve um empate. Contém um botão para iniciar um **Novo Jogo**, que limpa a pilha de navegação e retorna à tela inicial.
