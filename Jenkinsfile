pipeline {
    agent any
    stages{
        stage("build"){
            steps{
                echo "building application in Build step ..."
            }
        }
        stage("test"){
            step{
                echo "here it should test the built app"
            }
        }
        stage("deploy"){
            step{
                echo "here is where we deploy the app"
            }
        }
        
    }
}