# Multi-module project

A simple example of a multi-module project with an encapsulated dependency on Spring Boot.

## Requirements

* Java >= 8

## Running

`./gradlew bootRun`

## Endpoints

* `GET /` - returns all messages stored in memory

* `GET /{id}` - returns a single message based on its ID or `404 Not Found`

* `POST /?content={message}` - stores a new message and returns it 
