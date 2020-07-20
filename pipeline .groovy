pipeline {
    agent {
        node {
            label 'master'
        }
    }    
    tools {
        maven 'maven'
        jdk 'Java'
    }
    
    stages {
        stage ('Checkout code from SCM') {
            steps {
                git branch: 'main', url: 'https://github.com/spring-projects/spring-petclinic.git'
            }

        }
        stage ('run the simple cmd') {
            steps {
                bat """
                echo "This is step after checkout"
                """
            }

        }
        stage ('Perform build using maven') {
            steps {
                bat """
                    mvn compile
                """
            }
        }
        stage ('Run test') {
            steps {
                bat """
                    mvn test
                """
            }
        }
        stage ('Run package') {
            steps {
                bat """
                    mvn package
                """
            }

        }
    }
}