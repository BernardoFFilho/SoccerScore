# ⚽ SoccerScore

![Kotlin](https://img.shields.io/badge/Kotlin-2.2-blue.svg?logo=kotlin)
![Android API](https://img.shields.io/badge/API-26%2B-brightgreen.svg?logo=android)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-UI-success.svg?logo=android)

O **SoccerScore** é um aplicativo Android desenvolvido inteiramente com **Jetpack Compose** e **Navigation Compose**. Ele atua como um Simulador de Placar de Futebol, permitindo que o usuário insira os dados de uma partida, revise as informações e visualize o grande vencedor baseado nas regras de negócio.

---

## 📱 Telas e Funcionalidades

O aplicativo possui um fluxo de navegação linear, composto por três telas integradas com passagem de parâmetros:

### 1️⃣ Tela de Configuração da Partida
- Interface para entrada de dados (Nomes dos times e quantidade de gols).
- **Validação:** Garante que todos os campos estejam preenchidos e que os gols sejam números inteiros positivos.
- **Resiliência:** Utiliza `rememberSaveable` para garantir que os dados digitados não sejam perdidos caso o usuário rotacione a tela do dispositivo.

### 2️⃣ Tela de Resumo da Partida
- Exibe o placar formatado do confronto (Ex: *Time A 2 x 1 Time B*).
- **Ações:** O usuário pode **Confirmar o Resultado** (avançando para o veredito) ou **Editar** (fazendo um *pop* na navegação para voltar à tela inicial).

### 3️⃣ Tela de Resultado Final
- Processa a regra de negócio para determinar o status da partida:
  - 🏆 *"[Time A] venceu!"*
  - 🏆 *"[Time B] venceu!"*
  - 🤝 *"Empate emocionante!"*
- Botão **Novo Jogo**, que limpa o histórico de navegação (backstack) e retorna o app ao seu estado inicial.

---

## 🛠️ Especificações Técnicas e Restrições

Este projeto foi construído seguindo requisitos de ambiente rigorosos:

- **Linguagem:** Kotlin `2.2`
- **Minimum SDK:** `26` (Android 8.0 Oreo)
- **Gradle:** `9.2.1`
- **Android Gradle Plugin (AGP):** `9.0.1`
- **UI Toolkit:** Jetpack Compose (utilizando puramente componentes básicos como `Text`, `OutlinedTextField` e `Button`).
- **Navegação:** `androidx.navigation:navigation-compose` (Navegação baseada em rotas com passagem de strings e inteiros).
- **Sem integrações externas:** O app funciona offline, sem uso de APIs REST, banco de dados ou listas complexas, focando exclusivamente na manipulação de estado e navegação.

---

## 🚀 Como executar o projeto

1. Clone este repositório em sua máquina:
   ```bash
   git clone https://github.com/SEU_USUARIO/SoccerScore.git
