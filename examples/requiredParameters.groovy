#!/usr/bin/env groovy


def call(String JSON, String user, String repository, String hash, String credentialsToken) {
    script {
        echo "curl -X POST -m 10 -d ${JSON} -u ${credentialsToken} https://api.github.com/repos/${user}/${repository}/statuses/${hash}"
    }
}

/*
// Example Usage
stage('Hello') {
    steps {
        requiredParameters("myJson", "myUser", "myRepo", "myHash", "myCreds")
    }
}
*/