def gv = load 'script.groovy'
pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    parameters {
        string(name: 'VERSION' , defaultValue:'latest' , description:'Please input the version name you want to build and deploy')
    }
    stages {
        stage('test') {
            gv.testApp()
        }
        stage('build') {
            gv.buildApp()
        }
        stage('deploy') {
            withCredentials([usernamePassword(credentialsId:'docker-hub-repo',usernameVariable: 'USER' , passwordVariable: 'PWD')]){
                gv.dockerLogin(USER , PWD)
            }
            gv.deployApp()
            
        }
    }
}
