#!/usr/bin/env groovy


def call(Map map) {
    String name = map.getOrDefault("name", "defaultName")
    String repository = map.getOrDefault("repository", "defaultRepository")
    String hash = map.getOrDefault("hash", "defaultHash")
    echo "name=$name, repository=$repository, hash=$hash"
}

/*
// Example Usage
stage('Hello') {
    steps {
        optionalParameters(
            name: "myJson",
            repository: "myRepo",
            hash: "myHash"
         )

         optionalParameters(
            name: "myJson"
         )
    }
}
*/