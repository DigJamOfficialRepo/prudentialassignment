pipeline {
    agent any
    stages {

        stage('initialize'){
        steps{
            sh '''echo $PATH'''
            sh '''echo $JENKINS_HOME'''
            }
        }
        stage('checkout') {
        steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DigJamOfficialRepo/prudentialassignment.git']]])
               }
        }
        stage('build') {
            steps {
                 sh '''/Users/yugveer/Documents/Interviews/apache-maven-3.8.5/bin/mvn clean test'''

            }
        }
    }
    post {
        failure{
        emailext body: '''$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS:

        Check console output at $BUILD_URL to view the results.''', recipientProviders: [culprits()], subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!'
                }
    }
}