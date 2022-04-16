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
        emailext body: 'Build Fail', recipientProviders: [culprits(), buildUser(), developers(), upstreamDevelopers(), brokenBuildSuspects(), brokenTestsSuspects(), requestor()], subject: 'Build Fail'
                }
    }
}