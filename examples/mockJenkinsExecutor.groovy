#!/usr/bin/env groovy

/*
This allows injecting a jenkins executor into the pipeline step in order to mock behavior in tests.

Mocking can also be done by using the BasePipelineSpecification helper without needing to inject
the jenkins executor in a pipeline step.

For example:

helper.registerAllowedMethod('isUnix', {return false})
helper.registerAllowedMethod("sh", [String.class], { cmd ->
    if (cmd.contains("aws")) {
        failBuild()
    }
})

 */
def call(executor, map) {

    String JSON = map.getOrDefault("JSON", "defaultJson")
    String credentialsToken = map.getOrDefault("credentialsToken", "defaultCreds")
    String user = map.getOrDefault("user", "defaultUser")
    String repository = map.getOrDefault("repository", "defaultRepo")
    String hash = map.getOrDefault("hash", "defaultHash")

    script {
        executor.echo "curl -X POST -m 10 -d ${JSON} -u ${credentialsToken} https://api.github.com/repos/${user}/${repository}/statuses/${hash}"
    }
}

/*
// Example Usage
stage('Hello') {
    steps {
        injectJenkinsExecutor(this, [
            JSON: "myJson",
            credentialsToken: "myUser",
          ])
    }
}
*/