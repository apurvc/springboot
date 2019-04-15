def label = "maven-${UUID.randomUUID().toString()}"

podTemplate(label: 'cd-jenkins-slave' , yaml: """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: some-label-value
spec:
  containers:
  - name: maven
    image: maven:3.3.9-jdk-8-alpine
    command:
    - cat
    tty: true
    env:
    - name: CONTAINER_ENV_VAR
      value: container-env-var-value
"""
  ) {

  node(label) {
    stage('Build a Maven project') {
      container('maven') {
          sh 'mvn -B clean package'
      }
    }
  }
}
