package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description "Should return subtract numbers 2 and 3"

    request {
        method("GET")
        url("/calculate/subtract/2/3")
    }

    response {
        status 200
        body(["result":-1, "operation": "subtract"])
        headers {
            contentType("application/json")
        }
    }

}