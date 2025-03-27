def gv
pipeline {
    agent any
    parameters{

    }
    environment{
        NEW_VERSION = '1.3.0'
    }
    stages{
        stage("init"){
            steps{
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build"){
            steps{
                echo "building application in Build step ..."
                echo "build version ${NEW_VERSION}"
                script{
                    gv.buildings()

                }
            }
        }
        stage("test"){
            steps{
                echo "here it should test the built app"
            }
        }
        stage("deploy"){
            steps{
                echo "here is where we deploy the app"
            }
        }
        
    }
    post{
        always{
            //executed no matter the result !
        }
        success{

        }
        failure{

        }
    }
}