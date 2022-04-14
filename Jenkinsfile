pipeline {
    agent any
    stages {

        stage('checkout'){
        git credentialsId: 'DigJamOfficialRepo', url: 'https://github.com/DigJamOfficialRepo/prudentialassignment.git'
                   // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
        sh "ls -lart ./*"
                   // List all branches in your repo.
        sh "git branch -a"
                   // Checkout to a specific branch in your repo.
        sh "git checkout main"

        }
        stage('build') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}