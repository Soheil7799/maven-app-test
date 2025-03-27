def gv 
pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    parameters {
        string(name: 'VERSION' , defaultValue:'latest' , description:'Please input the version name you want to build and deploy')
    }
    stages {
        stage('initialization'){
            steps{
                script{
                    gv = load 'script.groovy'
                }
            }
        }
        stage('test') {
            steps{
                script{
            gv.testApp()
                }
            }
        }
        stage('build') {
            steps{
                script{
            gv.buildApp()
                }
            }
        }
        stage('deploy') {
            steps{
                script{
            withCredentials([usernamePassword(credentialsId:'docker-hub-repo',usernameVariable: 'USER' , passwordVariable: 'PWD')]){
                gv.dockerLogin(USER , PWD)
            }
            gv.deployApp()
                }
            }
        }
    }
}
