#!/usr/bin/env groovy

def call(Closure body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // config stored as a map
    print(config)

    // refer to values in the map
    print(config.myArg)
}

/*
// Example Usage
stage('Hello') {
    steps {
        // must be in a script block for closure delegates
        script {
            closureDelegate() {
                myArg = "this"
                otherArg = "that"
            }
        }
    }
}
*/