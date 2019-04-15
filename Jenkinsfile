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
  - name: docker
    image: docker:1.11
    command: ['cat']
    tty: true
    volumeMounts:
    - name: dockersock
      mountPath: /var/run/docker.sock
  volumes:
  - name: dockersock
    hostPath:
      path: /var/run/docker.sock
  - name: kubectl
    image: gcr.io/cloud-builders/kubectl
    command:
    - cat
    tty: true      
"""
  ) {

  node(label) {
    stage('Build a Maven project') {
      git 'https://github.com/apurvc/springboot.git'
      container('maven') {
          sh 'mvn clean package -DskipTests'
      }
    }
    stage('docker build') {
      git 'https://github.com/apurvc/springboot.git'
      container('docker') {
          sh "docker build -t spring-rest:v1 ."
      }
    }
    stage('Deploy Dev') {
      // Developer Branches
      steps {
        container('kubectl') {
          // Create namespace if it doesn't exist
          sh("kubectl get ns ${env.BRANCH_NAME} || kubectl create ns ${env.BRANCH_NAME}")
          sh("kubectl --namespace=${env.BRANCH_NAME} apply -f deployment.yaml")
          echo 'To access your environment run `kubectl proxy`'
          echo "Then access your service via http://localhost:8001/api/v1/proxy/namespaces/${env.BRANCH_NAME}/services/${feSvcName}:80/"
        }
      }     
    }    
  }
}
