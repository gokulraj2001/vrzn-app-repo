pipeline {
    agent any

    tools {
        maven "maven-3.9.6"
    }

    stages {
        stage('Source') {
            steps {    
              checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/gokulraj2001/vrzn-app-repo.git']])
            }
        }
            
            stage('Build') {
            steps {
                bat "mvn -Dmaven.test.failure.ignore=true clean package spring-boot:build-image"
            }
            }

            stage('Build Docker Image') {
            steps {
                bat "docker build -t gokul1221/vrzn-spring-boot-app ."
            }
            }

            stage('Push Docker Image') {
            steps {
              script{
                  withCredentials([string(credentialsId: 'dockerhub_pwd', variable: 'dockerhub_pwd')])  {
                   bat 'docker login -u gokul1221 -p ${dockerhub_pwd}'

}
                    bat "docker push gokul1221/vrzn-spring-boot-app"
                }
            }
            }

    }
            
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                    echo 'Build Success'
                }
            }
        }
    
