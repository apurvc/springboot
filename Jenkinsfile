def project = 'springboot'

pipeline {
  agent {
    kubernetes {
      label 'cd-jenkins-slave'
      defaultContainer 'jnlp'
      yaml """
apiVersion: v1
kind: Pod
metadata:
labels:
  component: ci
spec:
  # Use service account that can deploy to all namespaces
  serviceAccountName: cd-jenkins
  containers:
  - name: maven
    image: maven:3-alpine
    command:
    - cat
    tty: true
"""
}
  }
  stages {
    stage('Build') {
      steps {
        container('maven') {
          echo 'Doing maven build'
          sh 'mvn clean install'
        }
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deployment to be done'
      }
    }
    
  }
}
