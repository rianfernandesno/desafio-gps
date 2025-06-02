# 🛰️ Desafio GPS - Pontos de Interesse

Este projeto é uma solução para o desafio [**Pontos de Interesse por GPS**](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md) proposto pela comunidade [backend-br](https://github.com/backend-br). A aplicação simula o backend de um receptor GPS capaz de armazenar e consultar **POIs (Points of Interest)** com base na sua localização e proximidade.

---

## ✅ Requisitos do Desafio

- ✅ Cadastrar pontos de interesse com os atributos:
  - Nome do POI
  - Coordenada X (inteiro não negativo)
  - Coordenada Y (inteiro não negativo)
- ✅ Armazenar os POIs em uma base de dados.
- ✅ Listar todos os POIs cadastrados.
- ✅ Listar POIs por proximidade a partir de uma coordenada de referência e uma distância máxima.

---

## 🚀 Tecnologias Utilizadas

- Java 21+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (para testes)
- PostgreSQL (pode ser usado em produção)
- Maven

---

## 🧭 Endpoints

### 📍 `POST /point`

Cadastra um novo ponto de interesse.

#### Corpo da requisição (JSON):

```json
{
  "name": "Lanchonete",
  "x": 27,
  "y": 12
}

```

Resposta
```json
{
  "id": 1,
  "name": "Lanchonete",
  "x": 27,
  "y": 12
}
````

📍 GET /point

Lista todos os pontos de interesse cadastrados.
Resposta:

```json
[
  {
    "id": 1,
    "name": "Lanchonete",
    "x": 27,
    "y": 12
  },
  {
    "id": 2,
    "name": "Posto",
    "x": 31,
    "y": 18
  }
  // ...
]
```

📍 POST /point/proximity

Retorna os POIs dentro da distância máxima (d-max) a partir de um ponto de referência.
Corpo da requisição (JSON):

```json
{
  "x": 20,
  "y": 10
}
```


