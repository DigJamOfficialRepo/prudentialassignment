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
        emailext body: '''<p>${buildStatus}: Job \'${env.JOB_NAME} [${env.BUILD_NUMBER}]\':</p> <p>Check console output at &QUOT;<a href=\'${env.BUILD_URL}\'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>''', recipientProviders: [upstreamDevelopers()], subject: 'JENKINS-NOTIFICATION: ${buildStatus}: Job \'${env.JOB_NAME} [${env.BUILD_NUMBER}]\''
           }
    }
}