# API de Saúde Mental
## Este programa é uma API para Monitoramento de Saúde Mental que permite aos usuários:

### Criar uma conta: Os usuários podem se registrar e fazer login para acessar o sistema.

### Definir metas pessoais: Cada usuário pode criar e acompanhar metas que deseja alcançar.

### Registrar seu humor: Os usuários podem fazer registros diários de humor, ajudando a observar seu bem-estar ao longo do tempo.

## O programa organiza essas informações e facilita o acompanhamento da saúde mental, oferecendo um espaço para metas e registros emocionais.
## Diagrama UML de Classes

```mermaid
classDiagram
    class User {
        + Long id
        + String name
        + String email
        + String password
    }

    class Goal {
        + Long id
        + String title
        + String description
        + String status
        + User user
    }

    class MoodEntry {
        + Long id
        + Date date
        + String emotion
        + String notes
        + int intensity
        + User user
    }

    User "1" --> "*" Goal
    User "1" --> "*" MoodEntry
