package com.dynamodb.sandbox.dynamodbsandbox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DynamodbSandboxApplication

fun main(args: Array<String>) {
    runApplication<DynamodbSandboxApplication>(*args)
}
