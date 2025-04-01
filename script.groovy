// def buildJar() {
//     echo "building the application..."
//     sh 'mvn package'
// } 

// def buildImage() {
//     echo "building the docker image..."
//     withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//         sh 'docker build -t nanajanashia/demo-app:jma-2.0 .'
//         sh "echo $PASS | docker login -u $USER --password-stdin"
//         sh 'docker push nanajanashia/demo-app:jma-2.0'
//     }
// } 

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
    
    docker build -t soheiliam/demo-jenkins:${params.VERSION} .
    docker push soheiliam/demo-jenkins:${params.VERSION}
    """
} 

return this
