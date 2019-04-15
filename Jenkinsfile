def label = "maven-${UUID.randomUUID().toString()}"

podTemplate(label: label ,defaultContainer: 'jnlp',  yaml: """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: cd-jenkins-slave
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
