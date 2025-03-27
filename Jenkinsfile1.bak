def gv
pipeline {
    agent any
    // parameters{
        // choice(name: "NEW_VERSION",choices:["1.3.0", "1.4.0","1.5.0"],description:"Choose the version you are going to deploy")
    // }
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
            input{
                message "write the Version to deploy"
                ok "version selected"
                parameters{
                    string(name:"NEW_VESION",defaultValue:"",description:"version")
                }
            }
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
            input{
                message "select the env to deploy"
                ok "env selected"
                parameters{
                   choice(name: "DEPLOY_ENV",choices:["dev","test","production"],description:"Choose the environment you are going to deploy")
                }
            }
            steps{
                script{
                    gv.deployApp()
                }
            }
        }
        
    }

}