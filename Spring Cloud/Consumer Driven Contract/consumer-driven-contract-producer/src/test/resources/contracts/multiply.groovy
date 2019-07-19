package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description "Should return multiply numbers 2 and 3"

    request {
        method("GET")
        url("/calculate/multiply/2/3")
    }

    response {
        status 200
        body(["result":6, "operation": "multiply"])
        headers {
            contentType("application/json")
        }
    }

}