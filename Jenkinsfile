pipeline {
    agent any
    stages {
        stage('checkout') {
        steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DigJamOfficialRepo/prudentialassignment.git']]])
               }
        }
        stage('build') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}