def buildApp() {
    echo "lets build through scripts ..."
    // echo "getting version info through scripts. Version : ${params.NEW_VERSION}"
    sh "mvn package"
} 
def testApp(){
    echo "testing the application"
    sh "mvn test"
}
def dockerLogin(String username, String password){
    sh """
        echo "logging out"
        docker logout
        echo "logging in"
        docker login -u ${username} -p ${password}
    """

}
def deployApp() {
    // echo "environment to deploy: ${params.DEPLOY_ENV} "

    sh """
    echo 'deploying the application...'
    
    docker build -t soheiliam/demo-jenkins:${params.VERSION}
    docker push soheiliam/demo-jenkins:${params.VERSION}
    """
} 

return this