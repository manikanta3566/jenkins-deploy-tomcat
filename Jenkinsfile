pipeline {
    agent any

    environment {
        // Set environment variables if needed
        GIT_REPO = 'https://github.com/manikanta3566/jenkins-deploy-tomcat'
        GIT_BRANCH = 'main'
        MAVEN_HOME = tool 'maven' // assuming "Maven" is configured under Global Tools
        CREDENTIALS_ID = 'b46659c0-8cee-4662-8326-d56aeaf7dd90'
        TOMCAT_SERVER = 'http://localhost:9090/' // e.g., http://yourserver:8080
        TOMCAT_DEPLOY_PATH = '/manager/text/deploy?path=/jenkins-project&update=true'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: "${GIT_BRANCH}", url: "${GIT_REPO}"
            }
        }

        stage('Maven Build') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean package"
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${CREDENTIALS_ID}", usernameVariable: 'TOMCAT_USER', passwordVariable: 'TOMCAT_PASS')]) {
                    script {
                        def warFile = sh(script: "ls target/*.war", returnStdout: true).trim()
                        sh """
                            curl -u $TOMCAT_USER:$TOMCAT_PASS -T ${warFile} "${TOMCAT_SERVER}${TOMCAT_DEPLOY_PATH}"
                        """
                    }
                }
            }
        }
    }
}
