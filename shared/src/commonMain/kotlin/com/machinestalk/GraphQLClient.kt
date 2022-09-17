package com.machinestalk

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

/**
 * this class is the class that execute the graphQl request with the function execute
 *@param url the url of the server as String
 * @param httpClient the Ktor [HttpClient]
 * @see [HttpClient] [link] (https://api.ktor.io/ktor-client/ktor-client-core/io.ktor.client/-http-client.html)
 *
 * @constructor the GraphQL Client constructor
 * @since v0.1
 */
class GraphQLClient(url:String) {
    private var httpClient: HttpClient
    private val url: String
    init {
        this.url = url
        this.httpClient = HttpClient() {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.BODY
            }
        }



    }

    /**
     * this function execute the GraphQL request
     * @param graphQLRequest the GraphQL request object as GraphQLRequest
     * @see [GraphQLRequest]
     * @return the responce as a String
     * @since v0.1
     */
    suspend fun exec(graphQLRequest: GraphQLRequest): String {

        // val decodedJson  = Json.decodeFromString<Test>( stringResponce )
        return httpClient.post(url) {
            contentType(ContentType.Application.Json)
            setBody(graphQLRequest)
        }.body()
    }

    /**
     * this function execute the GraphQL request
     * @param graphQLRequest the GraphQL request object as GraphQLRequest
     * @see [GraphQLRequest]
     * @param headers the headers of the requests as HashMap
     * @see [HashMap]
     * @return the responce as a String
     * @since v0.1
     */
    suspend fun exec(graphQLRequest: GraphQLRequest, headers: HashMap<String,String>): String {
        return httpClient.post(url) {
            if (headers !== null) {
                for((key,value) in headers){
                    headers {
                        append(key,value)
                    }
                }
            }

            contentType(ContentType.Application.Json)
            setBody(graphQLRequest)
        }.body()
    }


}