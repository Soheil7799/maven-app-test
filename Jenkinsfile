def gv
pipeline {
    agent any
    parameters{
        choice(name: "NEW_VERSION",choices:["1.3.0", "1.4.0","1.5.0"],description:"Choose the version you are going to deploy")
    }
    // environment{
    //     NEW_VERSION = '1.3.0'
    // }
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
                    gv.buildApp()

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

}