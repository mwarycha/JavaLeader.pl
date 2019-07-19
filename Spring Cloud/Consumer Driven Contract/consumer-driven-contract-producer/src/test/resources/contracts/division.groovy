package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description "Should return division numbers 10 and 2"

    request {
        method("GET")
        url("/calculate/division/10/2")
    }

    response {
        status 200
        body(["result":5, "operation": "division"])
        headers {
            contentType("application/json")
        }
    }

}