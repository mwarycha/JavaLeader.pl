package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description "Should return addition numbers 2 and 3"

    request {
        method("GET")
        url("/calculate/addition/2/3")
    }

    response {
        status 200
        body(["result":5, "operation": "addition"])
        headers {
            contentType("application/json")
        }
    }

}