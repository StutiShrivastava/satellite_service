pipeline {
    agent any 
    
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                script {
                    if (isUnix()) {
                            sh(script:"mvn clean install", returnStdout: true)
                    } else {
                            bat(script:"mvn clean install -DskipTests", returnStdout: true)
                    }
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
