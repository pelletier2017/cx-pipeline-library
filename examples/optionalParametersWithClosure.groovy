#!/usr/bin/env groovy

def call(final Map config, final Closure body) {
    final String username = config.getOrDefault("name", "defaultUser")
    final String email = config.getOrDefault("email", "defaultEmail")
    final String path = config.getOrDefault("path", "defaultPath")

    println(username)
    println(email)
    println(path)

    echo "before closure"

    // body.call() can be called with 0 or more arguments
    String combinedArg = "username=$username, email=$email, path=$path"
    body.call(combinedArg)

    echo "after closure"
}

/*

// example usage
stage('Hello') {
    steps {

        // works without specifying the extra closure argument
        optionalParametersWithClosure(name: "nameIsJenkins", email: "mySpecialEmail", path: "myPath") {
            echo "hello"
        }

        // allows user to optionally use the combined arg passed to the closure body.call()
        optionalParametersWithClosure(name: "nameIsJenkins", email: "mySpecialEmail", path: "myPath") { myStr ->
            echo "$myStr"
        }

        // map allows optional arguments
        optionalParametersWithClosure(email: "mySpecialEmail") {
            echo "hello"
        }
    }
}
 */