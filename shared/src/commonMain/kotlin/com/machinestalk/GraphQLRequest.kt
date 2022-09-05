package com.machinestalk

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
/**
 * this class is the blue print of the GraphQL Request
 * @param query the query of the graphQl request as a String
 * @param operationName the operation name as a String.this parametre is optional.
 * @param variables the variables of the graphQl request as [HashMap]
 * @see [HashMap]
 * @constructor
 * @since v0.1
 */
class GraphQLRequest(val query: String?,val operationName: String?,@Contextual val variables: HashMap<String,String>?){

    /**
     * this class implement the builder pattern
     * @constructor this constructor is called in order to user the builder pattern
     * @param query the query of the graphQl request as a String in the builder pattern
     * @param operationName the operation name as a String.this parametre is optional.
     * @param variables the variables of the graphQl request as [HashMap]
     * @see [HashMap]
     * @since v0.1
     */
    data class Builder(
        var query: String?=null,var operationName: String?=null,var variables: HashMap<String,String>?=null,var headers: HashMap<String,String>?=null) {
        fun setQuery(query: String) = apply { this.query = query }
        fun setOperationName(operationName: String) = apply { this.operationName = operationName }
        fun setVariables(variables: HashMap<String,String>) = apply { this.variables = variables }
        //fun setHeaders(headers: Map<String,String>) = apply { this.headers = headers }
        fun build() = GraphQLRequest(query, operationName, variables)
    }
}